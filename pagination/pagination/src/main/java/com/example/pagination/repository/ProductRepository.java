package com.example.pagination.repository;

import com.example.pagination.dto.response.ProductResponseDTO;
import com.example.pagination.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<ProductResponseDTO> findAllProjectedBy(Pageable pageable);

    ProductResponseDTO findProjectedById(Long productId);

//    ProductResponseDTO findProjectedByName(String name);
}
