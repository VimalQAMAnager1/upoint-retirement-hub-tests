package com.cognizant.hooks;


import com.cognizant.base.BaseClass;
import com.cognizant.utilities.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;



public class Hooks {



    @Before
    public void setup() {
       //Load Environment specific properties
       ConfigReader.initProperties();
        String browser = ConfigReader.prop.getProperty("browser");
        String url =ConfigReader.prop.getProperty("url");
        //start Driver
        BaseClass.initializeDriver(browser);
        BaseClass.getDriver().get(url);
    }

    @After
    public void teardown() {
        // Quit the driver using the DriverManager
        BaseClass.quitDriver();
    }
}

