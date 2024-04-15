package com.markswell.saleservice.application.port.out;

import com.markswell.saleservice.application.core.domain.Sale;

public interface SaveSaleOutputPort {

    Sale save(Sale sale);

}
