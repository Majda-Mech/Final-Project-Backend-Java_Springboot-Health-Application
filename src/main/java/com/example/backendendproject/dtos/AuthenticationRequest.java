package com.example.backendendproject.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthenticationRequest {
    public String username;
    public String password;
}
