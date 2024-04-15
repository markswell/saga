package com.markswell.orchestrator.config.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.markswell.orchestrator.adapter.out.SendSaleToTopicAdapter;
import com.markswell.orchestrator.application.core.usecase.PaymentExecutedUseCase;

@Configuration
public class PaymentExecutedConfig {

    @Bean
    public PaymentExecutedUseCase paymentExecutedUseCase(SendSaleToTopicAdapter sendSaleToTopicAdapter) {
        return new PaymentExecutedUseCase(sendSaleToTopicAdapter);
    }

}
