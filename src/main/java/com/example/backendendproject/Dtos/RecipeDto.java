package com.example.backendendproject.Dtos;

import com.example.backendendproject.Models.Product;
import com.example.backendendproject.Models.Recipe;
import javax.validation.constraints.NotBlank;
import java.util.List;

public class RecipeDto {

    @NotBlank(message ="Please insert a name for the Recipe" )
    public String name;
    public boolean isVegan;
    public boolean isVegetarian;
    public List<Product> products;

    public RecipeDto(Recipe recipe) {
        this.name = recipe.getName();
        this.isVegan = recipe.isVegan();
        this.isVegetarian = recipe.isVegetarian();
        this.products = recipe.getProducts();
    }
}
