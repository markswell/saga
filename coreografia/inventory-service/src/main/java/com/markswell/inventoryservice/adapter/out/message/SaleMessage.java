package com.markswell.inventoryservice.adapter.out.message;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.markswell.inventoryservice.application.core.domain.Sale;
import com.markswell.inventoryservice.application.core.domain.enums.SaleEvent;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleMessage {

    private Sale sale;

    private SaleEvent event;

}
