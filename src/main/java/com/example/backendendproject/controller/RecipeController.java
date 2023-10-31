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
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("")
    public ResponseEntity<String> createRecipe(@Valid @RequestBody RecipeDto recipeDto, BindingResult br) {
        Long savedRecipe = recipeService.createRecipe(recipeDto);
        if (br.hasErrors()) {
            return getStringResponseEntity(br);
        } else {
            URI uri = URI.create(
                    ServletUriComponentsBuilder
                            .fromCurrentContextPath()
                            .path("/recipes/" + savedRecipe).toUriString());
            return ResponseEntity.created(uri).body("Product has been created");
        }
    }

    static ResponseEntity<String> getStringResponseEntity(BindingResult br) {
        StringBuilder sb = new StringBuilder();
        for (FieldError fe : br.getFieldErrors()) {
            sb.append(fe.getField() + ": ");
            sb.append(fe.getDefaultMessage());
            sb.append("\n");
        }
        return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("")
    public ResponseEntity<Iterable<RecipeDto>> getAllRecipes() {
        return ResponseEntity.ok(recipeService.getAllRecipes());
    }

    @GetMapping("{id}")
    public ResponseEntity<RecipeDto> getRecipeById(@PathVariable Long id) {
        return ResponseEntity.ok(recipeService.getRecipeById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateRecipe(@PathVariable Long id, @RequestBody Recipe newRecipe) {
        recipeService.updateRecipe(id, newRecipe);
        return ResponseEntity.ok().body("Recipe has been Updated");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
        return ResponseEntity.ok().body("Recipe has been Deleted");
    }
}