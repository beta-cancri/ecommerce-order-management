package Dch.Group.service;

import Dch.Group.model.Customer;
import Dch.Group.repository.CustomerRepository;
import Dch.Group.dto.CustomerDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AuthService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Mono<CustomerDTO> authenticate(String email, String password) {
        return customerRepository.findByEmail(email)
                .filter(customer -> passwordEncoder.matches(password, customer.getPassword()))
                .map(this::convertToDTO); // Map to DTO after successful authentication
    }

    private CustomerDTO convertToDTO(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());
        dto.setAddress(customer.getAddress());
        dto.setIsAdmin(customer.getIsAdmin());
        dto.setIsActive(customer.getIsActive()); 
        return dto;
    }
}
