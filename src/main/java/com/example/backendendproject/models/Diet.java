package com.example.backendendproject.Models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "diet")
public class Diet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    @GenericGenerator(name = "seq", strategy = "increment")
    @Column(name = "goal_id", nullable = false)
    private Long id;
    private String name;
    private String description;

    @OneToOne
    @MapsId
    @JoinColumn(name = "goal_id")
    private Goal goal;
}

