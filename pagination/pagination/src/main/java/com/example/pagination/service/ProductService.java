package com.example.pagination.service;

import com.example.pagination.dto.request.ProductRequestDTO;
import com.example.pagination.dto.response.ProductResponseDTO;
import com.example.pagination.model.Category;
import com.example.pagination.model.Product;
import com.example.pagination.repository.CategoryRepository;
import com.example.pagination.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public Page<ProductResponseDTO> getAllProducts(Pageable pageable) {
        return productRepository.findAllProjectedBy(pageable);
    }

    public ProductResponseDTO getProductsByCategoryId(Long id) {
        return productRepository.findProjectedById(id);
    }

    public ProductResponseDTO getProductById(Long id) {
        ProductResponseDTO productResponseDTO = productRepository.findProjectedById(id);
        return productResponseDTO;
    }

    public Product createProduct(ProductRequestDTO productRequestDTO) {
        Product product = new Product();
        product.setProductName(productRequestDTO.productName());
        product.setDescription(productRequestDTO.description());
        product.setPrice(productRequestDTO.price());
        product.setQuantity(productRequestDTO.quantity());
        return productRepository.save(product);
    }

    public Product addProductToCategory(Long id, Product product) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with ID: " + id));
        product.setCategory(category);
        return productRepository.save(product);
    }

    public void updateProduct(ProductRequestDTO productRequestDTO, Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with id " + id + " not found"));

        product.setProductName(productRequestDTO.productName());
        product.setDescription(productRequestDTO.description());
        product.setPrice(productRequestDTO.price());
        product.setQuantity(productRequestDTO.quantity());
        productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product with id " + id + " not found");
        }
        productRepository.deleteById(id);
    }
}
