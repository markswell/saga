package com.markswell.saleservice.adapter.out.message;

import com.markswell.saleservice.application.core.domain.Sale;
import com.markswell.saleservice.application.core.domain.enums.SaleEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SaleMessage {

    private Sale sale;

    private SaleEvent event;

}
