package com.goodreads.environment;

import java.io.*;
import java.util.Properties;

public class PropertiesController {

    public static Properties loadProperties(String propertiesPath) {
        Properties properties = new Properties();
        try (InputStream in = new FileInputStream(propertiesPath)) {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static void createPropertyFile(String propertiesPath, Properties properties) {
        try (OutputStream out = new FileOutputStream(propertiesPath)) {
            properties.store(out, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
