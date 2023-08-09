package com.example.backendendproject.services;

import com.example.backendendproject.dtos.ProductDto;
import com.example.backendendproject.exceptions.DeleteRecordException;
import com.example.backendendproject.exceptions.RecordNotFoundException;
import com.example.backendendproject.exceptions.UpdateRecordException;
import com.example.backendendproject.models.Product;
import com.example.backendendproject.repositories.ProductRepository;
import com.example.backendendproject.repositories.RecipeRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Service
public class ProductService {
    private final ProductRepository prodRepo;
    private final RecipeRepository recRepo;

    public ProductService(ProductRepository prodRepo, RecipeRepository recRepo) {
        this.prodRepo = prodRepo;
        this.recRepo = recRepo;
    }

    public Long createProduct(ProductDto productDto, Long recipeId) {
            Product newProduct = new Product();
            newProduct.setName(productDto.name);
            newProduct.setDescription(productDto.description);
            Product savedProduct = prodRepo.save(newProduct);

            return savedProduct.getId();
    }

    public List<ProductDto> getAllProducts() {
        List<Product> productList = prodRepo.findAll();
        ArrayList<ProductDto> productDtoList = new ArrayList<>();

        for (Product product : productList) {
            ProductDto newProductDto = new ProductDto(product);
            newProductDto.setId(product.getId());
            newProductDto.setName(product.getName());
            newProductDto.setDescription(product.getDescription());
            productDtoList.add(newProductDto);
        }
        return productDtoList;
    }

    public ProductDto getProductById(Long id) {
        if (prodRepo.findById(id).isPresent()) {
            Product product = prodRepo.findById(id).get();
            ProductDto newProductDto = new ProductDto(product);
            return newProductDto;
        } else {
            throw new RecordNotFoundException("No Goal found with this ID");
        }
    }

    public ProductDto updateProduct(Long id, Product newProduct) {

        if(prodRepo.findById(id).isPresent()) {
            newProduct.setId(id);
            prodRepo.save(newProduct);
            return new ProductDto(newProduct);
        }
        else {
            throw new UpdateRecordException("No Diet found with this ID");
        }
    }

    public void deleteProduct(Long id) {
        if (prodRepo.findById(id).isPresent()) {
            prodRepo.deleteById(id);
        } else {
            throw new DeleteRecordException("No Product found with this ID");
        }
    }
}

