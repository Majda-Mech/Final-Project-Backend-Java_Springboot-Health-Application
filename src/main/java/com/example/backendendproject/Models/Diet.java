package com.example.backendendproject.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "diet")
public class Diet {

    @Id
    @Column(name = "goal_id", nullable = false)
    private Long id;
    private String name;
    private String description;

    @OneToOne
    @MapsId
    @JoinColumn(name = "goal_id")
    private Goal goal;

//    @OneToOne(orphanRemoval = true)
//    @JoinTable(name = "diet_goal",
//            joinColumns = @JoinColumn(name = "diet_goal_id"),
//            inverseJoinColumns = @JoinColumn(name = "goal_id"))
}

