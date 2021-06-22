package com.api.currencyconverterapi.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Document	
public class ConversionTransactionModel {

	@Id
	
	private String id;
	private String UserId;
	private String sourceCurrency;
	private double sourceValue;
	private String destinationCurrency;
	private double appliedConversionRate;
	@CreatedDate
	private LocalDateTime conversionRequestTimestamp;
	@LastModifiedDate
	private LocalDateTime conversionResponseTimestamp;
	
	
}
