package com.example.backendendproject.repositories;

import com.example.backendendproject.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends JpaRepository <Product, Long> {
}
