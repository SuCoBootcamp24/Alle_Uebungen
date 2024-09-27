package de.supercode.eshop.dtos;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
@Data
public class ArticleListDTO {

        private long id;

        private String manufacturer;

        private String name;

        private BigDecimal price;

        private String category;



}
