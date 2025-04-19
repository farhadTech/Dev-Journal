package com.sb_ecommerce.project.dto;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public record CategoryRequestDTO(
        @NotBlank(message = "Enter category name: ")
        String categoryName,
        int itemCount,
        boolean isActive,
        String description)
        implements Serializable {
}
