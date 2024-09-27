package de.supercode.eshop.services;

import de.supercode.eshop.entitys.articles.Category;
import de.supercode.eshop.repositorys.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Optional<Category> findCategory(String category) {
        return categoryRepository.findByName(category);
    }
}
