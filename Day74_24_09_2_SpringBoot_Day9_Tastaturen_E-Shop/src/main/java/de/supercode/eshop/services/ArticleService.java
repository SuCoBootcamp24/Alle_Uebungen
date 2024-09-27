package de.supercode.eshop.services;

import de.supercode.eshop.dtos.ArticleDTO;
import de.supercode.eshop.dtos.ArticleListDTO;
import de.supercode.eshop.entitys.articles.Article;
import de.supercode.eshop.entitys.articles.Category;
import de.supercode.eshop.mappers.ArticleMapper;
import de.supercode.eshop.repositorys.ArticleRepository;
import de.supercode.eshop.repositorys.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    ArticleRepository articleRepository;
    ArticleMapper articleMapper;
    CategoryRepository categoryRepository;

    public ArticleService(ArticleRepository articleRepository, ArticleMapper articleMapper, CategoryRepository categoryRepository) {
        this.articleRepository = articleRepository;
        this.articleMapper = articleMapper;
        this.categoryRepository = categoryRepository;
    }

    public ArticleDTO createArticle(ArticleDTO articleDTO) {
        if (articleRepository.findByManufacturerAndName(articleDTO.getManufacturer(), articleDTO.getName()).isPresent()) return null;

        Article article = articleMapper.toEntity(articleDTO);
        articleRepository.save(article);
        return articleMapper.toDTO(article);
    }

    public Optional<Article> findArticleById(Long id) {
        return articleRepository.findById(id);
    }

    public ArticleDTO updateArticle(Long id, ArticleDTO articleDTO) {
        return articleRepository.findById(id).map(existingArticle -> {
                updateArticleDetails(existingArticle, articleDTO);
                articleRepository.save(existingArticle);
                return articleMapper.toDTO(existingArticle);
                })
                .orElse(null);
    }
    
    private void updateArticleDetails(Article existingArticle, ArticleDTO articleDTO) {
        Optional.ofNullable(articleDTO.getManufacturer()).ifPresent(existingArticle::setManufacturer);
        Optional.ofNullable(articleDTO.getName()).ifPresent(existingArticle::setName);
        Optional.ofNullable(articleDTO.getPrice()).ifPresent(existingArticle::setPrice);
        Optional.ofNullable(articleDTO.getStock()).ifPresent(existingArticle::setStock);
        Optional.ofNullable(articleDTO.getDescription()).ifPresent(existingArticle::setDescription);
        updateCategoryIfNecessary(existingArticle, articleDTO);
    }

    private void updateCategoryIfNecessary(Article existingArticle, ArticleDTO articleDTO) {
        if (articleDTO.getCategory() != null && !existingArticle.getCategory().getName().equals(articleDTO.getCategory())) {
            Category category = categoryRepository.findByName(articleDTO.getCategory())
                    .orElseGet(() -> createNewCategory(articleDTO.getCategory()));
            existingArticle.setCategory(category);
        }
    }

    private Category createNewCategory(String categoryName) {
        Category newCategory = new Category();
        newCategory.setName(categoryName);
        return categoryRepository.save(newCategory);
    }


    public List<ArticleListDTO> getAllArticles() {
        return articleRepository.findAll().stream()
                .map(articleMapper::toListDTO)
                .sorted((a1, a2) -> a2.getCategory().compareTo(a1.getCategory()))
                .collect(Collectors.toList());
    }


    public ArticleDTO getArticle(Long id) {
        return articleRepository.findById(id).map(articleMapper::toDTO).orElse(null);
    }


    public boolean deleteArticle(Long id) {
        return articleRepository.findById(id).map(article -> {
            articleRepository.delete(article);
            return true;
        }).orElse(false);
    }

    public void updateArticleStock(Article article, int newStock) {
        article.setStock(newStock);
        articleRepository.save(article);
    }
}
