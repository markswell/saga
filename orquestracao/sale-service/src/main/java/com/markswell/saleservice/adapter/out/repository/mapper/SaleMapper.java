package com.markswell.saleservice.adapter.out.repository.mapper;

import org.mapstruct.Mapper;
import com.markswell.saleservice.application.core.domain.Sale;
import com.markswell.saleservice.adapter.out.repository.entity.SaleEntity;

@Mapper(componentModel = "spring")
public interface SaleMapper {

    SaleEntity toSaleEntity(Sale sale);

    Sale toSale(SaleEntity saleEntity);

}
