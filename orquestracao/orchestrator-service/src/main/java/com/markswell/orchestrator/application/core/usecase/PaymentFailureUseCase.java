package com.markswell.orchestrator.application.core.usecase;

import com.markswell.orchestrator.application.core.domain.Sale;
import com.markswell.orchestrator.application.core.domain.enums.SaleEvent;
import com.markswell.orchestrator.application.ports.in.WorkFlowInputPort;
import com.markswell.orchestrator.application.ports.out.SendSaleToTopicOutputPort;

import static com.markswell.orchestrator.application.core.domain.enums.KafkaTopic.INVENTORY;
import static com.markswell.orchestrator.application.core.domain.enums.KafkaTopic.SALE;
import static com.markswell.orchestrator.application.core.domain.enums.SaleEvent.*;

public class PaymentFailureUseCase implements WorkFlowInputPort {

    private final SendSaleToTopicOutputPort sendSaleToTopicOutputPort;

    public PaymentFailureUseCase(SendSaleToTopicOutputPort sendSaleToTopicOutputPort) {
        this.sendSaleToTopicOutputPort = sendSaleToTopicOutputPort;
    }

    @Override
    public void execute(Sale sale) {
        sendSaleToTopicOutputPort.send(sale, EXECUTE_ROLLBACK, INVENTORY.getTopic());
        sendSaleToTopicOutputPort.send(sale, CANCEL_SALE, SALE.getTopic());
    }

    @Override
    public boolean isCalledByTheEvent(SaleEvent saleEvent) {
        return PAYMENT_FAILED.equals(saleEvent);
    }
}
