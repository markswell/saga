package com.markswell.inventoryservice.config.config.usecase;

import com.markswell.inventoryservice.adapter.out.SendToKafkaInventoryAdapter;
import com.markswell.inventoryservice.application.core.usecase.DebitInventoryUseCase;
import com.markswell.inventoryservice.application.core.usecase.FindInventoryByProductIdUseCase;
import com.markswell.inventoryservice.application.ports.out.UpdateInventoryOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DebitInventoryConfig {

    @Bean
    public DebitInventoryUseCase debitInventoryUseCase(
            FindInventoryByProductIdUseCase findInventoryByProductIdUseCase,
            UpdateInventoryOutputPort updateInventoryOutputPort,
            SendToKafkaInventoryAdapter sendToKafkaInventoryAdapter
    ) {
        return new DebitInventoryUseCase(
                findInventoryByProductIdUseCase,
                updateInventoryOutputPort,
                sendToKafkaInventoryAdapter);
    }

}
