//package com.example.backendendproject.services;
//
//import com.example.backendendproject.dtos.ProductDto;
//import com.example.backendendproject.models.Product;
//import com.example.backendendproject.models.Recipe;
//import com.example.backendendproject.repositories.ProductRepository;
//import com.example.backendendproject.repositories.RecipeRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@ExtendWith(MockitoExtension.class)
//class ProductServiceTest {
//    @Mock
//    private ProductRepository productRepository;
//
//    @Mock
//    private RecipeRepository recipeRepository;
//
//    @InjectMocks
//    ProductService productService;
//
//    ProductDto productDto;
//
//    @BeforeEach
//    void setUp() {
//        productDto = new ProductDto("test", "test1", null);
//    }
//
//    @AfterEach
//    void tearDown() {
//    }
//
//    @Test
//    void createProduct() {
//        //arrange
//        Recipe l = new Recipe();
//        Product p = new Product();
//        p.setId(10L);
//        p.setName("test");
//        p.setDescription("test1");
//        Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(p);
//
//        //act
//        Long p3 = productService.createProduct(productDto, 1L);
//
//        //assert
//        Assertions.assertEquals(p.getId(), p3);
//    }
//
//    @Test
//    public void testGetAllProducts() {
//        // Arrange
//        List<Product> mockProductList = new ArrayList<>();
//        Recipe l = new Recipe();
//
//        for (int i = 0; i < 2; i++) {
//            Product p = new Product();
//
//            p.setId((long) i);
//            p.setName("product" + i);
//            p.setDescription("description" + i);
//            p.setRecipe(l);
//
//            mockProductList.add(p);
//        }
//
//        Mockito.when(productRepository.findAll()).thenReturn(mockProductList);
//
//        // Act
//        List<ProductDto> result = productService.getAllProducts();
//
//        // Assert
//        Assertions.assertEquals(mockProductList.size(), result.size());
//
//        for (int i = 0; i < mockProductList.size(); i++) {
//            Product mockProduct = mockProductList.get(i);
//            ProductDto resultProductDto = result.get(i);
//
//            Assertions.assertEquals(mockProduct.getId(), resultProductDto.getId());
//            Assertions.assertEquals(mockProduct.getName(), resultProductDto.getName());
//            Assertions.assertEquals(mockProduct.getDescription(), resultProductDto.getDescription());
//        }}
//
//        @Test
//        void getProductById () {
//            //arrange
//            Recipe l = new Recipe();
//            Product p = new Product();
//            p.setId(10L);
//            p.setName("test");
//            p.setDescription("test1");
//            Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(p);
//
//            //act
//            ProductDto p2 = productService.getProductById(10L);
//            Optional<Product> product = Optional.of(product);
//
//            //assert
//            Assertions.assertEquals(p.getId(),p2.getId());}
////
////        @Test
////        void updateProduct_Success () {
////            //arrange
////            Long productId = 1l;
////            Product updateProduct = new Product();
////            updateProduct.setId(productId);
////
////            Mockito.when(productRepository.findById(productId)).thenReturn(Optional.of(new Product()));
////            Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(updateProduct);
////
////            //act
////            ProductDto result = productService.updateProduct(productId, updateProduct);
////
////            //assert
////            Assertions.assertEquals(result, 1l);
////            Assertions.assertEquals(productId, result.getId());
////
////        }
//
////        @Test
////        void updateProduct_ProductNotFound() {
////            //arrange
////            Long productId = 10l;
////            Product updateProduct = new Product();
////            updateProduct.setId(productId);
////
////            Mockito.when(productRepository.findById(productId)).thenReturn(Optional.of(new Product()));
////            Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(updateProduct);
////
////            //act
////            ProductDto result = productService.updateProduct(productId, updateProduct);
////
////            //assert
////            Assertions.assertEquals(result, 1l);
////            Assertions.assertEquals(productId, result.getId());
////
////        }
//
//
//
//
//        @Test
//        void deleteProduct () {
//        }
//
//        @Test
//        void getProdRepo () {
//        }
//
//        @Test
//        void getRecRepo () {
//        }
//    }
