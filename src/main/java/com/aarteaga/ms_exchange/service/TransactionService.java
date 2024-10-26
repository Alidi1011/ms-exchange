package com.aarteaga.ms_exchange.service;

import com.aarteaga.ms_exchange.model.Transaction;

import java.util.List;

public interface TransactionService {
    public List<Transaction> findAll();
    public Transaction create(Transaction transaction);
}
