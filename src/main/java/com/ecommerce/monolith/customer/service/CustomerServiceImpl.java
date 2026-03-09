package com.ecommerce.monolith.customer.service;

import com.ecommerce.monolith.customer.dto.*;
import com.ecommerce.monolith.customer.mapper.CustomerMapper;
import com.ecommerce.monolith.customer.model.Customer;
import com.ecommerce.monolith.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {

        Customer customer = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        return mapper.toDTO(customer);
    }

    @Override
    public CustomerDTO createCustomer(CreateCustomerRequest request) {

        Customer customer = mapper.toEntity(request);

        Customer saved = repository.save(customer);

        return mapper.toDTO(saved);
    }

    @Override
    public boolean customerExists(Long id) {
        return repository.existsById(id);
    }

}