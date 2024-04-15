package com.markswell.saleservice.config.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.markswell.saleservice.adapter.out.SaveSaleAdapter;
import com.markswell.saleservice.adapter.out.SaveCreatedSaleAdapter;
import com.markswell.saleservice.application.core.usecase.SaveSaleUseCase;

@Configuration
public class CreateSaleConfig {

    @Bean
    public SaveSaleUseCase createSaleUseCase(
            SaveCreatedSaleAdapter saveCreatedSaleAdapter,
            SaveSaleAdapter saveSaleAdapter
    ) {
        return new SaveSaleUseCase(saveSaleAdapter, saveCreatedSaleAdapter);
    }

}
