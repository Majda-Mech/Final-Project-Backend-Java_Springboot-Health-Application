package com.example.backendendproject.Repositories;

import com.example.backendendproject.Models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository <Product, Long> {
}
