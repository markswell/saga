package com.markswell.saleservice.application.port.out;

import com.markswell.saleservice.application.core.domain.Sale;

import java.util.Optional;

public interface FindSaleByIdOutputPort {

    Optional<Sale> find(final Integer saleId);

}
