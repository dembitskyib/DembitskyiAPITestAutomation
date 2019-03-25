package com.goodreads.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesController {

    private static final String PROPERTIES_PATH = "src/main/resources/resources.properties";
    private static Properties properties = loadProperties();

    public static String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }

    private static Properties loadProperties() {
        properties = new Properties();
        try (InputStream in = new FileInputStream(PROPERTIES_PATH)) {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

}
