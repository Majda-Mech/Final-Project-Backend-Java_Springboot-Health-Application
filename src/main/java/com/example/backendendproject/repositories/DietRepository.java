package com.example.backendendproject.repositories;

import com.example.backendendproject.models.Diet;
import org.springframework.data.repository.CrudRepository;

public interface DietRepository extends CrudRepository<Diet, Long> {
}
