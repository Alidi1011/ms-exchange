package com.aarteaga.ms_exchange.service;

import com.aarteaga.ms_exchange.client.ExchangeRateClient;
import com.aarteaga.ms_exchange.model.Exchange;
import com.aarteaga.ms_exchange.model.Transaction;
import com.aarteaga.ms_exchange.repository.TransactionRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    ExchangeRateClient exchangeRateClient;

    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction create(Transaction transaction) throws JsonProcessingException {

        Exchange exchange = exchangeRateClient.getExchangeByCurrency(transaction.getOriginCurrency());

        log.info("RATES: {}", exchange.getRates());

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRates = objectMapper.writeValueAsString(exchange.getRates());
        Double exchangeRate = objectMapper.readTree(jsonRates).get(transaction.getDestinyCurrency()).asDouble();

        log.info("RATE: {}", exchangeRate);

        Double finalAmount = transaction.getInitialAmount() * exchangeRate;

        log.info("FINAL AMOUNT: {}", finalAmount);

        Double finalAmountRounded =Math.round(finalAmount * 1000.0)/1000.0;

        transaction.setFinalAmount(finalAmountRounded);
        transaction.setExchangeRate(exchangeRate);
        transaction.setTransactionDate(LocalDateTime.now());

        return transactionRepository.save(transaction);
    }
}
