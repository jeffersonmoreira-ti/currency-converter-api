package com.api.currencyconverterapi.controller;

import com.api.currencyconverterapi.model.ConversionTransaction;
import com.api.currencyconverterapi.service.ConversionTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(value = "/transaction/{id}", method = RequestMethod.GET)
    public ResponseEntity<Mono<ConversionTransaction>> getConversionTransaction(@PathVariable("id") String id) {
        Mono<ConversionTransaction> conversionTransactionMono = conversionTransactionService.findById(id);
        HttpStatus status = conversionTransactionMono != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;

        return new ResponseEntity<Mono<ConversionTransaction>>(conversionTransactionMono, status);
    }

    @PostMapping(value = "/transaction")
    public Mono<ConversionTransaction> save(@RequestBody ConversionTransaction conversionTransaction) {
        return conversionTransactionService.save(conversionTransaction);
    }
}
