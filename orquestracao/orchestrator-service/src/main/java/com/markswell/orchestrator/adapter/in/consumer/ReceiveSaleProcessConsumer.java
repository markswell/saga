package com.markswell.orchestrator.adapter.in.consumer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;
import com.markswell.orchestrator.adapter.out.message.SaleMessage;
import com.markswell.orchestrator.application.ports.in.WorkFlowInputPort;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReceiveSaleProcessConsumer {

    private final List<WorkFlowInputPort> workFlowInputPorts;

    @KafkaListener(topics = "tp-saga-orchestrator", groupId = "orchestrator")
    public void receive(SaleMessage saleMessage) {
        workFlowInputPorts.stream()
                .filter(w -> w.isCalledByTheEvent(saleMessage.getEvent()))
                .forEach(s -> s.execute(saleMessage.getSale()));
    }

}
