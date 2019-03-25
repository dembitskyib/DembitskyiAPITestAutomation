package com.goodreads.allure;

import com.goodreads.environment.EnvironmentConstants;
import com.goodreads.environment.PropertiesController;

import java.util.Properties;

public class AllureEnvironmentController {

    public void createPropertyFile() {
        Properties environmentProperties = PropertiesController.loadProperties(EnvironmentConstants.INPUT_ENVIRONMENT_PROPERTIES_PATH);
        PropertiesController.createPropertyFile(EnvironmentConstants.OUTPUT_ENVIRONMENT_PROPERTIES_PATH, environmentProperties);
    }

}
