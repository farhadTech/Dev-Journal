package com.example.demo.dto.response;

// responding back data from database/server to client like GET
public interface UserResponseDTO{
    Long getId();
    String getUsername();
    String getEmail();
}

/* Spring Data JPA supports interface-based Projections,
 which allow you to return only specific fields from a query directly,
 without creating a full DTO class.
 */
