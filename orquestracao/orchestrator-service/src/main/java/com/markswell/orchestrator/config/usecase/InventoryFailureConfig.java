package com.markswell.orchestrator.config.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.markswell.orchestrator.adapter.out.SendSaleToTopicAdapter;
import com.markswell.orchestrator.application.core.usecase.InventoryFailureUseCase;

@Configuration
public class InventoryFailureConfig {

    @Bean
    public InventoryFailureUseCase inventoryFailureUseCase(SendSaleToTopicAdapter sendSaleToTopicAdapter) {
        return new InventoryFailureUseCase(sendSaleToTopicAdapter);
    }

}
