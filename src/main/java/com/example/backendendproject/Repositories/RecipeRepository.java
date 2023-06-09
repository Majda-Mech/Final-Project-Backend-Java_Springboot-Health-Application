package com.example.backendendproject.Repositories;

import com.example.backendendproject.Models.Recipe;
import com.example.endprojectsmechapplication.Models.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
