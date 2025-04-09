package com.example.demo.service;

import com.example.demo.dto.request.UserRequestDTO;
import com.example.demo.dto.response.UserResponseDTO;

import java.util.List;

public interface UserService{
    List<UserResponseDTO> getAllUsers();
    void createUser(UserRequestDTO userRequestDTO);
}
