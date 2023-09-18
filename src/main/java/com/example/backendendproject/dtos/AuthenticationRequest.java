package com.example.backendendproject.Dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthenticationRequest {
    public String username;
    public String password;
}
