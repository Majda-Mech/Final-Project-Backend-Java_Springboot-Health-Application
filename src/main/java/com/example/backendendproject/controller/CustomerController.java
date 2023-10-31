package com.example.backendendproject.Controller;

import com.example.backendendproject.Dtos.CustomerDto;
import com.example.backendendproject.Models.Customer;
import com.example.backendendproject.Services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;

import static com.example.backendendproject.Controller.RecipeController.getStringResponseEntity;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<Iterable<CustomerDto>> getAllCustomer() {
        return ResponseEntity.ok(service.getAllCustomers());
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCustomerById(id));
    }

    @PostMapping("")
    public ResponseEntity<String> createCustomer(@Valid @RequestBody CustomerDto customerDto , BindingResult br) {

        if (br.hasErrors()) {
            return getStringResponseEntity(br);
        } else {
            Long createdId = service.createCustomer(customerDto);
            URI uri = URI.create(
                    ServletUriComponentsBuilder
                            .fromCurrentContextPath()
                            .path("/customers/" + createdId).toUriString());
            return ResponseEntity.created(uri).body("Customer created!");
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable Long id) {
        service.deleteCustomer(id);
        return ResponseEntity.ok().body("Customer Deleted");
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable Long id, @RequestBody Customer newCustomer) {
        service.updateCustomerById(id, newCustomer);
        return ResponseEntity.ok().body("Customer Updated");
    }
}