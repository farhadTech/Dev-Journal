package com.example.pagination.dto.response;

public interface ProductResponseDTO {
    String getName();
    String getDescription();
    double getPrice();
    int getQuantity();

    CategoryInfo getCategory();

    interface CategoryInfo{
        Long getCategoryId();
        String getName();
    }
}
