package com.markswell.saleservice.adapter.in.controller.mapper;

import org.mapstruct.Mapper;
import com.markswell.saleservice.application.core.domain.Sale;
import com.markswell.saleservice.adapter.in.request.SaleRequest;

@Mapper(componentModel = "spring")
public interface SaleRequestMapper {

    Sale toSale(SaleRequest saleRequest);

}
