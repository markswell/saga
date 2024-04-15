package com.markswell.payment.application.core.domain;

import com.markswell.payment.application.core.domain.enums.SalesStatus;

import java.util.Objects;
import java.math.BigDecimal;

public class Sale {

    private Integer id;

    private Integer productId;

    private Integer userId;

    private BigDecimal value;

    private SalesStatus status;

    private Integer quantity;

    public Sale(Integer id, Integer productId, Integer userId, BigDecimal value, SalesStatus status, Integer quantity) {
        this.id = id;
        this.productId = productId;
        this.userId = userId;
        this.value = value;
        this.status = status;
        this.quantity = quantity;
    }

    public Sale() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public SalesStatus getStatus() {
        return status;
    }

    public void setStatus(SalesStatus status) {
        this.status = status;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return Objects.equals(id, sale.id) && Objects.equals(productId, sale.productId) && Objects.equals(userId, sale.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, userId);
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", productId=" + productId +
                ", userId=" + userId +
                ", value=" + value +
                ", status=" + status +
                ", quantity=" + quantity +
                '}';
    }
}
