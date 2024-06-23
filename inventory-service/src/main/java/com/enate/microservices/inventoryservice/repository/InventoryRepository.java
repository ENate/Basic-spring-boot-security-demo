package com.enate.microservices.inventoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enate.microservices.inventoryservice.model.Inventory;


public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    // Composite method to check for availability of product
    // Method takes quantity and skuCode
    boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, int quantity);
}
