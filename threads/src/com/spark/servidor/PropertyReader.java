package com.spark.servidor;

import java.io.FileReader;
import java.util.Properties;

public class PropertyReader implements Runnable {
    private Properties properties;
    private String fileName;

    public PropertyReader(Properties properties, String fileName) {
        this.properties = properties;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try {
//            throw new RuntimeException("Error in property");
            this.properties.load(new FileReader(fileName));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
