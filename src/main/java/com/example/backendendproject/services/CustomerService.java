package com.example.backendendproject.services;

import com.example.backendendproject.dtos.CustomerDto;
import com.example.backendendproject.exceptions.DeleteRecordException;
import com.example.backendendproject.exceptions.RecordNotFoundException;
import com.example.backendendproject.exceptions.UpdateRecordException;
import com.example.backendendproject.models.Customer;
import com.example.backendendproject.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomerService {
    private final CustomerRepository repos;


    public CustomerService(CustomerRepository repos) {
        this.repos = repos;
    }

    public Long createCustomer(CustomerDto customerDto) {
        Customer newCustomer = new Customer();

        newCustomer.setFirstName(customerDto.getFirstName());
        newCustomer.setLastName(customerDto.getLastName());
        newCustomer.setGender(customerDto.getGender());
        newCustomer.setWeight(customerDto.getWeight());
        newCustomer.setHeight(customerDto.getHeight());
        newCustomer.setDob(customerDto.getDob());
        newCustomer.setVegan(customerDto.isVegan());
        newCustomer.setVegetarian(customerDto.isVegetarian());

        Customer savedCustomer = repos.save(newCustomer);
        return savedCustomer.getId();
    }

    public Iterable<CustomerDto> getAllCustomers() {
        Iterable<Customer> customerList = repos.findAll();
        ArrayList<CustomerDto> customerDtoList = new ArrayList<>();

        for (Customer customer : customerList) {
            CustomerDto newCustomerDto = new CustomerDto(customer);
            customerDtoList.add(newCustomerDto);
        }
        return customerDtoList;
    }

    public void deleteCustomer(Long id) {
        if (repos.findById(id).isPresent()) {
            repos.deleteById(id);
        } else {
            throw new DeleteRecordException("No Customer found with this ID");
        }
    }

    public CustomerDto getCustomerById(Long id) {
        if (repos.findById(id).isPresent()) {
            Customer customer = repos.findById(id).get();
            CustomerDto newCustomerDto = new CustomerDto(customer);
            return newCustomerDto;
        } else {
            throw new RecordNotFoundException("No Customer found with this ID");
        }
    }

    public CustomerDto updateCustomerById(Long id, Customer newCustomer) {

        if(repos.findById(id).isPresent()) {
            newCustomer.setId(id);
            repos.save(newCustomer);
            return new CustomerDto(newCustomer);
        }
        else {
            throw new UpdateRecordException("No Customer found with this ID");
        }
    }
}