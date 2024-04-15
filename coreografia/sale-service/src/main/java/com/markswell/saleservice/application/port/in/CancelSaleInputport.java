package com.markswell.saleservice.application.port.in;

import com.markswell.saleservice.application.core.domain.Sale;

public interface CancelSaleInputport {
    void cancel(Sale sale);
}
