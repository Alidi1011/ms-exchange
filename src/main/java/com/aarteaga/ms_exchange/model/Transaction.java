package com.aarteaga.ms_exchange.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table(name="transaction")
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String userId;
    @NotNull
    private Double initialAmount;
    private Double finalAmount;
    private Double exchangeRate;
    @NotBlank
    private String originCurrency;
    @NotBlank
    private String destinyCurrency;
    private LocalDateTime transactionDate;
}
