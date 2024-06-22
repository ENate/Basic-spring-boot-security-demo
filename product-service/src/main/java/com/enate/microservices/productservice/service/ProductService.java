package com.enate.microservices.productservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.enate.microservices.productservice.dto.ProductRequest;
import com.enate.microservices.productservice.dto.ProductResponse;
import com.enate.microservices.productservice.model.Product;
import com.enate.microservices.productservice.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
// @RequiredArgsConstructor
public class ProductService {

    // DI for ProductRepository Interface
    private final ProductRepository productRepository;

    public ProductService(ProductRepository repository) {
        this.productRepository = repository;
    }

    public void createProduct(ProductRequest productRequest) {
        // Build a product example
    Product product = Product.builder()
            .name(productRequest.name())
            .description(productRequest.description())
            .price(productRequest.price())
            .build();
    // Save product object using save from Spring Data Mongo
    productRepository.save(product);
    // Display message is successfully saved
    log.info("Saved {} with ID {}", product.getName(), product.getId());
    }

    /**
     * Returns a list of products from the ProductRepository
     * @param product Product Object
     * @return A Recod of DTO ProductResponse
     * Should be done with case especially in production.
     */

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        // Stream products by mapping from entity to DTO response
        return products.stream().map(this::entityToDTOResponse).toList();
    }


    private ProductResponse entityToDTOResponse(Product product) {
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }

}
