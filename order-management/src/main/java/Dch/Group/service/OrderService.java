package Dch.Group.service;

import Dch.Group.model.Order;
import Dch.Group.repository.OrderRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Flux<Order> findAllOrders() {
        return orderRepository.findAll()
                .filter(Order::getIsActive); 
    }

    public Mono<Order> findOrderById(String id) {
        return orderRepository.findById(id)
                .filter(Order::getIsActive); 
    }

    public Mono<Order> saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Mono<Order> deleteOrder(String id) {
        return orderRepository.findById(id)
                .flatMap(order -> {
                    order.setIsActive(false);
                    return orderRepository.save(order);
                });
    }
}
