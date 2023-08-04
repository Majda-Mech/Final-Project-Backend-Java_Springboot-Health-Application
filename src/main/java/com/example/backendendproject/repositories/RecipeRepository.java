package com.example.backendendproject.repositories;

import com.example.backendendproject.models.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
