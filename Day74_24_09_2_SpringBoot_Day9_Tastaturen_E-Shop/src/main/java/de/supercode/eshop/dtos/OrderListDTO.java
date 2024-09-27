package de.supercode.eshop.dtos;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;


@Component
@Data
public class OrderListDTO {

    private long customerId;
    private List<String> orderLines;

    private BigDecimal totalPrice;

}
