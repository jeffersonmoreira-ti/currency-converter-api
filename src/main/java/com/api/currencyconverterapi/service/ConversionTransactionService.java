package com.api.currencyconverterapi.service;

import com.api.currencyconverterapi.model.ConversionTransaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface ConversionTransactionService {
    Flux<ConversionTransaction> findAll();

    Mono<ConversionTransaction> findById(String id);

    Mono<ConversionTransaction> save(ConversionTransaction conversionTransaction);
}
