package com.api.currencyconverterapi.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ConversionTransaction {

    @Id
    private String id;
    private String UserId;
    private String sourceCurrency;
    private BigDecimal sourceValue;
    private String destinationCurrency;
    private BigDecimal destinationValue;
    private BigDecimal appliedConversionRate;
    @CreatedDate
    private Instant conversionRequestUTC;
    private Long conversionResponseTimestamp;

    public ConversionTransaction() {
        super();
    }

    public ConversionTransaction(String userId, String sourceCurrency, BigDecimal sourceValue,
                                 String destinationCurrency, BigDecimal appliedConversionRate,
                                 Instant conversionRequestUTC) {
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

    public BigDecimal getDestinationValue() {
        return destinationValue;
    }

    public void setDestinationValue(BigDecimal destinationValue) {
        this.destinationValue = destinationValue;
    }

    public BigDecimal getAppliedConversionRate() {
        return appliedConversionRate;
    }

    public void setAppliedConversionRate(BigDecimal appliedConversionRate) {
        this.appliedConversionRate = appliedConversionRate;
    }

    public Instant getConversionRequestTimestamp() {
        return conversionRequestUTC;
    }

    public void setConversionRequestTimestamp(Instant conversionRequestTimestamp) {
        this.conversionRequestUTC = conversionRequestTimestamp;
    }

    public Long getConversionResponseTimestamp() {
        return conversionResponseTimestamp;
    }

    public void setConversionResponseTimestamp(Long conversionResponseTimestamp) {
        this.conversionResponseTimestamp = conversionResponseTimestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConversionTransaction that = (ConversionTransaction) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
