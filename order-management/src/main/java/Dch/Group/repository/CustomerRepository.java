package Dch.Group.repository;

import Dch.Group.model.Customer;

import java.util.UUID;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, UUID> {
}
