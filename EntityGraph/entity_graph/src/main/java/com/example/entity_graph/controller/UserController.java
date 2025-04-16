package com.example.entity_graph.controller;

import com.example.entity_graph.model.Post;
import com.example.entity_graph.model.User;
import com.example.entity_graph.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getUsersWithPosts() {
        return userService.getUsersWithPosts();
    }
    @PostMapping
    public void save(User user) {
        userService.save(user);
    }

    @GetMapping("/{id}")
    public User getPostById(@PathVariable Long id) {
        return userService.getUserById(id);
    }


    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        userService.deletePost(id);
    }
}
