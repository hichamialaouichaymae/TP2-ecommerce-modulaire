package com.ecommerce.monolith.order.dto;

import lombok.Data;

@Data
public class CreateOrderRequest {

    private Long customerId;

    private Long productId;

    private Integer quantity;

}