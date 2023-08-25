package com.example.backendendproject.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @GenericGenerator(name = "seq", strategy="increment")

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
        private LocalDate dob;
        private boolean isVegan;
        private boolean isVegetarian;

        public void CustomerDto() {
        }

        public void CustomerDto(Customer customer) {
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


