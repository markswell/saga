package com.markswell.inventoryservice.config.config.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.markswell.inventoryservice.adapter.out.FindInventoryByProductIdAdapter;
import com.markswell.inventoryservice.application.core.usecase.FindInventoryByProductIdUseCase;

@Configuration
public class FIndInventoryByProductIdConfig {

    @Bean
    public FindInventoryByProductIdUseCase findInventoryByProductIdUseCase(FindInventoryByProductIdAdapter findInventoryByProductIdAdapter) {
        return new FindInventoryByProductIdUseCase(findInventoryByProductIdAdapter);
    }

}
