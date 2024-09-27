package de.supercode.eshop.repositorys;

import de.supercode.eshop.entitys.orders.ShoppingBasketArticle;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingBasketArticleRepository extends CrudRepository<ShoppingBasketArticle, Long> {
}
