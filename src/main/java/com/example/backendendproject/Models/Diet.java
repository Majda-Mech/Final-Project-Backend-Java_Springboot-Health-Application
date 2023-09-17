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
    @GeneratedValue
    private Long id;
    private String name;
    private String description;

    @OneToOne
    @MapsId
    @JoinColumn(name = "goal_id")
    private Goal goal;

}

