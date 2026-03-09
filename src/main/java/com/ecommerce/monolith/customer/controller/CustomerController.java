package com.ecommerce.monolith.customer.controller;

import com.ecommerce.monolith.customer.dto.*;
import com.ecommerce.monolith.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAll() {
        return ResponseEntity.ok(service.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCustomerById(id));
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> create(@RequestBody CreateCustomerRequest request) {
        return ResponseEntity.ok(service.createCustomer(request));
    }

}