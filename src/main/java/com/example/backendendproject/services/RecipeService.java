package com.example.backendendproject.Services;

import com.example.backendendproject.Dtos.RecipeDto;
import com.example.backendendproject.Exceptions.DeleteRecordException;
import com.example.backendendproject.Exceptions.RecordNotFoundException;
import com.example.backendendproject.Exceptions.UpdateRecordException;
import com.example.backendendproject.Models.Product;
import com.example.backendendproject.Models.Recipe;
import com.example.backendendproject.Repositories.ProductRepository;
import com.example.backendendproject.Repositories.RecipeRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {
    private final RecipeRepository repos;
    private final ProductRepository productRepository;

    public RecipeService(RecipeRepository repos,ProductRepository productRepository) {
        this.repos = repos;
        this.productRepository = productRepository;
    }

    public Long createRecipe(RecipeDto recipeDto) {
        Recipe newRecipe = new Recipe();

        newRecipe.setName(recipeDto.name);
        newRecipe.setVegan(recipeDto.isVegan);
        newRecipe.setVegetarian(recipeDto.isVegetarian);
        newRecipe.setProducts(recipeDto.products);

        Recipe savedRecipe = repos.save(newRecipe);
        return newRecipe.getId();
    }

    public Iterable<RecipeDto> getAllRecipes() {
        Iterable<Recipe> recipeList = repos.findAll();
        ArrayList<RecipeDto> recipeDtoList = new ArrayList<>();

        for (Recipe recipe : recipeList) {
            RecipeDto newRecipeDto = new RecipeDto(recipe);
            recipeDtoList.add(newRecipeDto);
        }
        return recipeDtoList;
    }
    public RecipeDto getRecipeById(Long id) {
        if (repos.findById(id).isPresent()) {
            Recipe recipe = repos.findById(id).get();
            RecipeDto newRecipeDto = new RecipeDto(recipe);
            return newRecipeDto;
        } else {
            throw new RecordNotFoundException("No Recipe found with this ID");
        }
    }
    public void deleteRecipe(Long id) {
        if (repos.findById(id).isPresent()) {

          Recipe recipe = repos.findById(id).get();
            List<Product> productList = recipe.getProducts();
            for (Product product : productList){
                product.setRecipe(null);
                productRepository.save(product);
            }
            repos.deleteById(id);

        } else {
            throw new DeleteRecordException("No Recipe found with this ID");
        }
    }
    public RecipeDto updateRecipe(Long id, Recipe newRecipe) {

        if(repos.findById(id).isPresent()) {
            newRecipe.setId(id);
            repos.save(newRecipe);
            return new RecipeDto(newRecipe);
        }
        else {
            throw new UpdateRecordException("No Recipe found with this ID");
        }
    }
}