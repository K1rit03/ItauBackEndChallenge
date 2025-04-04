package com.itau.challenge.ItauChallenge.dto;


import lombok.Getter;

import java.util.DoubleSummaryStatistics;


@Getter

public class StatisticsDto {
    private long count;
    private double sum;
    private double min;
    private double max;
    private double avg;

    public StatisticsDto(DoubleSummaryStatistics stats){
        this.count = stats.getCount();
        this.sum = stats.getSum();
        this.min = stats.getMin();
        this.max = stats.getMax();
        this.avg = stats.getAverage();

    }
}


