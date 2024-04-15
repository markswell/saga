package com.markswell.payment.config.usecase;

import com.markswell.payment.adapters.out.FindUserByIdAdapter;
import com.markswell.payment.application.core.usecase.FindUserByIdUseCase;
import com.markswell.payment.application.ports.out.FindUserByIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindUserByIdConfig {

    @Bean
    public FindUserByIdUseCase findUserByIdUseCase(FindUserByIdAdapter findUserByIdAdapter) {
        return new FindUserByIdUseCase(findUserByIdAdapter);
    }

}
