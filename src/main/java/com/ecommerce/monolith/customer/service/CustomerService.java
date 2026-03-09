package com.ecommerce.monolith.customer.service;

import com.ecommerce.monolith.customer.dto.*;
import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerById(Long id);

    CustomerDTO createCustomer(CreateCustomerRequest request);

    boolean customerExists(Long id);

}