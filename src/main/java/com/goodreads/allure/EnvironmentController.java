package com.goodreads.allure;

import com.goodreads.utils.PropertiesController;

import java.io.*;
import java.util.Properties;

public class EnvironmentController {

    private Properties environmentProperties = new Properties();

    public EnvironmentController setupEnvironmentName(String environmentName) {
        environmentProperties.setProperty("environment name", environmentName);
        return this;
    }

    public EnvironmentController setupEnvironmentVersion(String environmentName) {
        environmentProperties.setProperty("environment version", environmentName);
        return this;
    }

    public EnvironmentController setupEndpointAPI(String environmentName) {
        environmentProperties.setProperty("endpoint", environmentName);
        return this;
    }

    public EnvironmentController loadPropertyFile() {
        try (InputStream in = new FileInputStream(
                PropertiesController.getProperty("input_environment_properties_path"))) {
            environmentProperties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    public void createPropertyFile() {
        try (OutputStream out = new FileOutputStream(
                PropertiesController.getProperty("output_environment_properties_path"))) {
            environmentProperties.store(out, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
