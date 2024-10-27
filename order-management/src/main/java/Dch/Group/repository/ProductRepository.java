package Dch.Group.repository;

import Dch.Group.model.Product;

import java.util.UUID;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductRepository extends ReactiveCrudRepository<Product, UUID> {
}
