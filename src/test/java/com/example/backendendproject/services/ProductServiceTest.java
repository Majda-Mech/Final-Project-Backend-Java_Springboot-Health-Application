package com.example.backendendproject.services;

import com.example.backendendproject.Services.ProductService;
import com.example.backendendproject.dtos.ProductDto;
import com.example.backendendproject.models.Product;
import com.example.backendendproject.models.Recipe;
import com.example.backendendproject.repositories.ProductRepository;
import com.example.backendendproject.repositories.RecipeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @Mock
    private static ProductRepository productRepository;

    @Mock
    private RecipeRepository recipeRepository;

    @InjectMocks
    ProductService productService;
    ProductDto productDto;

    @BeforeEach
    void setUp() {
        productDto = new ProductDto("test", "test1", null);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createProduct() {
        //arrange
        Recipe l = new Recipe();
        Product p = new Product();
        p.setId(10L);
        p.setName("test");
        p.setDescription("test1");
        Mockito.when(productRepository.save(any(Product.class))).thenReturn(p);

        Long p3 = productService.createProduct(productDto, 1L);

        Assertions.assertEquals(p.getId(), p3);
    }

    @Test
    public void testGetAllProducts() {
        // Arrange
        List<Product> mockProductList = new ArrayList<>();
        Recipe l = new Recipe();

        for (int i = 0; i < 2; i++) {
            Product p = new Product();
            p.setId((long) i);
            p.setName("product" + i);
            p.setDescription("description" + i);
            p.setRecipe(l);
            mockProductList.add(p);}

        Mockito.when(productRepository.findAll()).thenReturn(mockProductList);

        List<ProductDto> result = productService.getAllProducts();

        Assertions.assertEquals(mockProductList.size(), result.size());

        for (int i = 0; i < mockProductList.size(); i++) {
            Product mockProduct = mockProductList.get(i);
            ProductDto resultProductDto = result.get(i);

            Assertions.assertEquals(mockProduct.getId(), resultProductDto.getId());
            Assertions.assertEquals(mockProduct.getName(), resultProductDto.getName());
            Assertions.assertEquals(mockProduct.getDescription(), resultProductDto.getDescription());
        }}

    @Test
    void getProductById () {
        Recipe l = new Recipe();
        Product p = new Product();
        p.setId(10L);
        p.setName("test");
        p.setDescription("test1");
        Mockito.when(productRepository.findById(any())).thenReturn(Optional.of(p));

        ProductDto p2 = productService.getProductById(10L);

        Assertions.assertEquals(p.getId(),p2.getId());}

    @Test
    void updateProduct_Success () {
        Long productId = 1L;
        Product updateProduct = new Product();
        updateProduct.setId(productId);

        Mockito.when(productRepository.findById(productId)).thenReturn(Optional.of(new Product()));
        Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(updateProduct);

        ProductDto result = productService.updateProduct(productId, updateProduct);

        Assertions.assertEquals(productId, result.getId());     }
}
