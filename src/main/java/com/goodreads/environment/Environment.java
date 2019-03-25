package com.goodreads.environment;

import java.util.Properties;

public interface Environment {

    Properties MAIN_RESOURCES_PROPERTIES = PropertiesController
            .loadProperties("src/main/resources/resources.properties");
    String INPUT_ENVIRONMENT_PROPERTIES_PATH
            = MAIN_RESOURCES_PROPERTIES.getProperty("INPUT_ENVIRONMENT_PROPERTIES_PATH");
    String OUTPUT_ENVIRONMENT_PROPERTIES_PATH
            = MAIN_RESOURCES_PROPERTIES.getProperty("OUTPUT_ENVIRONMENT_PROPERTIES_PATH");

}
