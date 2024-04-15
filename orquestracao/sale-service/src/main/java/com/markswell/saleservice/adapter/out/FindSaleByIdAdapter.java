package com.markswell.saleservice.adapter.out;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.markswell.saleservice.application.core.domain.Sale;
import com.markswell.saleservice.adapter.out.repository.SaleRepository;
import com.markswell.saleservice.adapter.out.repository.mapper.SaleMapper;
import com.markswell.saleservice.application.port.out.FindSaleByIdOutputPort;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindSaleByIdAdapter implements FindSaleByIdOutputPort {

    private final SaleMapper saleMapper;
    private final SaleRepository saleRepository;

    @Override
    public Optional<Sale> find(Integer saleId) {
        return saleRepository.findById(saleId)
                .map(saleMapper::toSale);
    }

}
