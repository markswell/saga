package com.markswell.payment.adapters.out.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.markswell.payment.application.core.domain.Payment;
import com.markswell.payment.adapters.out.repository.mapper.PaymentMapper;
import com.markswell.payment.application.ports.out.SavePaymentOutputPort;

@Component
@RequiredArgsConstructor
public class SavePaymentAdapter implements SavePaymentOutputPort {

    private final PaymentMapper paymentMapper;
    private final PaymentRepository paymentRepository;

    @Override
    public void save(Payment payment) {
        paymentRepository.save(paymentMapper.toPaymentEntity(payment));

    }
}
