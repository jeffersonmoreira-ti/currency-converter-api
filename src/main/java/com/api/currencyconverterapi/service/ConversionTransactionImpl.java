package com.api.currencyconverterapi.service;

import com.api.currencyconverterapi.model.ConversionTransaction;
import com.api.currencyconverterapi.repository.ConversionTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ConversionTransactionImpl implements ConversionTransactionService {

    @Autowired
    ConversionTransactionRepository ctr;

    @Override
    public Flux<ConversionTransaction> findAll() {
        return ctr.findAll();
    }

    @Override
    public Mono<ConversionTransaction> findById(String id) {
        return ctr.findById(id);
    }

    @Override
    public Mono<ConversionTransaction> save(ConversionTransaction conversionTransaction) {
        return ctr.save(conversionTransaction);
    }
}
