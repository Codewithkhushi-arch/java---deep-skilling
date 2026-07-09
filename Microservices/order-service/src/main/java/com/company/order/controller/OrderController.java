package com.company.order.controller;

import com.company.order.client.UserClient;
import com.company.order.dto.UserDTO;
import com.company.order.entity.Order;
import com.company.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserClient userClient;

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getOrderWithUser(@PathVariable Long id) {
        return orderRepository.findById(id)
                .map(order -> {
                    Map<String, Object> response = new HashMap<>();
                    response.put("order", order);
                    try {
                        UserDTO user = userClient.getUserById(order.getUserId());
                        response.put("user", user);
                    } catch (Exception e) {
                        response.put("user", null);
                        response.put("userError", "Failed to retrieve user info: " + e.getMessage());
                    }
                    return ResponseEntity.ok(response);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }
}
