package de.supercode.eshop.dtos;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Data
public class ShoppingBasketArticlesDTO {

    private long id;
    private ArticleShortDTO article;  // Artikelinformationen statt nur der ID
    private int quantity;
    private BigDecimal articleTotalPrice;

}