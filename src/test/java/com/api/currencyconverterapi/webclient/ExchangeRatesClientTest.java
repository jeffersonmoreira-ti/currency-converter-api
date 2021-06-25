package com.api.currencyconverterapi.webclient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ExchangeRatesClientTest {

    @Autowired
    ExchangeRatesClient exchangeRatesClient = new ExchangeRatesClient();

    @Test
    void getLatestExchangeRates() {
        if(exchangeRatesClient != null) {
            System.out.println(exchangeRatesClient.getLatestExchangeRates());
        }
    }
}