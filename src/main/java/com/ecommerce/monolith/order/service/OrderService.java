package com.ecommerce.monolith.order.service;

import com.ecommerce.monolith.order.dto.*;
import java.util.List;

public interface OrderService {

    OrderDTO createOrder(CreateOrderRequest request);

    List<OrderDTO> getOrdersByCustomer(Long customerId);

}