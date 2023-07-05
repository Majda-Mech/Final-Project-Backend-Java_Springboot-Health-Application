package com.example.backendendproject.Controller;

import com.example.backendendproject.Dtos.RecipeDto;
import com.example.backendendproject.Models.Recipe;
import com.example.backendendproject.Services.RecipeService;
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
    private final com.example.backendendproject.Services.RecipeService RecipeService;

    public RecipeController(RecipeService recipeService) {
        this.RecipeService = recipeService;
    }

    @PostMapping("{id}")
    public ResponseEntity<String> createRecipe(@Valid @PathVariable Long id, @RequestBody RecipeDto recipeDto, BindingResult br) {
        Long savedRecipe = RecipeService.createRecipe(recipeDto, id);
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
                            .path("/recipies/" + savedRecipe).toUriString());
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