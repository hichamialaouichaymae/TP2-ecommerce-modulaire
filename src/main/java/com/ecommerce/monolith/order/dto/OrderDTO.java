package com.ecommerce.monolith.order.dto;

import lombok.Data;

@Data
public class OrderDTO {

    private Long id;

    private Long customerId;

    private Long productId;

    private Integer quantity;

}