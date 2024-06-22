package com.enate.microservices.productservice.dto;

import java.math.BigDecimal;

/** DTO object response Record. Used to stream objects
 * from the Mongo database.
 */
public record ProductResponse(String id, String name, String description, BigDecimal price) {

}
