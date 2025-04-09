package com.example.demo.service;

import com.example.demo.dto.request.UserRequestDTO;
import com.example.demo.dto.response.UserResponseDTO;
import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService{
    List<UserResponseDTO> getAllUsers();
    Optional<User> getUserById(Long id);
    void createUser(UserRequestDTO userRequestDTO);
    void updateUser(long id, UserRequestDTO userRequestDTO);
    void deleteUser(long id);
}
