package com.markswell.orchestrator.application.ports.in;

import com.markswell.orchestrator.application.core.domain.Sale;
import com.markswell.orchestrator.application.core.domain.enums.SaleEvent;

public interface WorkFlowInputPort {

    void execute(Sale sale);

    boolean isCalledByTheEvent(SaleEvent saleEvent);

}
