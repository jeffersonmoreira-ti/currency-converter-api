package com.api.currencyconverterapi.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesLoader {

    private Properties properties;

    public PropertiesLoader(String fileName) throws RuntimeException {
        properties = new Properties();
        InputStream propertiesFileContent = this.getClass().getClassLoader()
                .getResourceAsStream(fileName != null ? fileName : "resources/exchangeratesapi.properties");

        try {
            properties.load(propertiesFileContent);
            propertiesFileContent.close();
        } catch (IOException e) {
            throw new RuntimeException("Properties file not found", e);
        }

    }

    public String getPropertyValue(String property) {
        return properties.getProperty(property);
    }

}
