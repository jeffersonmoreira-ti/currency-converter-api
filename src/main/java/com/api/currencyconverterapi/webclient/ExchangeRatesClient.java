package com.api.currencyconverterapi.webclient;

import com.api.currencyconverterapi.model.ExchangeRate;
import com.api.currencyconverterapi.util.ExternalAPIProperties;
import com.api.currencyconverterapi.util.PropertiesLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ExchangeRatesClient {

    @Autowired
    private WebClient webClientExchangeRatesApi;

    private PropertiesLoader propertiesLoader = new PropertiesLoader("exchangeratesapi.properties");

    private ExternalAPIProperties externalAPIProperties = new ExternalAPIProperties(propertiesLoader.getPropertyValue("base_url"),
            propertiesLoader.getPropertyValue("key"),
            propertiesLoader.getPropertyValue("latest_path"));

    public Mono<ExchangeRate> getLatestExchangeRates() {
        Mono<ExchangeRate> monoExchangeRate = this.webClientExchangeRatesApi.get().uri(uriBuilder -> uriBuilder
                .path("/" + externalAPIProperties.getLatestPath())
                .queryParam("access_key", externalAPIProperties.getKey())
                .build())
                .retrieve()
                .bodyToMono(ExchangeRate.class);

        return monoExchangeRate;
    }

    public Mono<ExchangeRate> getSpecifiedExchangeRates(String sourceCurrency, String destinationCurrency) {
        Mono<ExchangeRate> monoExchangeRate = this.webClientExchangeRatesApi.get().uri(uriBuilder -> uriBuilder
                .path("/" + externalAPIProperties.getLatestPath())
                .queryParam("access_key", externalAPIProperties.getKey())
                .queryParam("symbols", "EUR".concat(",").concat(sourceCurrency).concat(",").concat(destinationCurrency))
                .build())
                .retrieve()
                .bodyToMono(ExchangeRate.class);

        return monoExchangeRate;
    }
}
