package com.example.backendendproject.repositories;

import com.example.backendendproject.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
