package com.markswell.saleservice.config.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.markswell.saleservice.application.port.out.SaveSaleOutputPort;
import com.markswell.saleservice.application.port.in.FindSaleByIdInputPort;
import com.markswell.saleservice.application.core.usecase.CancelSaleUseCase;

@Configuration
public class CancelSaleConfig {

    @Bean
    public CancelSaleUseCase cancelSaleUseCase(
            SaveSaleOutputPort saveSaleOutputPort,
            FindSaleByIdInputPort findSaleByIdInputPort
    ) {
        return new CancelSaleUseCase(saveSaleOutputPort, findSaleByIdInputPort);
    }
}
