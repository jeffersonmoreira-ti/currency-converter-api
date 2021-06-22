package com.api.currencyconverterapi.repository;

import com.api.currencyconverterapi.model.ConversionTransaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ConversionTransactionRepository extends ReactiveMongoRepository<ConversionTransaction, String> {
}
