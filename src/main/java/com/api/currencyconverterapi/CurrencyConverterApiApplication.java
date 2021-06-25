package com.api.currencyconverterapi;

import com.api.currencyconverterapi.util.ExternalAPIProperties;
import com.api.currencyconverterapi.util.PropertiesLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;


@SpringBootApplication
@ComponentScan(basePackages = {"com.api.currencyconverterapi"})
public class CurrencyConverterApiApplication {

    private PropertiesLoader propertiesLoader = new PropertiesLoader("exchangeratesapi.properties");

    private ExternalAPIProperties externalAPIProperties = new ExternalAPIProperties(propertiesLoader.getPropertyValue("base_url"),
            propertiesLoader.getPropertyValue("key"),
            propertiesLoader.getPropertyValue("latest_path"));

    @Bean
    public WebClient webClientExchangeRatesApi(WebClient.Builder builder) {
        return builder
                .baseUrl(externalAPIProperties.getBaseURL())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(CurrencyConverterApiApplication.class, args);
    }
}
