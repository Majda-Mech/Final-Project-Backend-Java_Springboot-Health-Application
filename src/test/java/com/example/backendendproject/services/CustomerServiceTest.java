package com.example.backendendproject.services;

import com.example.backendendproject.Repositories.CustomerRepository;
import com.example.backendendproject.Services.CustomerService;
import com.example.backendendproject.Dtos.CustomerDto;
import com.example.backendendproject.Exceptions.DeleteRecordException;
import com.example.backendendproject.Exceptions.RecordNotFoundException;
import com.example.backendendproject.Exceptions.UpdateRecordException;
import com.example.backendendproject.Models.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class CustomerServiceTest {

    @Mock
    private CustomerRepository mockRepos;

    private CustomerService customerServiceUnderTest;

    @BeforeEach
    void setUp() {
        customerServiceUnderTest = new CustomerService(mockRepos);
    }

    @Test
    void ShouldCreateCustomer() {
        // Arrange
        final Customer customer = new Customer();
        customer.setId(0L);
        customer.setFirstName("firstName");
        customer.setLastName("lastName");
        customer.setGender("gender");
        customer.setWeight(0);
        customer.setHeight(0);
        customer.setDob(LocalDate.of(2020, 1, 1));
        customer.setVegan(false);
        customer.setVegetarian(false);
        final CustomerDto customerDto = new CustomerDto(customer);

        final Customer customer1 = new Customer();
        customer1.setId(0L);
        customer1.setFirstName("firstName");
        customer1.setLastName("lastName");
        customer1.setGender("gender");
        customer1.setWeight(0);
        customer1.setHeight(0);
        customer1.setDob(LocalDate.of(2020, 1, 1));
        customer1.setVegan(false);
        customer1.setVegetarian(false);
        when(mockRepos.save(any(Customer.class))).thenReturn(customer1);

        // Act
        final Long result = customerServiceUnderTest.createCustomer(customerDto);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(0L);
    }


    @Test
    void ShouldGetAllCustomers() {
        final Customer customer = new Customer();
        customer.setId(0L);
        customer.setFirstName("firstName");
        customer.setLastName("lastName");
        customer.setGender("gender");
        customer.setWeight(0);
        customer.setHeight(0);
        customer.setDob(LocalDate.of(2020, 1, 1));
        customer.setVegan(false);
        customer.setVegetarian(false);
        final Iterable<Customer> customers = List.of(customer);
        when(mockRepos.findAll()).thenReturn(customers);

        final Iterable<CustomerDto> result = customerServiceUnderTest.getAllCustomers();
        // Assert
        assertThat(result).isNotNull();
    }

    @Test
    void CheckCustomerRepo() {
        when(mockRepos.findAll()).thenReturn(Collections.emptyList());
        final Iterable<CustomerDto> result = customerServiceUnderTest.getAllCustomers();
        assertThat(result).isEmpty();
    }

    @Test
    void ShouldDeleteCustomer() {
        final Customer customer1 = new Customer();
        customer1.setId(0L);
        customer1.setFirstName("firstName");
        customer1.setLastName("lastName");
        customer1.setGender("gender");
        customer1.setWeight(0);
        customer1.setHeight(0);
        customer1.setDob(LocalDate.of(2020, 1, 1));
        customer1.setVegan(false);
        customer1.setVegetarian(false);
        final Optional<Customer> customer = Optional.of(customer1);
        when(mockRepos.findById(0L)).thenReturn(customer);
        final CustomerDto result = customerServiceUnderTest.getCustomerById(0L);
        // Assert
        assertThat(result).isNotNull();
    }

    @Test
    void CheckDeleteCustomerException() {
        when(mockRepos.findById(0L)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> customerServiceUnderTest.deleteCustomer(0L)).isInstanceOf(DeleteRecordException.class);
    }

    @Test
    void ShouldGetCustomerById() {
        final Customer customer1 = new Customer();
        customer1.setId(0L);
        customer1.setFirstName("firstName");
        customer1.setLastName("lastName");
        customer1.setGender("gender");
        customer1.setWeight(0);
        customer1.setHeight(0);
        customer1.setDob(LocalDate.of(2020, 1, 1));
        customer1.setVegan(false);
        customer1.setVegetarian(false);
        final Optional<Customer> customer = Optional.of(customer1);
        when(mockRepos.findById(0L)).thenReturn(customer);

        final CustomerDto result = customerServiceUnderTest.getCustomerById(0L);

        // Assert
        assertThat(result).isNotNull();
        assertEquals("firstName", result.getFirstName());
        assertEquals("lastName", result.getLastName());
        assertEquals("gender", result.getGender());
    }


    @Test
    void CheckRecordNotFoundException() {
        when(mockRepos.findById(0L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> customerServiceUnderTest.getCustomerById(0L))
                .isInstanceOf(RecordNotFoundException.class);
    }

    @Test
    void CheckUpdateRecordException() {

        final Customer newCustomer = new Customer();
        newCustomer.setId(0L);
        newCustomer.setFirstName("firstName");
        newCustomer.setLastName("lastName");
        newCustomer.setGender("gender");
        newCustomer.setWeight(0);
        newCustomer.setHeight(0);
        newCustomer.setDob(LocalDate.of(2020, 1, 1));
        newCustomer.setVegan(false);
        newCustomer.setVegetarian(false);

        when(mockRepos.findById(0L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> customerServiceUnderTest.updateCustomerById(0L, newCustomer))
                .isInstanceOf(UpdateRecordException.class);
    }
}