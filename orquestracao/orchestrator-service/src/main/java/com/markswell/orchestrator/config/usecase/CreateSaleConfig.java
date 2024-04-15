package com.markswell.orchestrator.config.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.markswell.orchestrator.adapter.out.SendSaleToTopicAdapter;
import com.markswell.orchestrator.application.core.usecase.CratedSaleUseCase;

@Configuration
public class CreateSaleConfig {


    @Bean
    public CratedSaleUseCase cratedSaleUseCase(SendSaleToTopicAdapter sendSaleToTopicAdapter) {
        return new CratedSaleUseCase(sendSaleToTopicAdapter);
    }

}
