package Dch.Group.service;

import Dch.Group.model.Customer;
import Dch.Group.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Flux<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    public Mono<Customer> findCustomerById(UUID id) {
        return customerRepository.findById(id);
    }

    public Mono<Customer> saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Mono<Void> deleteCustomer(UUID id) {
        return customerRepository.deleteById(id);
    }
}
