package com.markswell.saleservice.adapter.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.markswell.saleservice.application.core.domain.Sale;
import com.markswell.saleservice.application.port.out.SaveSaleOutputPort;
import com.markswell.saleservice.adapter.out.repository.SaleRepository;
import com.markswell.saleservice.adapter.out.repository.mapper.SaleMapper;

@Component
public class SaveSaleAdapter implements SaveSaleOutputPort {

    @Autowired
    private SaleMapper saleMapper;

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public Sale save(Sale sale) {
        var saleEntity = saleMapper.toSaleEntity(sale);
        var savedSaleEntity = saleRepository.save(saleEntity);
        return saleMapper.toSale(savedSaleEntity);
    }
}
