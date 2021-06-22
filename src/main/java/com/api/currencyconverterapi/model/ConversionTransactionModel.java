package com.api.currencyconverterapi.model;

import java.math.BigDecimal;
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
	private BigDecimal sourceValue;
	private String destinationCurrency;
	private BigDecimal destinantionValue;
	private BigDecimal appliedConversionRate;
	@CreatedDate
	private LocalDateTime conversionRequestUTC;
	@LastModifiedDate
	private LocalDateTime conversionResponseUTC;

	public ConversionTransactionModel() {
		super();
	}

	public ConversionTransactionModel(String userId, String sourceCurrency, BigDecimal sourceValue,
			String destinationCurrency, BigDecimal appliedConversionRate, LocalDateTime conversionRequestUTC) {
		super();
		UserId = userId;
		this.sourceCurrency = sourceCurrency;
		this.sourceValue = sourceValue;
		this.destinationCurrency = destinationCurrency;
		this.appliedConversionRate = appliedConversionRate;
		this.conversionRequestUTC = conversionRequestUTC;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSourceCurrency() {
		return sourceCurrency;
	}

	public void setSourceCurrency(String sourceCurrency) {
		this.sourceCurrency = sourceCurrency;
	}

	public BigDecimal getSourceValue() {
		return sourceValue;
	}

	public void setSourceValue(BigDecimal sourceValue) {
		this.sourceValue = sourceValue;
	}

	public String getDestinationCurrency() {
		return destinationCurrency;
	}

	public void setDestinationCurrency(String destinationCurrency) {
		this.destinationCurrency = destinationCurrency;
	}

	public BigDecimal getDestinantionValue() {
		return destinantionValue;
	}

	public void setDestinantionValue(BigDecimal destinantionValue) {
		this.destinantionValue = destinantionValue;
	}

	public BigDecimal getAppliedConversionRate() {
		return appliedConversionRate;
	}

	public void setAppliedConversionRate(BigDecimal appliedConversionRate) {
		this.appliedConversionRate = appliedConversionRate;
	}

	public LocalDateTime getConversionRequestTimestamp() {
		return conversionRequestUTC;
	}

	public void setConversionRequestTimestamp(LocalDateTime conversionRequestTimestamp) {
		this.conversionRequestUTC = conversionRequestTimestamp;
	}

	public LocalDateTime getConversionResponseTimestamp() {
		return conversionResponseUTC;
	}

	public void setConversionResponseTimestamp(LocalDateTime conversionResponseTimestamp) {
		this.conversionResponseUTC = conversionResponseTimestamp;
	}

}
