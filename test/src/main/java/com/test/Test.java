package com.test;

import java.io.InputStream;
import java.util.Properties;

public class Test {
	private static final String PROPERTIES_FILE = "config.properties";
    private Properties properties;
    
    public Test() {
        loadProperties();
    }

    private void loadProperties() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            properties = new Properties();
            properties.load(inputStream);
        } catch (Exception e) {
           
           
        }
    }
    
    public String getProperty(String key) {
        return properties.getProperty(key);
    }




}
