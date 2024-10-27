package Dch.Group.controller;

import Dch.Group.model.Customer;
import Dch.Group.service.AuthService;
import Dch.Group.dto.CustomerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public Mono<ResponseEntity<CustomerDTO>> login(@RequestBody Customer customer) {
        return authService.authenticate(customer.getEmail(), customer.getPassword())
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.status(401).build()); // Unauthorized if authentication fails
    }
}
