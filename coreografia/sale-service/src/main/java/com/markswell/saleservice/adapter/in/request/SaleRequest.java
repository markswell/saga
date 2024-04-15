package com.markswell.saleservice.adapter.in.request;

import com.markswell.saleservice.application.core.domain.enums.SalesStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SaleRequest {

    @NotNull
    private Integer productId;

    @NotNull
    private Integer userId;

    @NotNull
    private BigDecimal value;

    @NotNull
    private Integer quantity;

}
