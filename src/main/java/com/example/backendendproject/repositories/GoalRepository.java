package com.example.backendendproject.repositories;

import com.example.backendendproject.models.Goal;
import org.springframework.data.repository.CrudRepository;

public interface GoalRepository extends CrudRepository<Goal, Long> {
}
