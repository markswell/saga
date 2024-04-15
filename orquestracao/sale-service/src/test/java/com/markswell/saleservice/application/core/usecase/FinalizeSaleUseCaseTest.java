package com.markswell.saleservice.application.core.usecase;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.containers.PostgreSQLContainer;
import org.springframework.boot.test.context.SpringBootTest;
import com.markswell.saleservice.adapter.out.SaveSaleAdapter;
import com.markswell.saleservice.application.core.domain.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import com.markswell.saleservice.adapter.out.FindSaleByIdAdapter;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.markswell.saleservice.adapter.out.repository.SaleRepository;
import com.markswell.saleservice.adapter.out.repository.mapper.SaleMapper;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import com.markswell.saleservice.application.core.domain.exception.SaleNotFoundException;
import com.markswell.saleservice.application.core.domain.exception.NullObjectReceivedException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static com.markswell.saleservice.config.CreateSaleUtil.createNewSale;
import static com.markswell.saleservice.application.core.domain.enums.SalesStatus.FINALIZED;

@Testcontainers
@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class FinalizeSaleUseCaseTest {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15-alpine");

    @Autowired
    SaleMapper saleMapper;

    @Autowired
    SaleRepository saleRepository;

    FindSaleByIdUseCase findSaleByIdUseCase;

    SaveSaleAdapter saveSaleAdapter;

    FinalizeSaleUseCase finalizeSaleUseCase;

    @BeforeEach
    public void setup() {
        var findSaleByIdAdapter = new FindSaleByIdAdapter(saleMapper, saleRepository);

        findSaleByIdUseCase = new FindSaleByIdUseCase(findSaleByIdAdapter);
        saveSaleAdapter = new SaveSaleAdapter(saleMapper, saleRepository);
        finalizeSaleUseCase = new FinalizeSaleUseCase(findSaleByIdUseCase, saveSaleAdapter);
    }

    @Test
    @Order(1)
    @DisplayName("This test guarantees that the method change the status of sale to FINALIZED")
    public void shouldCancelSaleTest() {
        saveSaleAdapter.save(createNewSale());
        Sale sale = findSaleByIdUseCase.find(1);
        finalizeSaleUseCase.finalize(sale);
        Sale canceledSale = findSaleByIdUseCase.find(1);

        assertThat(canceledSale.getStatus()).isEqualTo(FINALIZED);

    }

    @Test
    @Order(2)
    @DisplayName("This test guarantees the correct error when a null value are passed")
    public void shouldThrowANullPointerExceptionWhenReceiveANullVAlue() {
        NullObjectReceivedException exception = assertThrows(NullObjectReceivedException.class, () -> finalizeSaleUseCase.finalize(null));

        assertThat(exception.getMessage()).isEqualTo("A null sale was received.");
    }

    @Test
    @Order(3)
    @DisplayName("This test guarantees the correct error when non-existent sale is passed")
    public void shouldThrowASaleNotFoundExceptionWhenSaleIdNotExists() {
        Sale sale = findSaleByIdUseCase.find(1);
        sale.setId(2);
        var exception = assertThrows(SaleNotFoundException.class, () -> finalizeSaleUseCase.finalize(sale));

        assertThat(exception.getMessage()).isEqualTo("Sale 2 was not found");
    }

}