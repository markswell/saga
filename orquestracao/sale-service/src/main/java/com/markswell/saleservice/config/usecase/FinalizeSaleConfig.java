package com.markswell.saleservice.config.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.markswell.saleservice.adapter.out.SaveSaleAdapter;
import com.markswell.saleservice.application.core.usecase.FinalizeSaleUseCase;
import com.markswell.saleservice.application.core.usecase.FindSaleByIdUseCase;

@Configuration
public class FinalizeSaleConfig {


    @Bean
    public FinalizeSaleUseCase finalizeSaleUseCase(
            FindSaleByIdUseCase findSaleByIdUseCase,
            SaveSaleAdapter saveSaleAdapter

    ) {
        return new FinalizeSaleUseCase(findSaleByIdUseCase, saveSaleAdapter);
    }

}
