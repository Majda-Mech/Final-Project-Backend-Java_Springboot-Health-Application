package com.example.backendendproject.Repositories;

import com.example.backendendproject.Models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
