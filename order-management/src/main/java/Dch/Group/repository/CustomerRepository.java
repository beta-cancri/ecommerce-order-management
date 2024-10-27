package Dch.Group.repository;

import Dch.Group.model.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, UUID> {
    // Define a method to find a customer by email
    Mono<Customer> findByEmail(String email);
}
