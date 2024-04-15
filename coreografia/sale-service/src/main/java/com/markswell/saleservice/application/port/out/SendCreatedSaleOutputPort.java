package com.markswell.saleservice.application.port.out;

import com.markswell.saleservice.application.core.domain.Sale;
import com.markswell.saleservice.application.core.domain.enums.SaleEvent;

public interface SendCreatedSaleOutputPort {

    void send(Sale sale, SaleEvent saleEvent);

}
