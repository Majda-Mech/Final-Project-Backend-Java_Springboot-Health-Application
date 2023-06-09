package com.example.backendendproject.Controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    public String username;
    public String password;
    public String[] roles;
    public String email;
}
