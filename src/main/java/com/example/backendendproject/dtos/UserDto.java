package com.example.backendendproject.dtos;

import com.example.backendendproject.models.Authority;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserDto {
    public String username;
    public String password;
    public Boolean enabled;
    public String apikey;
    public String email;

    @JsonSerialize
    public Set<Authority> authorities;
}
