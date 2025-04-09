package com.example.demo.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

// requesting/sending data from client to server/database like POST, PUT
public record UserRequestDTO(
        @NotBlank(message = "user name can not be empty.")
        String username,
        @Email(message = "provide a valid email")
        String email,
        String password) implements Serializable {}
