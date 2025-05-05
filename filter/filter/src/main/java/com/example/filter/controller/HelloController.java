package com.example.filter.controller;

import com.example.filter.util.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final JwtUtil jwtUtil;

    public HelloController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/public/token")
    public String generateToken(@RequestParam String username) {
        return jwtUtil.generateToken(username);
    }

    @GetMapping("/public/hello")
    public String publicHello() {
        return "Hello from public endpoint!";
    }

    @GetMapping("/private/hello")
    public String privateHello() {
        return "Hello from secured endpoint!";
    }
}
