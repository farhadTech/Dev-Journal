package com.example.pagination.dto.request;

import com.example.pagination.model.Product;

import java.io.Serializable;
import java.util.Set;

public record CategoryRequestDTO(
        String categoryName,

        Set<Product> products

) implements Serializable {
}
