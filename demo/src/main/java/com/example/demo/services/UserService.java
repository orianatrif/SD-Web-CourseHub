package com.example.demo.services;
import com.example.demo.entities.UserEntity;
import com.example.demo.services.mappers.UserMapper;
import com.example.demo.controllers.dtos.UserDtos.UserDto;
import com.example.demo.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(userMapper::toDto).toList();
    }

    public UserDto addUser(String firstName, String lastName, String email, String password) {
        UserEntity userEntity = UserEntity.builder()
                .firstname(firstName)
                .lastname(lastName)
                .email(email)
                .password(password)
                .build();
        UserEntity savedUserEntity = userRepository.save(userEntity);
        return userMapper.toDto(savedUserEntity);
    }

    public UserDto findById(Integer userId) {
        return userMapper.toDto(userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("Entity with id " + userId + "not found!")));
    }

    public UserDto updateUser(String firstname, String email) {
        UserEntity usr = userRepository.findByFirstname(firstname);
        if (usr == null)
            return null;

        usr.setEmail(email);
        userRepository.save(usr);
        return userMapper.toDto(usr);
    }

    public void deleteUser(String firstName){
         UserEntity usr = userRepository.findByFirstname(firstName);
         if (usr != null)
             userRepository.delete(usr);
         else{
             throw new RuntimeException("User with first name " + firstName + "not found");
         }
    }
}




