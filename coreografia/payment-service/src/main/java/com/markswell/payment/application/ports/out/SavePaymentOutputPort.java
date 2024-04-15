package com.markswell.payment.application.ports.out;

import com.markswell.payment.application.core.domain.Payment;

public interface SavePaymentOutputPort {

    void save(Payment payment);

}
