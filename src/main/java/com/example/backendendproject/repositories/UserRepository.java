package com.example.backendendproject.repositories;

import com.example.backendendproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
