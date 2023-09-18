package com.example.backendendproject.Services;

import com.example.backendendproject.Dtos.ProductDto;
import com.example.backendendproject.Exceptions.DeleteRecordException;
import com.example.backendendproject.Exceptions.RecordNotFoundException;
import com.example.backendendproject.Exceptions.UpdateRecordException;
import com.example.backendendproject.Models.Product;
import com.example.backendendproject.Repositories.ProductRepository;
import com.example.backendendproject.Repositories.RecipeRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Long createProduct(ProductDto productDto) {
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
            productDtoList.add(newProductDto);
        }
        return productDtoList;
    }

    public ProductDto getProductById(Long id) {
        Optional<Product> optionalproduct = prodRepo.findById(id);
        if (optionalproduct.isPresent()) {
            Product product = optionalproduct.get();
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

