package com.enate.microservices.inventoryservice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.enate.microservices.inventoryservice.repository.InventoryRepository;

@Service
public class InventoryService {

    // Inject InventoryRepository

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Transactional(readOnly = true)
    public boolean checkIfInStock(String code, Integer quantity) {
        return inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(code, quantity);

    }

}
