package com.example.backendendproject.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name="users")
    public class User {
        @Id
        private String username;
        private String password;
        private String email;

        @ManyToMany(fetch = FetchType.EAGER)
        private Collection<Role> roles;
}

