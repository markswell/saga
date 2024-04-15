package com.markswell.saleservice.config.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.markswell.saleservice.adapter.out.SaveSaleAdapter;
import com.markswell.saleservice.adapter.out.SendCreatedSaleAdapter;
import com.markswell.saleservice.application.core.usecase.SaveSaleUseCase;

@Configuration
public class CreateSaleConfig {

    @Bean
    public SaveSaleUseCase createSaleUseCase(
            SendCreatedSaleAdapter sendCreatedSaleAdapter,
            SaveSaleAdapter saveSaleAdapter
    ) {
        return new SaveSaleUseCase(saveSaleAdapter, sendCreatedSaleAdapter);
    }

}
