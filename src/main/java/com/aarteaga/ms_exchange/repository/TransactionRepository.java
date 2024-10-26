package com.aarteaga.ms_exchange.repository;

import com.aarteaga.ms_exchange.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
