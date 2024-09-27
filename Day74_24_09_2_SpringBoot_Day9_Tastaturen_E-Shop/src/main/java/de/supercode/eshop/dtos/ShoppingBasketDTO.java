package de.supercode.eshop.dtos;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Set;

@Component
@Data
public class ShoppingBasketDTO {

    private long id;

    private Set<ShoppingBasketArticlesDTO> shoppingBasketArticles;

    private BigDecimal BasketTotalPrice;
}
