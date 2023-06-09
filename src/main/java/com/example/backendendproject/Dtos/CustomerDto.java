package com.example.backendendproject.Dtos;

import com.example.backendendproject.Models.Customer;
import com.example.endprojectsmechapplication.Models.Customer;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Setter
@Getter
public class CustomerDto {

    private Long id;
    @NotNull(message = "Please enter a Firstname")
    private String firstName;

    @NotNull(message = "Please enter a Lastname")
    private String lastName;

    @NotNull(message = "Please enter a Gender 'Male','Female','Other' ")
    private String gender;
    private int weight;
    private int height;

    @Past
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy/MM/dd")
    private LocalDate dob;
    private boolean isVegan;
    private boolean isVegetarian;

    public CustomerDto() {
            }

    public CustomerDto(Customer customer) {
            this.id = customer.getId();
            this.firstName = customer.getFirstName();
            this.lastName = customer.getLastName();
            this.gender = customer.getGender();
            this.weight = customer.getWeight();
            this.height = customer.getHeight();
            this.dob = customer.getDob();
            this.isVegan = customer.isVegan();
            this.isVegetarian = customer.isVegetarian();
            }
    }