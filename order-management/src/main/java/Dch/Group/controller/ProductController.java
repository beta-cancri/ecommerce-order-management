package Dch.Group.controller;

import Dch.Group.model.Product;
import Dch.Group.service.ProductService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.http.HttpHeaders;

import java.util.UUID;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Flux<Product> getAllProducts(@RequestHeader HttpHeaders headers) {
        headers.forEach((key, value) -> System.out.println(key + " : " + String.join(",", value)));
        System.out.println("getAllProducts called");
        return productService.findAllProducts();
    }

    @GetMapping("/{id}")
    public Mono<Product> getProductById(@PathVariable UUID id) {
        return productService.findProductById(id);
    }

    @PostMapping
    public Mono<Product> createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteProduct(@PathVariable UUID id) {
        return productService.deleteProduct(id);
    }
}
