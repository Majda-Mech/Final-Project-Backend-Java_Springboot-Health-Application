package com.example.backendendproject.dtos;

import com.example.backendendproject.models.Product;
import com.example.backendendproject.models.Recipe;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ProductDto {
    @NotBlank(message = "fill in a Product Name")
    public String name;

    @NotBlank(message = "Describe your product")
    public String description;
    public Recipe recipe;

    public ProductDto(String name, String description, Recipe recipe) {
        this.name = name;
        this.description = description;
        this.recipe = recipe;
    }

    public ProductDto(Product product) {
    }
}
