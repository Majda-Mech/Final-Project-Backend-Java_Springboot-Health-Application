package com.example.backendendproject.repositories;

import com.example.backendendproject.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository <Product, Long> {
}
