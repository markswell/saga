package com.markswell.inventoryservice.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.markswell.inventoryservice.application.core.domain.Inventory;
import com.markswell.inventoryservice.adapter.out.repository.InventoryMapper;
import com.markswell.inventoryservice.adapter.out.repository.InventoryRepository;
import com.markswell.inventoryservice.application.ports.out.FindInventoryByProductIdOutputPort;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindInventoryByProductIdAdapter implements FindInventoryByProductIdOutputPort {

    private final InventoryMapper inventoryMapper;
    private final InventoryRepository inventoryRepository;

    @Override
    public Optional<Inventory> find(Integer productId) {
        var inventoryEntity = inventoryRepository.findByProductId(productId);
        return inventoryEntity.map(inventoryMapper::toInventory);
    }
}
