package com.example.demo.dto.request;

// get data from client like POST, PUT
public record UserRequestDTO(String name, String email, String password) {}
