package com.markswell.orchestrator.application.core.domain.enums;

import static java.util.Objects.isNull;

public enum SalesStatus {

    PENDING(1),
    FINALIZED(2),
    CANCELED(3);

    private final Integer statusId;

    SalesStatus(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public static SalesStatus getInstanceByStatusId(Integer id) {
        if(isNull(id)) return null;
        return switch(id) {
          case 1 -> PENDING;
          case 2 -> FINALIZED;
          case 3 -> CANCELED;
          default -> throw new IllegalArgumentException("Id %s is not accepted, please try values: 1 to PENDING, 2 to FINALIZED or three to CANCELED");
        };

    }

}
