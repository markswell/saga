package com.markswell.saleservice.adapter.in.controller;

import com.markswell.saleservice.adapter.in.controller.mapper.SaleRequestMapper;
import com.markswell.saleservice.adapter.in.request.SaleRequest;
import com.markswell.saleservice.application.core.domain.Sale;
import com.markswell.saleservice.application.port.in.SaveSaleInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/sales")
public class SaleController {

    private final SaleRequestMapper saleRequestMapper;
    private final SaveSaleInputPort saveSaleInputPort;

    @PostMapping
    public ResponseEntity<Sale> createSale(@Valid @RequestBody SaleRequest saleRequest) {
        log.info("Creating sale {}", saleRequest);
        var sale = saveSaleInputPort.save(saleRequestMapper.toSale(saleRequest));
        log.info("Sale created successful.");
        return ResponseEntity.status(HttpStatus.CREATED).body(sale);
    }

}
