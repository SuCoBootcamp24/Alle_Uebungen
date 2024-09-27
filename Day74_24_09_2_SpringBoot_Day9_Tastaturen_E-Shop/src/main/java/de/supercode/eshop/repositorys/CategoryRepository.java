package de.supercode.eshop.repositorys;

import de.supercode.eshop.entitys.articles.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findByName(String name);
}
