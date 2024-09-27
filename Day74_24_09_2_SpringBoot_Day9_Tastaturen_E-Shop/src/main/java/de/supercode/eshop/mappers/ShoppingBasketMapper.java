package de.supercode.eshop.mappers;

import de.supercode.eshop.dtos.ArticleShortDTO;
import de.supercode.eshop.dtos.ShoppingBasketArticlesDTO;
import de.supercode.eshop.dtos.ShoppingBasketDTO;
import de.supercode.eshop.entitys.articles.Article;
import de.supercode.eshop.entitys.orders.ShoppingBasket;
import de.supercode.eshop.entitys.orders.ShoppingBasketArticle;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ShoppingBasketMapper {


        public ShoppingBasketDTO toDTO(ShoppingBasket basket) {
            ShoppingBasketDTO dto = new ShoppingBasketDTO();
            dto.setId(basket.getId());

            Set<ShoppingBasketArticlesDTO> articlesDTO = basket.getShoppingBasketArticles().stream()
                    .map(this::toArticleDTO)
                    .collect(Collectors.toSet());
            dto.setShoppingBasketArticles(articlesDTO);

            BigDecimal totalPrice = articlesDTO.stream()
                    .map(ShoppingBasketArticlesDTO::getArticleTotalPrice)
                            .reduce(BigDecimal.ZERO, BigDecimal::add);
            dto.setBasketTotalPrice(totalPrice);

            return dto;
        }

        public ShoppingBasketArticlesDTO toArticleDTO(ShoppingBasketArticle article) {
            ShoppingBasketArticlesDTO dto = new ShoppingBasketArticlesDTO();
            dto.setId(article.getId());
            dto.setQuantity(article.getQuantity());
            dto.setArticle(toArticleShortDTO(article.getArticle()));
            dto.setArticleTotalPrice(article.getArticle().getPrice().multiply(BigDecimal.valueOf(dto.getQuantity())));

            return dto;
        }

        private ArticleShortDTO toArticleShortDTO(Article article) {
            ArticleShortDTO articleDTO = new ArticleShortDTO();
            articleDTO.setName(article.getName());
            articleDTO.setPrice(article.getPrice());

            return articleDTO;
        }
    }
