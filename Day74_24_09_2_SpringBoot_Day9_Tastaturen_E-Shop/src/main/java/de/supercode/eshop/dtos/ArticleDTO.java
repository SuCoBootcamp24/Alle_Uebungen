package de.supercode.eshop.dtos;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Component
@Data
public class ArticleDTO {

        private long id;

        private String manufacturer;

        private String name;

        private BigDecimal price;

        private String category;

        private Integer stock;

        private String description;

        private LocalDateTime createdDate;

        private LocalDateTime lastUpdated;



}
