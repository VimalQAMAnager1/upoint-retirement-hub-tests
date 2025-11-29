package com.cognizant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VppSummary {

    private final WebDriver driver;
      WebDriverWait wait;

    public VppSummary(WebDriver driver) {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null. Ensure driver is initialized before creating page objects.");
        }
        this.driver = driver;
        wait   = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);

        boolean onExpectedUrl = wait.until(ExpectedConditions.urlContains("plan-summary"));
        if (!onExpectedUrl) {
            throw new IllegalStateException(
                    "Unexpected URL for VPP Summary. Current: " + driver.getCurrentUrl()
                            + " | Expected to contain: " + "plan-summary");



        }
}}
