package com.ecommerce.monolith.order.service;

import com.ecommerce.monolith.order.dto.*;
import com.ecommerce.monolith.order.mapper.OrderMapper;
import com.ecommerce.monolith.order.model.Order;
import com.ecommerce.monolith.order.repository.OrderRepository;
import com.ecommerce.monolith.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final OrderMapper mapper;
    private final CustomerService customerService;

    @Override
    public OrderDTO createOrder(CreateOrderRequest request) {

        if (!customerService.customerExists(request.getCustomerId())) {
            throw new RuntimeException("Customer does not exist");
        }

        Order order = mapper.toEntity(request);

        Order saved = repository.save(order);

        return mapper.toDTO(saved);
    }

    @Override
    public List<OrderDTO> getOrdersByCustomer(Long customerId) {

        List<Order> orders = repository.findByCustomerId(customerId);

        return mapper.toDTOList(orders);
    }

}