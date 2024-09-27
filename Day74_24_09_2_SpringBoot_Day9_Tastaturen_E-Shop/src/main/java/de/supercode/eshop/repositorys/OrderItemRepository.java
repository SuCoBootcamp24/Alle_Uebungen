package de.supercode.eshop.repositorys;

import de.supercode.eshop.entitys.orders.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {
}
