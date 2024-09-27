package de.supercode.eshop.services;

import de.supercode.eshop.dtos.OrderDTO;
import de.supercode.eshop.dtos.OrderListDTO;
import de.supercode.eshop.dtos.ShoppingBasketDTO;
import de.supercode.eshop.entitys.articles.Article;
import de.supercode.eshop.entitys.orders.Order;
import de.supercode.eshop.entitys.orders.OrderItem;
import de.supercode.eshop.entitys.orders.ShoppingBasket;
import de.supercode.eshop.entitys.persons.Customer;
import de.supercode.eshop.enums.Status;
import de.supercode.eshop.exeptions.InsufficientQuantityException;
import de.supercode.eshop.mappers.OrderMapper;
import de.supercode.eshop.mappers.ShoppingBasketMapper;
import de.supercode.eshop.repositorys.OrderItemRepository;
import de.supercode.eshop.repositorys.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderService {

    OrderMapper orderMapper;
    OrderRepository orderRepository;
    OrderItemRepository orderItemRepository;
    ShoppingBasketService shoppingBasketService;
    ShoppingBasketMapper shoppingBasketMapper;
    ArticleService articleService;
    CustomerService customerService;


    public OrderService(OrderMapper orderMapper, OrderRepository orderRepository,OrderItemRepository orderItemRepository,
                        ShoppingBasketService shoppingBasketService, ShoppingBasketMapper shoppingBasketMapper,
                        ArticleService articleService, CustomerService customerService) {
        this.orderMapper = orderMapper;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.shoppingBasketService = shoppingBasketService;
        this.shoppingBasketMapper = shoppingBasketMapper;
        this.articleService = articleService;
        this.customerService = customerService;
    }




    @Transactional
    public ShoppingBasketDTO addToCart(Long customerId, Long itemId, int quantity) {
        return customerService.findCustomerById(customerId)
                .filter(customer -> quantity > 0)
                .map(customer -> {
                    ShoppingBasket basket = shoppingBasketService.findOrCreateBasket(customer);
                    if (!shoppingBasketService.addToCart(basket, itemId, quantity)) return null;
                    return shoppingBasketMapper.toDTO(basket);
                })
                .orElse(null);
    }

    public ShoppingBasketDTO getCartByCustomerId(Long customerId) {
        return customerService.findCustomerById(customerId)
                .flatMap(customer -> shoppingBasketService.findBasketByCustomerId(customer.getId()))
                .map(shoppingBasketMapper::toDTO)
                .orElse(null);
    }

    public ShoppingBasketDTO updateCart(Long customerId, Long itemId, int quantity) {
        Optional<Customer> existCustomer = customerService.findCustomerById(customerId);
        return existCustomer.map(customer -> shoppingBasketService.updateCart(customer, itemId, quantity)).orElse(null);
    }

    @Transactional
    public OrderDTO buyArticlesFromBasket(long customerId) {
        Optional<Customer> existCustomer = customerService.findCustomerById(customerId);
        Optional<ShoppingBasket> existBasket = shoppingBasketService.findBasketByCustomerId(customerId);

        if (existCustomer.isEmpty() || existBasket.isEmpty()) return null;

        Order newOrder = creatOrder(existCustomer.get());
        creatNewOrderItemListWithItems(existBasket.get(), newOrder);
        newOrder.setTotalPrice(calculateTotalPrice(newOrder));

        newOrder = orderRepository.save(newOrder);
        deleteBasket(existCustomer.get(), existBasket.get());

        return orderMapper.toDTO(newOrder);
    }

    private BigDecimal calculateTotalPrice(Order newOrder) {
        return newOrder.getOrderItems().stream()
                .map(item -> item.getUnitPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private void deleteBasket(Customer existCustomer, ShoppingBasket existBasket) {
        shoppingBasketService.deleteBasket(existBasket);
        customerService.deleteBasket(existCustomer);
    }

    private void creatNewOrderItemListWithItems(ShoppingBasket existBasket, Order order) {
        Set<OrderItem> newOrderItemList = existBasket.getShoppingBasketArticles().stream()
                .map(basketArticle -> {
                    Article article = articleService.findArticleById(basketArticle.getArticle().getId()).orElse(null);
                    if (article == null) return null;

                    int newStock = article.getStock() - basketArticle.getQuantity();
                    if (newStock < 0) throw new InsufficientQuantityException();
                    articleService.updateArticleStock(article, newStock);

                    OrderItem orderItem = createOrderItem(article, basketArticle.getQuantity(), order);
                    return orderItemRepository.save(orderItem);
                })
                .collect(Collectors.toSet());

        order.getOrderItems().clear();
        order.getOrderItems().addAll(newOrderItemList);
        orderRepository.save(order);
    }

    private OrderItem createOrderItem(Article article, int quantity, Order order) {
        OrderItem orderItem = new OrderItem();
        orderItem.setArticleName(article.getName());
        orderItem.setQuantity(quantity);
        orderItem.setUnitPrice(article.getPrice());
        orderItem.setOrder(order);
        return orderItem;
    }

    private Order creatOrder(Customer existCustomer) {
        Order newOrder = new Order();
        newOrder.setCustomer(existCustomer);
        newOrder.setStatus(Status.ORDERED);
        newOrder = orderRepository.save(newOrder);
        return newOrder;
    }

    public OrderListDTO getAllOrdersByCustomerId(Long customerId) {
        Optional<Customer> existCustomer = customerService.findCustomerById(customerId);
        if (existCustomer.isEmpty()) return null;

        List<Order> orderList = orderRepository.findOrdersByCustomerId(existCustomer.get().getId());
        return orderMapper.toOrderListDTO(orderList);
    }


    public List<OrderListDTO> getAllOrders() {

        Map<Customer, List<Order>> ordersGroupedByCustomer = orderRepository.findAll().stream()
                .collect(Collectors.groupingBy(Order::getCustomer));

        return ordersGroupedByCustomer.entrySet().stream()
                .map(entry -> {
                    Customer customer = entry.getKey();
                    List<Order> customerOrders = entry.getValue();
                    return orderMapper.toOrderListDTO(customerOrders);
                })
                .collect(Collectors.toList());

    }

    public OrderDTO updateOrderStatus(Long orderId, int orderStatus) {
        return orderRepository.findById(orderId)
                .map(order -> {
                    order.setStatus(Status.values()[orderStatus]);
                    return orderMapper.toDTO(orderRepository.save(order));
                })
                .orElse(null);
    }

    public OrderDTO getOrderByOrderId(Long orderId) {
        return orderRepository.findById(orderId)
               .map(orderMapper::toDTO)
               .orElse(null);
    }
}
