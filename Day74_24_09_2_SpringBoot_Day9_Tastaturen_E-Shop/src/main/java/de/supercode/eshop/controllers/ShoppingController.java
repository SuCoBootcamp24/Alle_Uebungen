package de.supercode.eshop.controllers;

import de.supercode.eshop.dtos.OrderDTO;
import de.supercode.eshop.dtos.OrderListDTO;
import de.supercode.eshop.dtos.ShoppingBasketDTO;
import de.supercode.eshop.exeptions.InsufficientQuantityException;
import de.supercode.eshop.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/eshop")
public class ShoppingController {

    OrderService orderService;

    public ShoppingController(OrderService orderService) {
        this.orderService = orderService;
    }


    //---ShoppingBasket-----

    @PostMapping("/cart")
    public ResponseEntity<ShoppingBasketDTO> addArticleToCart(@RequestParam Long customerId, @RequestParam Long itemId, @RequestParam int quantity) {
        ShoppingBasketDTO basketDTO = orderService.addToCart(customerId, itemId, quantity);
        if (basketDTO == null) return ResponseEntity.badRequest().build();
        else return ResponseEntity.ok(basketDTO);
    }

    @GetMapping("/cart/{customerId}")
    public ResponseEntity<ShoppingBasketDTO> getCartByCustomerId(@PathVariable Long customerId) {
        ShoppingBasketDTO basketDTO = orderService.getCartByCustomerId(customerId);
        if (basketDTO == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(basketDTO);
    }

    @PutMapping("/cart/{customerId}")
    public ResponseEntity<ShoppingBasketDTO> updateBasketByCustomerId(@PathVariable Long customerId, @RequestParam Long basketArticleId, @RequestParam int quantity) {
        ShoppingBasketDTO basketDTO = orderService.updateCart(customerId, basketArticleId, quantity);
        if (basketDTO == null) return ResponseEntity.badRequest().build();
        else return ResponseEntity.ok(basketDTO);
    }

    //----Order---

//    @GetMapping("/buy/{customerId}")
//    public ResponseEntity<?> buyArticlesFromBasket(@PathVariable long customerId) {
//        try {
//
//            OrderDTO orderDTO = orderService.buyArticlesFromBasket(customerId);
//            if (orderDTO == null) return ResponseEntity.notFound().build();
//            else return ResponseEntity.ok(orderDTO);
//        } catch (InsufficientQuantityException ex) {
//            return ResponseEntity.status(HttpStatus.CONFLICT).body("Insufficient quantity for the requested article.");
//        } catch (Exception ex) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.");
//        }
//    }

    @GetMapping("/buy/{customerId}")
    public ResponseEntity<?> buyArticlesFromBasket(@PathVariable long customerId) {
            OrderDTO orderDTO = orderService.buyArticlesFromBasket(customerId);
            if (orderDTO == null) return ResponseEntity.notFound().build();
            else return ResponseEntity.ok(orderDTO);
    }

    @GetMapping("/orders/{customerId}")
    public ResponseEntity<OrderListDTO> getAllOrdersByCustomerId(@PathVariable Long customerId) {
        OrderListDTO orderDTOList = orderService.getAllOrdersByCustomerId(customerId);
        if (orderDTOList == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(orderDTOList);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<OrderDTO> getOrderByOrderId(@PathVariable Long orderId){
        OrderDTO order = orderService.getOrderByOrderId(orderId);
        if (order == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(order);
    }


    @GetMapping("/orders")
    public ResponseEntity<List<OrderListDTO>> getAllOrders() {
        List<OrderListDTO> orders = orderService.getAllOrders();
        return orders.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(orders);
    }

    @PutMapping("/order/{orderId}")
    public ResponseEntity<OrderDTO> UpdateOrderStatus(@PathVariable Long orderId, @RequestParam int orderStatus) {
        OrderDTO orderDTO = orderService.updateOrderStatus(orderId, orderStatus);
        if (orderDTO == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(orderDTO);
    }


    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(InsufficientQuantityException.class)
    public String handleInsufficientQuantityException() {
        return "Insufficient quantity";
    }



}
