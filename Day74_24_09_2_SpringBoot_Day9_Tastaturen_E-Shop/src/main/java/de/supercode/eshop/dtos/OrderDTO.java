package de.supercode.eshop.dtos;

import de.supercode.eshop.enums.Status;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Set;

@Component
@Data
public class OrderDTO {

    private long id;

    private Status status;

    private Set<OrderItemDTO> orderItems;

    private BigDecimal totalPrice;


}
