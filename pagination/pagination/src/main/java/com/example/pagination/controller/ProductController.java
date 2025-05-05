package com.example.pagination.controller;

import com.example.pagination.dto.request.ProductRequestDTO;
import com.example.pagination.dto.response.ProductResponseDTO;
import com.example.pagination.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/product")
@RestController
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<Page<ProductResponseDTO>> getProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return new ResponseEntity<>(productService.getAllProducts(pageable), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long id) {
        ProductResponseDTO productResponseDTO = productService.getProductById(id);
        return new ResponseEntity<>(productResponseDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        productService.createProduct(productRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Product created successfully");
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@RequestBody ProductRequestDTO productRequestDTO, @PathVariable Long id) {
        productService.updateProduct(productRequestDTO, id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Product updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
















