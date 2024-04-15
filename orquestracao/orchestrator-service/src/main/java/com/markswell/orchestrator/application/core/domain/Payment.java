package com.markswell.orchestrator.application.core.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Payment {

    private Integer id;

    private Integer useId;

    private Integer saleId;

    private BigDecimal value;

    public Payment() {}

    public Payment(Integer id, Integer useId, Integer saleId, BigDecimal value) {
        this.id = id;
        this.useId = useId;
        this.saleId = saleId;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUseId() {
        return useId;
    }

    public void setUseId(Integer useId) {
        this.useId = useId;
    }

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id) && Objects.equals(useId, payment.useId) && Objects.equals(saleId, payment.saleId) && Objects.equals(value, payment.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, useId, saleId, value);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", useId=" + useId +
                ", saleId=" + saleId +
                ", value=" + value +
                '}';
    }
}
