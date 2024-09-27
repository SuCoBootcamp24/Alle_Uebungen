package de.supercode.eshop.dtos;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Data
public class ArticleShortDTO {
    //private Long articleId;
    private String name;
    private BigDecimal price;
}
