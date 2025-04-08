package com.example.demo.service;

import com.example.demo.dto.request.UserRequestDTO;
import com.example.demo.dto.response.UserResponseDTO;
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
    public List<UserResponseDTO> findAllUsers() {
        // fetch users from the database
        List<User> userList = userRepository.findAll();
        // create a list of UserResponseDTO
        List<UserResponseDTO> userResponseDTO = new ArrayList<>();
        // convert each User entity into a UserResponseDTO
        for(User user : userList) {
            userResponseDTO.add(new UserResponseDTO(
                    user.getId(),
                    user.getUsername(),
                    user.getEmail()
            ));
        }
        return userResponseDTO;
    }

    @Override
    public void createUser(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setUsername(userRequestDTO.name());
        user.setEmail(userRequestDTO.email());
        user.setPassword(userRequestDTO.password());
        userRepository.save(user);
    }
}
