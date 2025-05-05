package com.example.pagination.dto.request;

import com.example.pagination.model.Category;

import java.io.Serializable;

public record ProductRequestDTO(
        String productId,
        String productName,
        String description,
        double price,
        int quantity,

        Category category
) implements Serializable {
}
