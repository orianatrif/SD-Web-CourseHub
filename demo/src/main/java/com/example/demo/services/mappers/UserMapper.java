package com.example.demo.services.mappers;

import com.example.demo.controllers.dtos.UserDtos.UserDto;
import com.example.demo.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto toDto(UserEntity userEntity) {
        return UserDto.builder()
                .firstname(userEntity.getFirstname())
                .lastname(userEntity.getLastname())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .build();
    }
}
