package com.example.demo.service;

import com.example.demo.dto.request.UserRequestDTO;
import com.example.demo.dto.response.UserResponseDTO;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserResponseDTO> getAllUsers() {
        // fetch users from the database
        List<User> userList = userRepository.findAll();
        // create a list of UserResponseDTO
        List<UserResponseDTO> userResponseDTO = new ArrayList<>();
        // convert each User entity into a UserResponseDTO
        for(User user : userList) {
            userResponseDTO.add(UserMapper.toDTO(user));
        }
        return userResponseDTO;
    }

    @Override
    public void createUser(UserRequestDTO userRequestDTO) {
        User user = UserMapper.toEntity(userRequestDTO);
        userRepository.save(user);
    }
}
