//package com.example.backendendproject.services;
//
//import com.example.backendendproject.dtos.RecipeDto;
//import com.example.backendendproject.exceptions.DeleteRecordException;
//import com.example.backendendproject.exceptions.RecordNotFoundException;
//import com.example.backendendproject.exceptions.UpdateRecordException;
//import com.example.backendendproject.models.Product;
//import com.example.backendendproject.models.Recipe;
//import com.example.backendendproject.repositories.RecipeRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.test.context.ActiveProfiles;
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//@ActiveProfiles("test")
//class RecipeServiceTest {
//
//    @Mock
//    private RecipeRepository mockRepos;
//
//    private RecipeService recipeServiceUnderTest;
//
//    @BeforeEach
//    void setUp() {
//        recipeServiceUnderTest = new RecipeService(mockRepos);
//    }
//
//    @Test
//    void shouldCreateRecipe() {
//        Recipe recipe = new Recipe();
//        Product product = new Product();
//        product.setId(0L);
//        product.setName("name");
//        product.setDescription("description");
//        recipe.setProducts(List.of(product));
//        recipe.setId(0L);
//        recipe.setName("name");
//        recipe.setVegan(false);
//        recipe.setVegetarian(false);
//        RecipeDto recipeDto = new RecipeDto(recipe);
//
//        Recipe recipe1 = new Recipe();
//        Product product1 = new Product();
//        product1.setId(1L);
//        product1.setName("name");
//        product1.setDescription("description");
//        recipe1.setProducts(List.of(product1));
//        recipe1.setId(0L);
//        recipe1.setName("name");
//        recipe1.setVegan(false);
//        recipe1.setVegetarian(false);
//
//        when(mockRepos.save(any(Recipe.class))).thenReturn(recipe1);
//
//        Long result = recipeServiceUnderTest.createRecipe(recipeDto);
//
//        assertThat(result).isEqualTo(result);
//    }
//
//    @Test
//    void shouldGetAllRecipes() {
//        Recipe recipe = new Recipe();
//        Product product = new Product();
//        product.setId(0L);
//        product.setName("name");
//        product.setDescription("description");
//        recipe.setProducts(List.of(product));
//        recipe.setId(0L);
//        recipe.setName("name");
//        recipe.setVegan(false);
//        recipe.setVegetarian(false);
//        Iterable<Recipe> recipes = List.of(recipe);
//
//        when(mockRepos.findAll()).thenReturn(recipes);
//
//        Iterable<RecipeDto> result = recipeServiceUnderTest.getAllRecipes();
//    }
//
//    @Test
//    void checkRecipeRepo() {
//        when(mockRepos.findAll()).thenReturn(Collections.emptyList());
//
//        Iterable<RecipeDto> result = recipeServiceUnderTest.getAllRecipes();
//    }
//
//    @Test
//    void shouldGetRecipeById() {
//        Recipe recipe1 = new Recipe();
//        Product product = new Product();
//        product.setId(0L);
//        product.setName("name");
//        product.setDescription("description");
//        recipe1.setProducts(List.of(product));
//        recipe1.setId(0L);
//        recipe1.setName("name");
//        recipe1.setVegan(false);
//        recipe1.setVegetarian(false);
//        Optional<Recipe> recipe = Optional.of(recipe1);
//        when(mockRepos.findById(0L)).thenReturn(recipe);
//
//        RecipeDto result = recipeServiceUnderTest.getRecipeById(0L);
//
//    }
//
//    @Test
//    void checkRecordNotFoundException() {
//        when(mockRepos.findById(0L)).thenReturn(Optional.empty());
//
//        assertThatThrownBy(() -> recipeServiceUnderTest.getRecipeById(0L)).isInstanceOf(RecordNotFoundException.class);
//    }
//
//    @Test
//    void shouldDeleteRecipe() {
//        Recipe recipe1 = new Recipe();
//        Product product = new Product();
//        product.setId(0L);
//        product.setName("name");
//        product.setDescription("description");
//        recipe1.setProducts(List.of(product));
//        recipe1.setId(0L);
//        recipe1.setName("name");
//        recipe1.setVegan(false);
//        recipe1.setVegetarian(false);
//        Optional<Recipe> recipe = Optional.of(recipe1);
//        when(mockRepos.findById(0L)).thenReturn(recipe);
//
//        recipeServiceUnderTest.deleteRecipe(0L);
//
//        verify(mockRepos).deleteById(0L);
//    }
//
//    @Test
//    void checkDeleteRecordException() {
//        when(mockRepos.findById(0L)).thenReturn(Optional.empty());
//
//        assertThatThrownBy(() -> recipeServiceUnderTest.deleteRecipe(0L)).isInstanceOf(DeleteRecordException.class);
//    }
//
//    @Test
//    void shouldUpdateRecipe() {
//        Recipe newRecipe = new Recipe();
//        Product product = new Product();
//        product.setId(0L);
//        product.setName("name");
//        product.setDescription("description");
//        newRecipe.setProducts(List.of(product));
//        newRecipe.setId(0L);
//        newRecipe.setName("name");
//        newRecipe.setVegan(false);
//        newRecipe.setVegetarian(false);
//
//        Recipe recipe1 = new Recipe();
//        Product product1 = new Product();
//        product1.setId(0L);
//        product1.setName("name");
//        product1.setDescription("description");
//        recipe1.setProducts(List.of(product1));
//        recipe1.setId(0L);
//        recipe1.setName("name");
//        recipe1.setVegan(false);
//        recipe1.setVegetarian(false);
//        Optional<Recipe> recipe = Optional.of(recipe1);
//        when(mockRepos.findById(0L)).thenReturn(recipe);
//
//        Recipe recipe2 = new Recipe();
//        Product product2 = new Product();
//        product2.setId(0L);
//        product2.setName("name");
//        product2.setDescription("description");
//        recipe2.setProducts(List.of(product2));
//        recipe2.setId(0L);
//        recipe2.setName("name");
//        recipe2.setVegan(false);
//        recipe2.setVegetarian(false);
//        when(mockRepos.save(any(Recipe.class))).thenReturn(recipe2);
//
//        RecipeDto result = recipeServiceUnderTest.updateRecipe(0L, newRecipe);
//
//        verify(mockRepos).save(any(Recipe.class));
//    }
//
//    @Test
//    void CheckUpdateRecordException() {
//        Recipe newRecipe = new Recipe();
//        Product product = new Product();
//        product.setId(0L);
//        product.setName("name");
//        product.setDescription("description");
//        newRecipe.setProducts(List.of(product));
//        newRecipe.setId(0L);
//        newRecipe.setName("name");
//        newRecipe.setVegan(false);
//        newRecipe.setVegetarian(false);
//
//        when(mockRepos.findById(0L)).thenReturn(Optional.empty());
//
//        assertThatThrownBy(() -> recipeServiceUnderTest.updateRecipe(0L, newRecipe))
//                .isInstanceOf(UpdateRecordException.class);
//    }
//}