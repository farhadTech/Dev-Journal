package com.example.demo.service;

import com.example.demo.dto.request.UserRequestDTO;
import com.example.demo.dto.response.UserResponseDTO;
import com.example.demo.model.User;

import java.util.List;

public interface UserService{
    List<UserResponseDTO> findAllUsers();
    void createUser(UserRequestDTO userRequestDTO);
}
