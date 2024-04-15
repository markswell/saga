package com.markswell.saleservice.adapter.out.repository.entity;

import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.markswell.saleservice.application.core.domain.enums.SalesStatus;

import java.math.BigDecimal;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sales")
public class SaleEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    private Integer productId;

    private Integer userId;

    private BigDecimal value;

    @Enumerated(STRING)
    private SalesStatus status;

    private Integer quantity;

}
