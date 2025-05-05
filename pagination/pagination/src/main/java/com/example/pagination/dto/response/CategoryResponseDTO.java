package com.example.pagination.dto.response;

public interface CategoryResponseDTO {
    String getCategoryName();

    interface ProductInfo {
        Long getProductId();
        String getProductName();
        String getDescription();
        Long getPrice();
        int getQuantity();
    }
}
