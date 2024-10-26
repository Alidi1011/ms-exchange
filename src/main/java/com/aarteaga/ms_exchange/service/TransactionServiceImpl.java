package com.aarteaga.ms_exchange.service;

import com.aarteaga.ms_exchange.model.Transaction;
import com.aarteaga.ms_exchange.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction create(Transaction transaction) {
        //TODO Get list of exchange rate in base of originCurrency

        String originCurrency = transaction.getOriginCurrency();

        //TODO GET OF RATES DESTINY CURRENCY
        String destinyCurrency = transaction.getDestinyCurrency();

        Double exchangeRate = 3.76;

        Double finalAmount = transaction.getInitialAmount() * exchangeRate;
        transaction.setFinalAmount(finalAmount);
        transaction.setExchangeRate(exchangeRate);
        transaction.setTransactionDate(LocalDateTime.now());
        transactionRepository.save(transaction);

        return transactionRepository.save(transaction);
    }
}
