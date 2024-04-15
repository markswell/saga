package com.markswell.orchestrator.application.core.domain.enums;

public enum KafkaTopic {

    SALE("tp-saga-sale"),
    INVENTORY("tp-saga-inventory"),
    PAYMENT("tp-saga-payment"),
    ORCHESTRATOR("tp-saga-orchestrator");

    public final String topic;

    KafkaTopic(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }
}
