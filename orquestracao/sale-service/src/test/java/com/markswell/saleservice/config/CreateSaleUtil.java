package com.markswell.saleservice.config;

import com.markswell.saleservice.application.core.domain.Sale;

import java.math.BigDecimal;

import static com.markswell.saleservice.application.core.domain.enums.SalesStatus.PENDING;

public class CreateSaleUtil {

    public static Sale createNewSale() {
        return new Sale(null, 1, 1, BigDecimal.ONE, PENDING, 1);
    }

}
