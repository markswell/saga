package com.markswell.saleservice.adapter.out.repository.mapper;

import com.markswell.saleservice.adapter.out.repository.entity.SaleEntity;
import com.markswell.saleservice.application.core.domain.Sale;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-20T22:10:00-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Private Build)"
)
@Component
public class SaleMapperImpl implements SaleMapper {

    @Override
    public SaleEntity toSaleEntity(Sale sale) {
        if ( sale == null ) {
            return null;
        }

        SaleEntity saleEntity = new SaleEntity();

        saleEntity.setId( sale.getId() );
        saleEntity.setProductId( sale.getProductId() );
        saleEntity.setUserId( sale.getUserId() );
        saleEntity.setValue( sale.getValue() );
        saleEntity.setStatus( sale.getStatus() );
        saleEntity.setQuantity( sale.getQuantity() );

        return saleEntity;
    }

    @Override
    public Sale toSale(SaleEntity saleEntity) {
        if ( saleEntity == null ) {
            return null;
        }

        Sale sale = new Sale();

        sale.setId( saleEntity.getId() );
        sale.setProductId( saleEntity.getProductId() );
        sale.setUserId( saleEntity.getUserId() );
        sale.setValue( saleEntity.getValue() );
        sale.setStatus( saleEntity.getStatus() );
        sale.setQuantity( saleEntity.getQuantity() );

        return sale;
    }
}
