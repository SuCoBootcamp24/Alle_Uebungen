package de.supercode.eshop.repositorys;

import de.supercode.eshop.entitys.orders.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findOrdersByCustomerId(long customerId);
}
