package com.api.currencyconverterapi.controller;

import com.api.currencyconverterapi.model.ConversionTransaction;
import com.api.currencyconverterapi.service.ConversionTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ConversionTransactionController {

    @Autowired
    ConversionTransactionService conversionTransactionService;

    @RequestMapping(value = "/transaction")
    public Flux<ConversionTransaction> getConversionTransaction() {
        return conversionTransactionService.findAll();
    }

    @RequestMapping(value = "/transaction/{id}")
    public Mono<ConversionTransaction> getConversionTransaction(@PathVariable String id) {
        return conversionTransactionService.findById(id);
    }

    @PostMapping(value = "/transaction")
    public Mono<ConversionTransaction> save(@RequestBody ConversionTransaction conversionTransaction) {
        return conversionTransactionService.save(conversionTransaction);
    }
}
