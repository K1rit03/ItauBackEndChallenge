package com.itau.challenge.ItauChallenge.controller;

import com.itau.challenge.ItauChallenge.dto.StatisticsDto;
import com.itau.challenge.ItauChallenge.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.DoubleSummaryStatistics;

@RestController
@RequestMapping("/estatisticas")
public class StatisticController {
    private final TransactionService transactionService;

    public StatisticController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<StatisticsDto> getStatistics() {
        DoubleSummaryStatistics stats = transactionService.getStatistics();
        return ResponseEntity.ok(new StatisticsDto(stats));
    }
}