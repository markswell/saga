package com.markswell.saleservice.application.core.usecase;

import com.markswell.saleservice.application.core.domain.Sale;
import com.markswell.saleservice.application.port.in.SaveSaleInputPort;
import com.markswell.saleservice.application.port.out.SaveSaleOutputPort;
import com.markswell.saleservice.application.port.out.SendCreatedSaleOutputPort;

import static com.markswell.saleservice.application.core.domain.enums.SaleEvent.CREATED_SALE;
import static com.markswell.saleservice.application.core.domain.enums.SalesStatus.PENDING;

public class SaveSaleUseCase implements SaveSaleInputPort {

    private final SaveSaleOutputPort saveSaleOutputPort;
    private final SendCreatedSaleOutputPort sendCreatedSaleOutputPort;

    public SaveSaleUseCase(SaveSaleOutputPort saveSaleOutputPort, SendCreatedSaleOutputPort sendCreatedSaleOutputPort) {
        this.saveSaleOutputPort = saveSaleOutputPort;
        this.sendCreatedSaleOutputPort = sendCreatedSaleOutputPort;
    }

    @Override
    public Sale save(Sale sale) {
        sale.setStatus(PENDING);
        var savedSale = saveSaleOutputPort.save(sale);
        sendCreatedSaleOutputPort.send(savedSale, CREATED_SALE);
        return savedSale;
    }

}
