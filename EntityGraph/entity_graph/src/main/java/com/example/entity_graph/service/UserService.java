package com.example.entity_graph.service;

import com.example.entity_graph.model.Post;
import com.example.entity_graph.model.User;
import com.example.entity_graph.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    public List<User> getUsersWithPosts() {
        return userRepository.findAllWithPosts();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User savePost(User user) {
        return userRepository.save(user);
    }

    public void deletePost(Long id) {
        userRepository.deleteById(id);
    }
}
