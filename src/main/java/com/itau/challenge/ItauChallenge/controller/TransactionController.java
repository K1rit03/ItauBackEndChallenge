package com.itau.challenge.ItauChallenge.controller;

import com.itau.challenge.ItauChallenge.dto.TransactionDto;
import com.itau.challenge.ItauChallenge.entity.Transaction;
import com.itau.challenge.ItauChallenge.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transacao")
    public ResponseEntity<Void> createTransaction(@RequestBody TransactionDto transaction) {
        if (transaction.getDataHora() == null || !transaction.getDataHora().isBefore(OffsetDateTime.now())) {
            return ResponseEntity.unprocessableEntity().build();
        }
        transactionService.addTransaction(new Transaction(transaction.getValor(), transaction.getDataHora()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/transacao")
    public ResponseEntity<Void> clearTransaction() {
        transactionService.clearTransactions();
        return ResponseEntity.ok().build();
    }
}
