package de.supercode.eshop.dtos;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Data
public class OrderItemDTO {

    private String articleName;
    private int quantity;
    private BigDecimal unitPrice;
    private BigDecimal ArticleTotalPrice;


}
