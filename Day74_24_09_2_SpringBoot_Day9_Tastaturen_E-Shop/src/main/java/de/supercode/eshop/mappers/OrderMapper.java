package de.supercode.eshop.mappers;

import de.supercode.eshop.dtos.OrderDTO;
import de.supercode.eshop.dtos.OrderItemDTO;
import de.supercode.eshop.dtos.OrderListDTO;
import de.supercode.eshop.entitys.orders.Order;
import de.supercode.eshop.entitys.orders.OrderItem;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public OrderDTO toDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setStatus(order.getStatus());

        Set<OrderItemDTO> orderItemDTOList = order.getOrderItems().stream()
                .map(this::toOrderItemDTO)
                .collect(Collectors.toSet());
        dto.setOrderItems(orderItemDTOList);
        dto.setTotalPrice(order.getTotalPrice());

        return dto;
    }


    public OrderItemDTO toOrderItemDTO(OrderItem orderItem) {
        OrderItemDTO dto = new OrderItemDTO();
        dto.setArticleName(orderItem.getArticleName());
        dto.setQuantity(orderItem.getQuantity());
        dto.setUnitPrice(orderItem.getUnitPrice());
        dto.setArticleTotalPrice(orderItem.getUnitPrice().multiply(BigDecimal.valueOf(orderItem.getQuantity())));
        return dto;
    }

    public OrderListDTO toOrderListDTO(List<Order> orderList) {
        OrderListDTO dto = new OrderListDTO();

        dto.setCustomerId(orderList.getFirst().getCustomer().getId());
        List<String> orderLine = orderList.stream()
                .map(o -> {
                    String line = "";
                    line += o.getId() + " ";
                    line += o.getOrderItems().size() + " Items ";
                    line += o.getTotalPrice() + " - ";
                    line += "Status: " + o.getStatus();
                    return line;
                })
                .collect(Collectors.toList());

        dto.setOrderLines(orderLine);

        BigDecimal totalPrice = orderList.stream()
                .map(Order::getTotalPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);

       dto.setTotalPrice(totalPrice);

        return dto;
    }
}
