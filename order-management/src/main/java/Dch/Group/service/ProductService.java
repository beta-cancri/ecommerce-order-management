package Dch.Group.service;

import Dch.Group.model.Product;
import Dch.Group.repository.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Flux<Product> findAllProducts() {
        return productRepository.findAll()
                .filter(Product::getIsActive); // Only return active products
    }

    public Mono<Product> findProductById(UUID id) {
        return productRepository.findById(id)
                .filter(Product::getIsActive); // Only return if active
    }

    public Mono<Product> saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Mono<Product> deleteProduct(UUID id) {
        return productRepository.findById(id)
                .flatMap(product -> {
                    product.setIsActive(false);
                    return productRepository.save(product);
                });
    }
}

