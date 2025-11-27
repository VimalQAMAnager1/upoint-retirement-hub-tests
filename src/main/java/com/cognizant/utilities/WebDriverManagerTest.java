package com.cognizant.utilities;


import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertNotNull;


public class WebDriverManagerTest {


    public void testChromeDriverInitiation() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Instantiate the driver
        WebDriver driver = new ChromeDriver();

        // Assert that the driver is not null
        assertNotNull(driver, "WebDriver should be initiated");

        // Optional: Check if browser session is active
        driver.get("https://example.com");
        assertNotNull(driver.getTitle());

        // Clean up
        driver.quit();
    }
}

