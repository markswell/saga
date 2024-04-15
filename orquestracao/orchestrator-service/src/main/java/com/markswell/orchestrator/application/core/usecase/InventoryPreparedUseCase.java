package com.markswell.orchestrator.application.core.usecase;

import com.markswell.orchestrator.application.core.domain.Sale;
import com.markswell.orchestrator.application.core.domain.enums.SaleEvent;
import com.markswell.orchestrator.application.ports.in.WorkFlowInputPort;
import com.markswell.orchestrator.application.ports.out.SendSaleToTopicOutputPort;

import static com.markswell.orchestrator.application.core.domain.enums.KafkaTopic.PAYMENT;
import static com.markswell.orchestrator.application.core.domain.enums.SaleEvent.EXECUTE_PAYMENT;
import static com.markswell.orchestrator.application.core.domain.enums.SaleEvent.INVENTORY_PREPARED;

public class InventoryPreparedUseCase implements WorkFlowInputPort {

    private final SendSaleToTopicOutputPort sendSaleToTopicOutputPort;

    public InventoryPreparedUseCase(SendSaleToTopicOutputPort sendSaleToTopicOutputPort) {
        this.sendSaleToTopicOutputPort = sendSaleToTopicOutputPort;
    }

    @Override
    public void execute(Sale sale) {
        sendSaleToTopicOutputPort.send(sale, EXECUTE_PAYMENT, PAYMENT.getTopic());
    }

    @Override
    public boolean isCalledByTheEvent(SaleEvent saleEvent) {
        return INVENTORY_PREPARED.equals(saleEvent);
    }
}
