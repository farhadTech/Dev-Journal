package com.example.demo.repository;

import com.example.demo.dto.response.UserResponseDTO;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    "Fetch all users, but only the fields defined in UserResponseDTO."
//     SELECT u.id, u.username, u.email FROM users u;
    List<UserResponseDTO> findAllProjectedBy();
}

