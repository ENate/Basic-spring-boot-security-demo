package com.enate.microservices.inventoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enate.microservices.inventoryservice.model.Inventory;


public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, int quantity);
}
