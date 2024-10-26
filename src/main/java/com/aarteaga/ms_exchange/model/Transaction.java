package com.aarteaga.ms_exchange.model;


import jakarta.persistence.*;
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
    private Double initialAmount;
    private Double finalAmount;
    private Double exchangeRate;
    private String originCurrency;
    private String destinyCurrency;
    private LocalDateTime transactionDate;
}
