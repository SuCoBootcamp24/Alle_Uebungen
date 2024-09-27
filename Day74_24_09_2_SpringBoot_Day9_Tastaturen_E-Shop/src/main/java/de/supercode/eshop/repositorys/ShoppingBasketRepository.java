package de.supercode.eshop.repositorys;

import de.supercode.eshop.entitys.orders.ShoppingBasket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShoppingBasketRepository extends JpaRepository<ShoppingBasket, Long> {
    Optional<ShoppingBasket> findByCustomerId(Long customerId);


}
