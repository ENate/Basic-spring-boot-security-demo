package com.enate.microservices.orderservice.dto;

import java.math.BigDecimal;

/**
 * A data transfer Object for the Order Model
 */
public record OrderRequest(
    Long id,
    String skuCode,
    BigDecimal price,
    Integer quantity) {
}