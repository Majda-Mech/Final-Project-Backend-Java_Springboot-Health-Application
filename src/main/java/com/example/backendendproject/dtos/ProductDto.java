package com.example.backendendproject.Dtos;

import com.example.backendendproject.Models.Product;
import com.example.backendendproject.Models.Recipe;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ProductDto {
    @NotBlank(message = "fill in a Product Name")
    public String name;
    public Long id;
    @NotBlank(message = "Describe your product")
    public String description;
    public Recipe recipe;

    public ProductDto(String name, String description, Recipe recipe) {
        this.name = name;
        this.description = description;
        this.recipe = recipe;
    }

    public ProductDto(Product product) {
        this.name= product.getName();
        this.description = product.getDescription();
        this.recipe = product.getRecipe();
        this.id= product.getId();
    }
    public ProductDto() {
    }
}
