package com.api.currencyconverterapi.controller;

import com.api.currencyconverterapi.model.ConversionTransaction;
import com.api.currencyconverterapi.model.ExchangeRate;
import com.api.currencyconverterapi.service.ConversionTransactionService;
import com.api.currencyconverterapi.util.ExternalAPIProperties;
import com.api.currencyconverterapi.util.PropertiesLoader;
import com.api.currencyconverterapi.webclient.ExchangeRatesClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.xml.transform.Source;
import java.math.BigDecimal;
import java.util.function.BiConsumer;

@RestController
public class ConversionTransactionController {

    @Autowired
    ConversionTransactionService conversionTransactionService;

    @Autowired
    private ExchangeRatesClient exchangeRatesClient;

    private final PropertiesLoader propertiesLoader = new PropertiesLoader("exchangeratesapi.properties");

    private final ExternalAPIProperties externalAPIProperties = new ExternalAPIProperties(propertiesLoader.getPropertyValue("base_url"),
            propertiesLoader.getPropertyValue("key"),
            propertiesLoader.getPropertyValue("latest_path"));

    @RequestMapping(value = "/transaction")
    public Flux<ConversionTransaction> getConversionTransaction() {
        return conversionTransactionService.findAll();
    }

    @RequestMapping(value = "/transaction/{id}")
    public ResponseEntity<Mono<ConversionTransaction>> getConversionTransaction(@PathVariable String id) {
        Mono<ConversionTransaction> conversionTransactionMono = conversionTransactionService.findById(id);
        HttpStatus status = conversionTransactionMono.block() != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;

        return new ResponseEntity<Mono<ConversionTransaction>>(conversionTransactionMono, status);
    }

    @PostMapping(value = "/transaction")
    public Mono<ConversionTransaction> save(@RequestBody ConversionTransaction conversionTransaction) {
        return conversionTransactionService.save(conversionTransaction);
    }

    @PostMapping(value = "/convert")
    public Mono<ConversionTransaction> convert(@RequestBody ConversionTransaction conversionTransaction) {
        Mono<ConversionTransaction> monoConversionTransaction = conversionTransactionService.save(conversionTransaction);
        Mono<ExchangeRate> specifiedExchangeRate = exchangeRatesClient.getSpecifiedExchangeRates(conversionTransaction.getSourceCurrency(), conversionTransaction.getDestinationCurrency());

        /*The Free API version is returning only EUR as base currency. So, the method has to convert from the currency
        requested by the user to convert from, to EUR and then to the currency the user's currency requested to.
        */
        Double currencyFrom = specifiedExchangeRate.block().getRates().get(conversionTransaction.getSourceCurrency());
        Double currencyTo = specifiedExchangeRate.block().getRates().get(conversionTransaction.getDestinationCurrency());

        System.out.println(specifiedExchangeRate.block().getRates());

        conversionTransaction = Mono.zip(monoConversionTransaction, specifiedExchangeRate).map(tuple -> {
            tuple.getT1().setDestinationValue(convertValue(tuple.getT1().getSourceValue().doubleValue(), currencyFrom, currencyTo));
            tuple.getT1().setAppliedConversionRate(BigDecimal.valueOf(currencyFrom / currencyTo));
            tuple.getT1().setConversionResponseTimestamp(tuple.getT2().getTimeStamp());
            return tuple.getT1();
        }).block();

        return conversionTransactionService.save(conversionTransaction);

    }


    private BigDecimal convertValue(Double sourceValue, Double currencyFrom, Double currencyTo) {
        double valueOfSourceToDestination = currencyFrom / currencyTo;
        return BigDecimal.valueOf(sourceValue / valueOfSourceToDestination);
    }
}
