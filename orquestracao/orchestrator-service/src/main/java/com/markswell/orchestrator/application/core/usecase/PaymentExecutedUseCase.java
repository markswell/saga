package com.markswell.orchestrator.application.core.usecase;

import com.markswell.orchestrator.application.core.domain.Sale;
import com.markswell.orchestrator.application.core.domain.enums.SaleEvent;
import com.markswell.orchestrator.application.ports.in.WorkFlowInputPort;
import com.markswell.orchestrator.application.ports.out.SendSaleToTopicOutputPort;

import static com.markswell.orchestrator.application.core.domain.enums.SaleEvent.*;
import static com.markswell.orchestrator.application.core.domain.enums.KafkaTopic.SALE;

public class PaymentExecutedUseCase implements WorkFlowInputPort {

    private final SendSaleToTopicOutputPort sendSaleToTopicOutputPort;

    public PaymentExecutedUseCase(SendSaleToTopicOutputPort sendSaleToTopicOutputPort) {
        this.sendSaleToTopicOutputPort = sendSaleToTopicOutputPort;
    }

    @Override
    public void execute(Sale sale) {
        sendSaleToTopicOutputPort.send(sale, FINALIZE_SALE, SALE.getTopic());
    }

    @Override
    public boolean isCalledByTheEvent(SaleEvent saleEvent) {
        return PAYMENT_EXECUTED.equals(saleEvent);
    }
}
