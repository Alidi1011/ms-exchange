package com.aarteaga.ms_exchange.controller;

import com.aarteaga.ms_exchange.model.Transaction;
import com.aarteaga.ms_exchange.service.TransactionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.aarteaga.ms_exchange.security.Constants.*;
import static com.aarteaga.ms_exchange.security.Constants.SUPER_SECRET_KEY;

@Slf4j
@Tag(name = "Transaction", description = "Transaction Management API")
@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<Transaction>> findAll() {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(transactionService.findAll());
    }

    @PostMapping
    public ResponseEntity<Transaction> create(HttpServletRequest request, @Valid @RequestBody Transaction transaction) throws JsonProcessingException {
        String jwtToken = request.getHeader(HEADER_AUTHORIZACION_KEY).replace(TOKEN_BEARER_PREFIX, "");
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSigningKey(SUPER_SECRET_KEY))
                .build()
                .parseClaimsJws(jwtToken)
                .getBody();
        String username = claims.getSubject();
        transaction.setUserId(username);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(transactionService.create(transaction));
    }

}
