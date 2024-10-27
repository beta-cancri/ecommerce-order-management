package Dch.Group.controller;

import Dch.Group.model.Customer;
import Dch.Group.service.CustomerService;
import Dch.Group.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public Flux<CustomerDTO> getAllCustomers() {
        return customerService.findAllCustomers()
                .map(this::convertToDTO);
    }

    @GetMapping("/{id}")
    public Mono<CustomerDTO> getCustomerById(@PathVariable UUID id) {
        return customerService.findCustomerById(id)
                .map(this::convertToDTO);
    }

    @PostMapping
    public Mono<CustomerDTO> createCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer)
                .map(this::convertToDTO);
    }

    @DeleteMapping("/{id}")
    public Mono<CustomerDTO> deleteCustomer(@PathVariable UUID id) {
        return customerService.deleteCustomer(id)
                .map(this::convertToDTO);
    }

    // Helper method to convert Customer to CustomerDTO
    private CustomerDTO convertToDTO(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());
        dto.setAddress(customer.getAddress());
        return dto;
    }
}

