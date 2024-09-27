package de.supercode.eshop.mappers;

import de.supercode.eshop.dtos.ArticleDTO;
import de.supercode.eshop.dtos.ArticleListDTO;
import de.supercode.eshop.entitys.articles.Article;
import de.supercode.eshop.entitys.articles.Category;
import de.supercode.eshop.services.CategoryService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ArticleMapper {


    CategoryService categoryService;

    public ArticleMapper(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public ArticleDTO toDTO(Article article) {
        ArticleDTO dto = new ArticleDTO();
        dto.setId(article.getId());
        dto.setName(article.getName());
        dto.setManufacturer(article.getManufacturer());
        dto.setDescription(article.getDescription());
        dto.setPrice(article.getPrice());
        dto.setCategory(article.getCategory().getName());
        dto.setStock(article.getStock());
        dto.setCreatedDate(article.getCreatedDate());
        dto.setLastUpdated(article.getLastUpdated());
        return dto;
    }

    public ArticleListDTO toListDTO(Article article) {
        ArticleListDTO listDto = new ArticleListDTO();
        listDto.setId(article.getId());
        listDto.setName(article.getName());
        listDto.setManufacturer(article.getManufacturer());
        listDto.setPrice(article.getPrice());
        listDto.setCategory(article.getCategory().getName());
        return listDto;
    }

    public Article toEntity(ArticleDTO dto) {
        Article article = new Article();
        article.setId(dto.getId());
        article.setName(dto.getName());
        article.setManufacturer(dto.getManufacturer());
        article.setDescription(dto.getDescription());
        article.setPrice(dto.getPrice());
        if (dto.getCategory() != null) {
            Optional<Category> existingCategory = categoryService.findCategory(dto.getCategory());
            if (existingCategory.isPresent()) article.setCategory(existingCategory.get());
            else {
                Category newCategory = new Category();
                newCategory.setName(dto.getCategory());
                article.setCategory(newCategory);
            }
        }
        article.setStock(dto.getStock());
        return article;
    }
}
