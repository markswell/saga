package com.markswell.orchestrator.config.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.markswell.orchestrator.adapter.out.SendSaleToTopicAdapter;
import com.markswell.orchestrator.application.core.usecase.InventoryPreparedUseCase;

@Configuration
public class InventoryPreparedConfig {

    @Bean
    public InventoryPreparedUseCase inventoryPreparedUseCase(SendSaleToTopicAdapter sendSaleToTopicAdapter) {
        return new InventoryPreparedUseCase(sendSaleToTopicAdapter);
    }

}
