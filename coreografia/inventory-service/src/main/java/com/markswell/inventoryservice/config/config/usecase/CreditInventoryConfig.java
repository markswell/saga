package com.markswell.inventoryservice.config.config.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.markswell.inventoryservice.adapter.out.UpdateInventoryAdapter;
import com.markswell.inventoryservice.adapter.out.SendToKafkaInventoryAdapter;
import com.markswell.inventoryservice.application.core.usecase.CreditInventoryUseCase;
import com.markswell.inventoryservice.application.core.usecase.FindInventoryByProductIdUseCase;

@Configuration
public class CreditInventoryConfig {

    @Bean
    public CreditInventoryUseCase creditInventoryUseCase(
            UpdateInventoryAdapter updateInventoryAdapter,
            SendToKafkaInventoryAdapter sendToKafkaInventoryAdapter,
            FindInventoryByProductIdUseCase findInventoryByProductIdUseCase
    ) {
        return new CreditInventoryUseCase(
                updateInventoryAdapter,
                sendToKafkaInventoryAdapter,
                findInventoryByProductIdUseCase
        );
    }

}
