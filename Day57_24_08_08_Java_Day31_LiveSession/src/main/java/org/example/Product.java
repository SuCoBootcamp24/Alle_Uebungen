package org.example;
public class Product {
    private String name;
    private String description;
    private float price;
    private String articleNr;

    private Category productCategory;

    public Product(String name, String description, float price, String articleNr, Category productCategory) {
        this.setName(name);
        this.setDescription(description);
        this.setPrice(price);
        this.setArticleNr(articleNr);
        this.setProductCategory(productCategory);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.trim().length() == 0) throw new IllegalArgumentException("Name must be set");
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description == null || description.trim().length() == 0) throw new IllegalArgumentException("Description must be set");
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        if(price < 0.0f) throw new IllegalArgumentException("Price must be positive.");
        this.price = price;
    }

    public String getArticleNr() {
        return articleNr;
    }

    public void setArticleNr(String articleNr) {
        if(articleNr == null || articleNr.trim().length() == 0) throw new IllegalArgumentException("ArticleNumber must be set");
        this.articleNr = articleNr;
    }

    public Category getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Category productCategory) {
        this.productCategory = productCategory;
    }

    @Override
    public String toString() {
        return STR."Product{name='\{name}\{'\''}, description='\{description}\{'\''}, price=\{price}, articleNr='\{articleNr}\{'\''}\{'}'}";
    }
}