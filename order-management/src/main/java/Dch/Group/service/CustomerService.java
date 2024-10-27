package Dch.Group.service;

import Dch.Group.model.Customer;
import Dch.Group.repository.CustomerRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomerService(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Flux<Customer> findAllCustomers() {
        return customerRepository.findAll()
                .filter(Customer::getIsActive); // Only return active customers
    }

    public Mono<Customer> findCustomerById(UUID id) {
        return customerRepository.findById(id)
                .filter(Customer::getIsActive); // Only return if active
    }

    public Mono<Customer> saveCustomer(Customer customer) {
        String hashedPassword = passwordEncoder.encode(customer.getPassword());
        customer.setPassword(hashedPassword);
        return customerRepository.save(customer);
    }

    public Mono<Customer> deleteCustomer(UUID id) {
        return customerRepository.findById(id)
                .flatMap(customer -> {
                    customer.setIsActive(false);
                    return customerRepository.save(customer);
                });
    }
}

