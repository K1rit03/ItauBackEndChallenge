package com.itau.challenge.ItauChallenge.service;


import com.itau.challenge.ItauChallenge.entity.Transaction;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

@Service
public class TransactionService {
    private final Queue<Transaction> transactions = new LinkedBlockingQueue<>();
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void clearTransactions() {
        transactions.clear();
    }

    public DoubleSummaryStatistics getStatistics() {
        return transactions.stream()
                .filter(transaction -> transaction.getDataHora().isAfter(OffsetDateTime.now().minusSeconds(60)))
                .mapToDouble(Transaction::getValor)
                .summaryStatistics();
    }








}
