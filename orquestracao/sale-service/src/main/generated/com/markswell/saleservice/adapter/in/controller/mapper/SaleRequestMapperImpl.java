package com.markswell.saleservice.adapter.in.controller.mapper;

import com.markswell.saleservice.adapter.in.request.SaleRequest;
import com.markswell.saleservice.application.core.domain.Sale;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-20T22:10:00-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Private Build)"
)
@Component
public class SaleRequestMapperImpl implements SaleRequestMapper {

    @Override
    public Sale toSale(SaleRequest saleRequest) {
        if ( saleRequest == null ) {
            return null;
        }

        Sale sale = new Sale();

        sale.setProductId( saleRequest.getProductId() );
        sale.setUserId( saleRequest.getUserId() );
        sale.setValue( saleRequest.getValue() );
        sale.setQuantity( saleRequest.getQuantity() );

        return sale;
    }
}
