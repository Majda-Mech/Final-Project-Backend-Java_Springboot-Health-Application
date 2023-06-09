package com.example.backendendproject.Services;

import com.example.backendendproject.Dtos.RecipeDto;
import com.example.backendendproject.Models.Recipe;
import com.example.backendendproject.Repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;

@Service
public class RecipeService {
    private final RecipeRepository repos;

    public RecipeService(RecipeRepository repos) {
        this.repos = repos;
    }

    public Long createRecipe(RecipeDto recipeDto, @Valid Long id) {
        Recipe newRecipe = new Recipe();


        newRecipe.setName(recipeDto.name);
        newRecipe.setVegan(recipeDto.isVegan);
        newRecipe.setVegetarian(recipeDto.isVegetarian);
        newRecipe.setProducts(recipeDto.products);


        Recipe savedRecipe = repos.save(newRecipe);
        return newRecipe.getId();
    }

    public Iterable<RecipeOutputDto> getAllRecipes() {
        Iterable<Recipe> recipeList = repos.findAll();
        ArrayList<RecipeOutputDto> recipeDtoList = new ArrayList<>();

        for (Recipe recipe : recipeList) {
            RecipeOutputDto newRecipeDto = new RecipeOutputDto(recipe);
            recipeDtoList.add(newRecipeDto);
        }
        return recipeDtoList;
    }
    public RecipeDto getRecipeById(Long id) {
        if (repos.findById(id).isPresent()) {
            Recipe recipe   = repos.findById(id).get();
            RecipeDto newRecipeDto = new RecipeDto(recipe);
            return newRecipeDto;
        } else {
            throw new RecordNotFoundException("No Recipe found with this ID");
        }
    }
    public void deleteRecipe(Long id) {
        if (repos.findById(id).isPresent()) {
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