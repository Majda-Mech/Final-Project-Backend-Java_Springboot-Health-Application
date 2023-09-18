package com.example.backendendproject.controller;

import com.example.backendendproject.dtos.RecipeDto;
import com.example.backendendproject.models.Recipe;
import com.example.backendendproject.services.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
    private final com.example.backendendproject.services.RecipeService RecipeService;

    public RecipeController(RecipeService recipeService) {
        this.RecipeService = recipeService;
    }

    @PostMapping("")
    public ResponseEntity<String> createRecipe(@Valid @RequestBody RecipeDto recipeDto, BindingResult br) {
        Long savedRecipe = RecipeService.createRecipe(recipeDto);
        if (br.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            for (FieldError fe : br.getFieldErrors()) {
                sb.append(fe.getField() + ": ");
                sb.append(fe.getDefaultMessage());
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        } else {
            URI uri = URI.create(
                    ServletUriComponentsBuilder
                            .fromCurrentContextPath()
                            .path("/recipes/" + savedRecipe).toUriString());
            return ResponseEntity.created(uri).body("Product has been created");
        }
    }

    @GetMapping("")
    public ResponseEntity<Iterable<RecipeDto>> getAllRecipes() {
        return ResponseEntity.ok(RecipeService.getAllRecipes());
    }

    @GetMapping("{id}")
    public ResponseEntity<RecipeDto> getRecipeById(@PathVariable Long id) {
        return ResponseEntity.ok(RecipeService.getRecipeById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateRecipe(@PathVariable Long id, @RequestBody Recipe newRecipe) {
        RecipeService.updateRecipe(id, newRecipe);
        return ResponseEntity.ok().body("Recipe has been Updated");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteRecipe(@PathVariable Long id) {
        RecipeService.deleteRecipe(id);
        return ResponseEntity.ok().body("Recipe has been Deleted");
    }
}