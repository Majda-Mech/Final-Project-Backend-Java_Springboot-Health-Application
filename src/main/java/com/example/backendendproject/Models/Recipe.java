package com.example.backendendproject.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
    @GenericGenerator(name = "seq", strategy="increment")
    private Long id;
    private String name;
    private boolean isVegan;
    private boolean isVegetarian;

    @OneToMany(mappedBy = "recipe")
    @JsonIgnore
    private List<Product> products;

//    @ManyToOne
//    @JoinColumn(name = "recipe_id")
//    private Recipe recipe;


}
