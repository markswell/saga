package com.markswell.saleservice.config.usecase;

import com.markswell.saleservice.adapter.out.FindSaleByIdAdapter;
import com.markswell.saleservice.application.core.usecase.FindSaleByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindSaleByIdConfig {

    @Bean
    public FindSaleByIdUseCase findSaleByIdUseCase(FindSaleByIdAdapter findSaleByIdAdapter) {
        return new FindSaleByIdUseCase(findSaleByIdAdapter);
    }

}
