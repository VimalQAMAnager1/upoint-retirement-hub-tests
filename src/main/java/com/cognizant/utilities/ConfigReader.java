package com.cognizant.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {
    public static Properties prop;

    public static Properties initProperties() {
        prop = new Properties();
        //Read from Maven Command
        String env = System.getProperty("env", "stage");

        String path = "src/test/resources/config/" + env + ".properties";
        try {
            FileInputStream fis = new FileInputStream(path);
            prop.load(fis);


        } catch (Exception e) {
            e.printStackTrace();

        }
        return prop;
    }
}