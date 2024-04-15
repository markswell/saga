package com.markswell.inventoryservice.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.markswell.inventoryservice.application.core.domain.Inventory;
import com.markswell.inventoryservice.adapter.out.repository.InventoryMapper;
import com.markswell.inventoryservice.adapter.out.repository.InventoryRepository;
import com.markswell.inventoryservice.application.ports.out.UpdateInventoryOutputPort;

@Component
@RequiredArgsConstructor
public class UpdateInventoryAdapter implements UpdateInventoryOutputPort {

    private final InventoryMapper inventoryMapper;

    private final InventoryRepository inventoryRepository;

    @Override
    public void update(Inventory inventory) {
        var inventoryEntity = inventoryMapper.toInventoryEntity(inventory);
        inventoryRepository.save(inventoryEntity);
    }
}
