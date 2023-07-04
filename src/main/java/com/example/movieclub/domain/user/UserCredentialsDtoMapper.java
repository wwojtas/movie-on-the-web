package com.example.movieclub.domain.user;


import com.example.movieclub.domain.user.dto.UserCredentialsDto;

import java.util.Set;
import java.util.stream.Collectors;

public class UserCredentialsDtoMapper {
    static UserCredentialsDto map(User user){
        Set<String> roles = user.getRoles().stream()
                .map(role -> role.getName())
                .collect(Collectors.toSet());
        return new UserCredentialsDto(user.getEmail(), user.getPassword(), roles);
    }
}
