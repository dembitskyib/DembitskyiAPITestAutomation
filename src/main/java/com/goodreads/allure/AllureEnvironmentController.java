package com.goodreads.allure;

import com.goodreads.environment.Environment;
import com.goodreads.environment.PropertiesController;

import java.util.Properties;

public class AllureEnvironmentController {

    public void createPropertyFile() {
        Properties environmentProperties = PropertiesController.loadProperties(Environment.INPUT_ENVIRONMENT_PROPERTIES_PATH);
        PropertiesController.createPropertyFile(Environment.OUTPUT_ENVIRONMENT_PROPERTIES_PATH, environmentProperties);
    }

}
