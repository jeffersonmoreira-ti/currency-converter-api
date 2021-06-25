package com.api.currencyconverterapi.model;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExchangeRate {
    private boolean success;
    private Long timeStamp;
    private String base;
    private LocalDate date;
    private Map<String, Double> rates = new HashMap<String, Double>();

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "success=" + success +
                ", timeStamp=" + timeStamp +
                ", base='" + base + '\'' +
                ", date=" + date +
                ", rates=" + rates +
                '}';
    }
}
