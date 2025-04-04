package com.itau.challenge.ItauChallenge.entity;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@AllArgsConstructor
public class Transaction {
    private double valor;
    private OffsetDateTime dataHora;


}
