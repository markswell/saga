package com.markswell.orchestrator.config.usecase;

import com.markswell.orchestrator.application.core.usecase.PaymentFailureUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.markswell.orchestrator.adapter.out.SendSaleToTopicAdapter;

@Configuration
public class PaymentFailureConfig {

    @Bean
    public PaymentFailureUseCase paymentFailureUseCase(SendSaleToTopicAdapter sendSaleToTopicAdapter) {
        return new PaymentFailureUseCase(sendSaleToTopicAdapter);
    }

}
