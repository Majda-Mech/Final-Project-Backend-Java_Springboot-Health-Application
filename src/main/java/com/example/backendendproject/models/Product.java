package com.example.backendendproject.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

    @ManyToOne
    @JoinColumn(name = "recipe_ID")
    private Recipe recipe;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
    private Long id;
    private String name;
    private String description;
}

