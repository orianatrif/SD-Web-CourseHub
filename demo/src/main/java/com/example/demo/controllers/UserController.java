package com.example.demo.controllers;


import com.example.demo.controllers.dtos.UserDtos.UserDto;
import com.example.demo.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/addProduct")
    public ResponseEntity<UserDto>addUser(@RequestBody UserDto userDto){
        try {
            UserDto addedUser = userService.addUser(userDto.getFirstname(), userDto.getLastname(), userDto.getEmail(), userDto.getPassword());
            return ResponseEntity.ok(addedUser);

        }
        catch (RuntimeException e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/userById")
    public ResponseEntity<UserDto> findById(@RequestParam("id") Integer userId) {
        try{
            UserDto usersCont = userService.findById(userId);
            return ResponseEntity.ok(usersCont);
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/updateEmail")
    public ResponseEntity<UserDto> updateUser(@RequestParam("firstname") String firstname, @RequestParam("email") String email){
        try {
            UserDto updatedUser = userService.updateUser(firstname, email);
            return ResponseEntity.ok(updatedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<Void> deleteUser(@RequestParam("firstname") String firstname) {
        try {
            userService.deleteUser(firstname);
            return ResponseEntity.noContent().build(); // Successfully deleted or user not found
        } catch (EntityNotFoundException e) {
            // User not found
            return ResponseEntity.notFound().build();
        } catch (RuntimeException e) {
            // Any other exception
            return ResponseEntity.badRequest().build();
        }
    }





}
