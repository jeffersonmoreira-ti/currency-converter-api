package com.api.currencyconverterapi;

import com.api.currencyconverterapi.model.ConversionTransaction;
import com.api.currencyconverterapi.repository.ConversionTransactionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootTest
public class ConversionTransactionRepositoryTest {

    @Autowired
    private ConversionTransactionRepository ctr;

    @Test
    void contextLoads() {

        ConversionTransaction conversionTransaction = new ConversionTransaction("123412",
                "BRL", BigDecimal.valueOf(1235), "USD",
                BigDecimal.valueOf(5.08), LocalDateTime.now());

        this.ctr.save(conversionTransaction);
    }
}
