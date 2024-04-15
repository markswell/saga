package com.markswell.saleservice.application.core.usecase;

import org.mockito.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testcontainers.containers.PostgreSQLContainer;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.boot.test.context.SpringBootTest;
import com.markswell.saleservice.adapter.out.SaveSaleAdapter;
import com.markswell.saleservice.application.core.domain.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import com.markswell.saleservice.adapter.out.SendCreatedSaleAdapter;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.markswell.saleservice.adapter.out.repository.SaleRepository;
import com.markswell.saleservice.adapter.out.repository.mapper.SaleMapper;
import com.markswell.saleservice.application.port.in.FindSaleByIdInputPort;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import com.markswell.saleservice.application.core.domain.exception.SaleNotFoundException;

import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static com.markswell.saleservice.config.CreateSaleUtil.createNewSale;

@Testcontainers
@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FindSaleByIdUseCaseTest {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15-alpine");

    @Autowired
    FindSaleByIdInputPort findSaleByIdInputPort;

    @Autowired
    SaleMapper saleMapper;

    @Autowired
    SaleRepository saleRepository;

    @Mock
    SendCreatedSaleAdapter sendCreatedSaleAdapter;

    SaveSaleUseCase saveSaleUseCase;

    @BeforeEach
    public void setUp() {
        var saveSaleAdapter = new SaveSaleAdapter(saleMapper, saleRepository);
        saveSaleUseCase = new SaveSaleUseCase(saveSaleAdapter, sendCreatedSaleAdapter);
    }

    @Test
    @Order(1)
    @DisplayName("This test guarantees that the message given by exception are correct.")
    public void shouldFailFindTest() {
        SaleNotFoundException exception = assertThrows(SaleNotFoundException.class, () ->  findSaleByIdInputPort.find(1));
        assertTrue(exception.getMessage().equals("Sale 1 was not found"));
    }

    @Test
    @Order(2)
    @DisplayName("This test guarantees that the object is returned correctly")
    public void  shouldSaveTest() {
        saveSaleUseCase.save(createNewSale());
        Sale sale = findSaleByIdInputPort.find(1);

        assertThat(sale).isNotNull();
    }

}