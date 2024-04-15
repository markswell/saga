package com.markswell.payment.adapters.out.repository.mapper;

import com.markswell.payment.adapters.out.repository.entity.PaymentEntity;
import com.markswell.payment.application.core.domain.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    PaymentEntity toPaymentEntity(Payment payment);

    Payment toPayment(PaymentEntity paymentEntity);

}
