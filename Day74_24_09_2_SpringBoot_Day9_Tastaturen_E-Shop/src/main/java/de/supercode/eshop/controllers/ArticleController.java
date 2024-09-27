package de.supercode.eshop.controllers;


import de.supercode.eshop.dtos.ArticleDTO;
import de.supercode.eshop.dtos.ArticleListDTO;
import de.supercode.eshop.services.ArticleService;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/eshop/article")
public class ArticleController {

    ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping
    public ResponseEntity<ArticleDTO> createArticle(@RequestBody ArticleDTO articleDTO) {
            ArticleDTO dto = articleService.createArticle(articleDTO);

            if (dto == null) return ResponseEntity.badRequest().build();
            else return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDTO> getArticleById(@PathVariable Long id) {
        ArticleDTO dto = articleService.getArticle(id);

        if (dto == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<ArticleListDTO>> getAllArticles() {
       List<ArticleListDTO> allArticles = articleService.getAllArticles();
        if (allArticles.isEmpty()) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(allArticles);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ArticleDTO> updateArticle(@PathVariable Long id, @RequestBody ArticleDTO articleDTO) {
        ArticleDTO existArticle = articleService.updateArticle(id, articleDTO);
        if (existArticle == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(existArticle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        return articleService.deleteArticle(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String,String> handleValidationError(ConstraintViolationException ex){
        Map<String,String> errorMap = new HashMap<>();
        ex.getConstraintViolations()
                .forEach(violation-> {
                    String fieldName = violation.getPropertyPath().toString();
                    String errorMessage = violation.getMessage();
                    errorMap.put(fieldName,errorMessage);
                });
        return errorMap;
    }
}
