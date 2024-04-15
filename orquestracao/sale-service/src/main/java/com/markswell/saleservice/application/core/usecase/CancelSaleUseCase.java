package com.markswell.saleservice.application.core.usecase;

import com.markswell.saleservice.application.core.domain.Sale;
import com.markswell.saleservice.application.port.in.CancelSaleInputport;
import com.markswell.saleservice.application.port.out.SaveSaleOutputPort;
import com.markswell.saleservice.application.port.in.FindSaleByIdInputPort;
import com.markswell.saleservice.application.core.domain.exception.NullObjectReceivedException;

import static java.util.Objects.isNull;
import static com.markswell.saleservice.application.core.domain.enums.SalesStatus.CANCELED;

public class CancelSaleUseCase implements CancelSaleInputport {

    private final SaveSaleOutputPort saveSaleOutputPort;
    private final FindSaleByIdInputPort findSaleByIdInputPort;

    public CancelSaleUseCase(SaveSaleOutputPort saveSaleOutputPort,
                             FindSaleByIdInputPort findSaleByIdInputPort) {
        this.saveSaleOutputPort = saveSaleOutputPort;
        this.findSaleByIdInputPort = findSaleByIdInputPort;
    }

    @Override
    public void cancel(Sale sale) {
        if(!isNull(sale)) {
            var canceledSale = findSaleByIdInputPort.find(sale.getId());
            canceledSale.setStatus(CANCELED);
            saveSaleOutputPort.save(canceledSale);
        } else {
            throw new NullObjectReceivedException("A null sale was received.");
        }

    }

}
