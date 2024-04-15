package com.markswell.saleservice.application.core.usecase;

import com.markswell.saleservice.application.core.domain.Sale;
import com.markswell.saleservice.application.core.domain.exception.SaleNotFoundException;
import com.markswell.saleservice.application.port.in.FindSaleByIdInputPort;
import com.markswell.saleservice.application.port.out.FindSaleByIdOutputPort;

public class FindSaleByIdUseCase implements FindSaleByIdInputPort {

    private final FindSaleByIdOutputPort findSaleByIdOutputPort;

    public FindSaleByIdUseCase(FindSaleByIdOutputPort findSaleByIdOutputPort) {
        this.findSaleByIdOutputPort = findSaleByIdOutputPort;
    }

    @Override
    public Sale find(final Integer saleId) {
        return findSaleByIdOutputPort.find(saleId)
                .orElseThrow(() -> new SaleNotFoundException(saleId));
    }

}
