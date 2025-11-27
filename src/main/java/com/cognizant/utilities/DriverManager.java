package com.cognizant.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager{
    public static WebDriver  driver;
    public static WebDriver getDriver(){

        if(driver==null){
            String browser=System.getProperty("browser","chrome");
            switch (browser.toLowerCase()){
                case ("firefox"):
                    driver=new FirefoxDriver();
                    break;
                case("chrome"):
                default:
                    driver= new ChromeDriver();

            }
            driver.manage().window().maximize();
        }
        return driver;

    }

    public static void quitDriver(){
        if(driver != null){
            driver.quit();
            driver=null;
        }
    }
}

