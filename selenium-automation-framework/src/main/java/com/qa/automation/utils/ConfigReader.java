package com.qa.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        try {
            FileInputStream fileInputStream =
                    new FileInputStream("src/test/resources/config.properties");

            properties = new Properties();
            properties.load(fileInputStream);

            fileInputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(
                    "Unable to load config.properties file", e
            );
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
    
    public static String getBaseUrl() {
        return getProperty("baseUrl");
    }

    public static String getBrowser() {
        return getProperty("browser");
    }

    public static String getUsername() {
        return getProperty("username");
    }

    public static String getPassword() {
        return getProperty("password");
    }

    public static String getFirstName() {
        return getProperty("firstName");
    }

    public static String getLastName() {
        return getProperty("lastName");
    }

    public static String getPostalCode() {
        return getProperty("postalCode");
    }
}