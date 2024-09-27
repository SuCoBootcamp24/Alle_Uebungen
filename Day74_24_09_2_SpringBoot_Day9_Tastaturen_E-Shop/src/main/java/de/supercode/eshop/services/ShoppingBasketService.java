package de.supercode.eshop.services;

import de.supercode.eshop.dtos.ShoppingBasketDTO;
import de.supercode.eshop.entitys.articles.Article;
import de.supercode.eshop.entitys.orders.ShoppingBasket;
import de.supercode.eshop.entitys.orders.ShoppingBasketArticle;
import de.supercode.eshop.entitys.persons.Customer;
import de.supercode.eshop.mappers.ShoppingBasketMapper;
import de.supercode.eshop.repositorys.ShoppingBasketArticleRepository;
import de.supercode.eshop.repositorys.ShoppingBasketRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingBasketService {

    ShoppingBasketRepository shoppingBasketRepository;
    ShoppingBasketArticleRepository shoppingBasketArticleRepository;
    ShoppingBasketMapper shoppingBasketMapper;


    ArticleService articleService;
    CustomerService customerService;


    public ShoppingBasketService(ShoppingBasketRepository shoppingBasketRepository, ShoppingBasketArticleRepository shoppingBasketArticleRepository,
                                 ShoppingBasketMapper shoppingBasketMapper, ArticleService articleService, CustomerService customerService) {
        this.shoppingBasketRepository = shoppingBasketRepository;
        this.shoppingBasketArticleRepository = shoppingBasketArticleRepository;
        this.shoppingBasketMapper = shoppingBasketMapper;
        this.articleService = articleService;
        this.customerService = customerService;
    }

    public Optional<ShoppingBasket> findBasketByCustomerId(Long customerId) {
        return shoppingBasketRepository.findByCustomerId(customerId);
    }


    public ShoppingBasket createBasket(Customer customer) {
        ShoppingBasket shoppingBasket = new ShoppingBasket();
        shoppingBasket.setCustomer(customer);
        shoppingBasket = shoppingBasketRepository.save(shoppingBasket);
        customerService.upgradeCustomerBasket(customer, shoppingBasket);
        return shoppingBasket;
    }

    public boolean addToCart(ShoppingBasket basket, Long itemId, int quantity) {
        Optional<Article> existArticle = articleService.findArticleById(itemId);
        if (existArticle.isEmpty()) return false;

        ShoppingBasketArticle newBasketArticle = createBasketArticle(existArticle.get(), basket, quantity);

        basket.getShoppingBasketArticles().add(newBasketArticle);
        shoppingBasketRepository.save(basket);
        return true;
    }

    public ShoppingBasket findOrCreateBasket(Customer customer) {
        return findBasketByCustomerId(customer.getId()).orElseGet(() -> createBasket(customer));
    }

    public ShoppingBasketDTO updateCart(Customer customer, Long basketArticleId, int quantity) {
        ShoppingBasket basket = findBasketByCustomerId(customer.getId()).orElse(null);
        if (basket == null) return null;

        ShoppingBasketArticle existArticle = basket.getShoppingBasketArticles().stream()
                .filter(basketArticle -> basketArticle.getId() == basketArticleId)
                .findFirst()
                .orElse(null);

        if (existArticle == null) return null;

        if (quantity < 1) {
            removeArticleFromBasket(basket, existArticle);
        } else {
            updateArticleQuantity(existArticle, quantity);
        }

        return shoppingBasketMapper.toDTO(basket);
    }

    //----- private()-----

    private ShoppingBasketArticle createBasketArticle(Article article, ShoppingBasket basket, int quantity) {
        ShoppingBasketArticle newBasketArticle = new ShoppingBasketArticle();

        newBasketArticle.setArticle(article);
        newBasketArticle.setQuantity(quantity);
        newBasketArticle.setShoppingBasket(basket);

        return shoppingBasketArticleRepository.save(newBasketArticle);
    }

    private void removeArticleFromBasket(ShoppingBasket basket, ShoppingBasketArticle article) {
        shoppingBasketArticleRepository.delete(article);
        basket.getShoppingBasketArticles().remove(article);
        shoppingBasketRepository.save(basket);
    }

    private void updateArticleQuantity(ShoppingBasketArticle article, int quantity) {
        article.setQuantity(quantity);
        shoppingBasketArticleRepository.save(article);
    }

    public void deleteBasket(ShoppingBasket existBasket) {
        existBasket.getShoppingBasketArticles().clear();
        shoppingBasketRepository.save(existBasket);
        shoppingBasketRepository.delete(existBasket);
    }
}
