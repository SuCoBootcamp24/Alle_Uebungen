package de.supercode.eshop.entitys.articles;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Category {
    @Id
    private String name;

}
