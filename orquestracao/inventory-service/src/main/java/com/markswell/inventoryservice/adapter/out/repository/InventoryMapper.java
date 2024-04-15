package com.markswell.inventoryservice.adapter.out.repository;

import com.markswell.inventoryservice.adapter.out.repository.entity.InventoryEntity;
import com.markswell.inventoryservice.application.core.domain.Inventory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InventoryMapper {

    Inventory toInventory(InventoryEntity inventory);

    InventoryEntity toInventoryEntity(Inventory inventory);

}
