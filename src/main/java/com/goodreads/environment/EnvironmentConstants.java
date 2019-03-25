package com.goodreads.environment;

import java.util.Properties;

public class EnvironmentConstants {

    private EnvironmentConstants() {
    }

    private static final Properties MAIN_RESOURCES_PROPERTIES = PropertiesController
            .loadProperties("src/main/resources/resources.properties");
    public static final String INPUT_ENVIRONMENT_PROPERTIES_PATH
            = MAIN_RESOURCES_PROPERTIES.getProperty("INPUT_ENVIRONMENT_PROPERTIES_PATH");
    public static final String OUTPUT_ENVIRONMENT_PROPERTIES_PATH
            = MAIN_RESOURCES_PROPERTIES.getProperty("OUTPUT_ENVIRONMENT_PROPERTIES_PATH");

}
