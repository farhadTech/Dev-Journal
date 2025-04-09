package com.example.demo.controller;

import com.example.demo.dto.request.UserRequestDTO;
import com.example.demo.dto.response.UserResponseDTO;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserResponseDTO> findAllUsers() {
        List <UserResponseDTO> users = userService.getAllUsers();
        return users;
    }

    @GetMapping("/{id}")
    public Optional<User> findUserById(@PathVariable Long id) {
        Optional<User> user = userService.getUserById(id);
        return user;
    }

    @PostMapping
    public void createUser(@RequestBody UserRequestDTO userRequestDTO) {
        userService.createUser(userRequestDTO);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable long id, @RequestBody UserRequestDTO userRequestDTO) {
        userService.updateUser(id, userRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }
}
