package com.markswell.saleservice.application.core.usecase;

import com.markswell.saleservice.application.core.domain.Sale;
import com.markswell.saleservice.application.port.in.FinalizeSaleInputPort;
import com.markswell.saleservice.application.port.out.SaveSaleOutputPort;
import com.markswell.saleservice.application.port.in.FindSaleByIdInputPort;

import static com.markswell.saleservice.application.core.domain.enums.SalesStatus.FINALIZED;

public class FinalizeSaleUseCase implements FinalizeSaleInputPort {

    private final SaveSaleOutputPort saveSaleOutputPort;
    private final FindSaleByIdInputPort findSaleByIdInputPort;

    public FinalizeSaleUseCase(
            FindSaleByIdInputPort findSaleByIdInputPort,
            SaveSaleOutputPort saveSaleOutputPort
    ) {
        this.findSaleByIdInputPort = findSaleByIdInputPort;
        this.saveSaleOutputPort = saveSaleOutputPort;
    }

    @Override
    public void finalize(Sale sale) {
        var saleResponse = findSaleByIdInputPort.find(sale.getId());
        saleResponse.setStatus(FINALIZED);
        saveSaleOutputPort.save(saleResponse);
    }

}
