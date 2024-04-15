package com.markswell.payment.config.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.markswell.payment.adapters.out.UpdateUserAdapter;
import com.markswell.payment.adapters.out.SendToKafkaPaymentAdapter;
import com.markswell.payment.adapters.out.repository.SavePaymentAdapter;
import com.markswell.payment.application.core.usecase.SalePaymentUseCase;
import com.markswell.payment.application.core.usecase.FindUserByIdUseCase;

@Configuration
public class SalePaymentConfig {

    @Bean
    public SalePaymentUseCase salePaymentUseCase(
            UpdateUserAdapter updateUserAdapter,
            FindUserByIdUseCase findUserByIdUseCase,
            SavePaymentAdapter savePaymentAdapter,
            SendToKafkaPaymentAdapter sendToKafkaPaymentAdapter
    ) {
        return new SalePaymentUseCase(
                updateUserAdapter,
                findUserByIdUseCase,
                savePaymentAdapter,
                sendToKafkaPaymentAdapter
        );
    }

}