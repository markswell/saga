package com.markswell.orchestrator.application.core.usecase;

import com.markswell.orchestrator.application.core.domain.Sale;
import com.markswell.orchestrator.application.ports.in.WorkFlowInputPort;
import com.markswell.orchestrator.application.core.domain.enums.SaleEvent;
import com.markswell.orchestrator.application.ports.out.SendSaleToTopicOutputPort;

import static com.markswell.orchestrator.application.core.domain.enums.KafkaTopic.INVENTORY;
import static com.markswell.orchestrator.application.core.domain.enums.SaleEvent.CREATED_SALE;
import static com.markswell.orchestrator.application.core.domain.enums.SaleEvent.PREPARE_INVENTORY;

public class CratedSaleUseCase implements WorkFlowInputPort {

    private final SendSaleToTopicOutputPort sendSaleToTopicOutputPort;

    public CratedSaleUseCase(SendSaleToTopicOutputPort sendSaleToTopicOutputPort) {
        this.sendSaleToTopicOutputPort = sendSaleToTopicOutputPort;
    }

    @Override
    public void execute(Sale sale) {
        sendSaleToTopicOutputPort.send(sale, PREPARE_INVENTORY, INVENTORY.getTopic());
    }

    @Override
    public boolean isCalledByTheEvent(SaleEvent saleEvent) {
        return CREATED_SALE.equals(saleEvent);
    }
}
