package com.enate.microservices.productservice.dto;

import java.math.BigDecimal;

/**
 * Defines a record - as data carrier - as a 
 * data transaction object for the
 * @see Product
 */
public record ProductRequest(String name, String description, BigDecimal price) {

}
