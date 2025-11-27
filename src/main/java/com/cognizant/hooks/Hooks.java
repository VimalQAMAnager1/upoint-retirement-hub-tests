package com.cognizant.hooks;


import com.cognizant.utilities.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;




public class Hooks {

    public static WebDriver driver;

    @Before
    public void setup() {
        // Initialize the driver using the DriverManager
        DriverManager.getDriver();
    }

    @After
    public void teardown() {
        // Quit the driver using the DriverManager
        DriverManager.quitDriver();
    }
}

