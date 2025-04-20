package com.example.pagination.service;

import com.example.pagination.model.Product;
import com.example.pagination.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public Page<Product> getAllProduct(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Product getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with id " + id + " not found"));
        return product;
    }

    public Product getProductByName(String name) {
        Product product = productRepository.findByName(name);
        return product;
    }

    public void createProduct(Product product) {
        productRepository.save(product);
    }

    public void updateProduct(Product product, Long id) {
        productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with id " + id + " not found"));
        productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        if( !productRepository.existsById(id) ) {
            throw new RuntimeException("Product with id " + id + " not found");
        }
        productRepository.deleteById(id);
    }
}
