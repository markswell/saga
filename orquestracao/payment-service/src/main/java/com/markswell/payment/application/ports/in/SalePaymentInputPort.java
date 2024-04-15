package com.markswell.payment.application.ports.in;

import com.markswell.payment.application.core.domain.Sale;

public interface SalePaymentInputPort {

    void payment(Sale sale);

}
