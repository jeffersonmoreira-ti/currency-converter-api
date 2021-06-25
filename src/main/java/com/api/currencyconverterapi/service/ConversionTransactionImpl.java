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
    private ConversionTransactionRepository conversionTransactionRepository;

    @Override
    public Flux<ConversionTransaction> findAll() {
        return conversionTransactionRepository.findAll();
    }

    @Override
    public Mono<ConversionTransaction> findById(String id) {
        return conversionTransactionRepository.findById(id);
    }

    @Override
    public Mono<ConversionTransaction> save(ConversionTransaction conversionTransaction) {
        return conversionTransactionRepository.save(conversionTransaction);
    }



}
