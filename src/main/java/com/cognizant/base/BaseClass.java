
package com.cognizant.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseClass {
    // Prevent direct instantiation
    protected BaseClass() {}

    // Single instance of WebDriver (not parallel-safe)
    private static WebDriver driver;

    /**
     * Return the initialized driver or fail fast if it's null.
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver is not initialized. Call initializeDriver(browser) first.");
        }
        return driver;
    }

    /**
     * Initialize a single WebDriver instance based on browser name.
     * @param browser "chrome" or "edge"
     */
    public static synchronized void initializeDriver(String browser) {
        if (driver != null) {
            // Already initialized: reuse
            return;
        }

        if (browser == null) {
            throw new IllegalArgumentException("Browser name cannot be null. Use 'chrome' or 'edge'.");
        }

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:
                throw new RuntimeException("Unsupported browser: " + browser + ". Use 'chrome' or 'edge'.");
        }

        driver.manage().window().maximize();
    }

    /**
     * Quit and cleanup the driver instance.
     */
    public static synchronized void quitDriver() {
        if (driver != null) {
            try {
                driver.quit();
            } finally {
                driver = null;
            }
        }
    }
}
