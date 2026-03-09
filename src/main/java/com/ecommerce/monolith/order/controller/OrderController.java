package com.ecommerce.monolith.order.controller;

import com.ecommerce.monolith.order.dto.*;
import com.ecommerce.monolith.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping
    public ResponseEntity<OrderDTO> create(@RequestBody CreateOrderRequest request) {
        return ResponseEntity.ok(service.createOrder(request));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<OrderDTO>> getOrdersByCustomer(@PathVariable Long customerId) {
        return ResponseEntity.ok(service.getOrdersByCustomer(customerId));
    }

}