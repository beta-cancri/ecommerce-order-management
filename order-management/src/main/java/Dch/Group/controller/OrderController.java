package Dch.Group.controller;

import Dch.Group.model.Order;
import Dch.Group.service.OrderService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public Flux<Order> getAllOrders() {
        return orderService.findAllOrders();
    }

    @GetMapping("/{id}")
    public Mono<Order> getOrderById(@PathVariable String id) {
        return orderService.findOrderById(id);
    }

    @PostMapping
    public Mono<Order> createOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @DeleteMapping("/{id}")
    public Mono<Order> deleteOrder(@PathVariable String id) {
        return orderService.deleteOrder(id);
    }
}

