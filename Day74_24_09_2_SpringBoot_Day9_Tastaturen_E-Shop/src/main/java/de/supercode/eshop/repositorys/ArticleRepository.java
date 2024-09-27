package de.supercode.eshop.repositorys;

import de.supercode.eshop.entitys.articles.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Override
    Optional<Article> findById(Long id);

    Optional<Article> findByManufacturerAndName(String manufacturer, String name);

}
