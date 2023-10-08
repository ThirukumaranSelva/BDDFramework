package com.qa.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
    public static Properties properties=new Properties();

    public Properties getProperties() throws IOException {
        InputStream inputStream = null;
        String propertiesFile="config.properties";

        try {
            Utils.logger().info("Loading Config Files");
            inputStream=getClass().getClassLoader().getResourceAsStream(propertiesFile);
            properties.load(inputStream);
        } catch (IOException e) {
            Utils.logger().fatal("Failed to load Config File");
            throw new RuntimeException(e);
        }finally {
            if(inputStream!=null){
                inputStream.close();
            }
        }

        return properties;
    }

}
