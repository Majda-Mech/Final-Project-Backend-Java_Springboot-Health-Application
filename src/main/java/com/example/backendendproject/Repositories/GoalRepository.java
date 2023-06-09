package com.example.backendendproject.Repositories;

import com.example.backendendproject.Models.Goal;
import org.springframework.data.repository.CrudRepository;

public interface GoalRepository extends CrudRepository<Goal, Long> {
}
