package com.hellofresh.challenge.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    private static Properties prop = new Properties();
    private static String fileName = "src/test/resources/config.properties";

    public static String getProperty(String arg) {
        try {
            // load a properties file for reading
            prop.load(new FileInputStream(fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop.getProperty(arg);
    }


}

