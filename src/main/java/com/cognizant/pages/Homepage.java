
package com.cognizant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

    private final WebDriver driver;

    public Homepage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is null. Ensure driver is initialized before creating page objects.");
        }
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // TODO: Replace this XPath with a stable locator (id, name, or data-test are preferred)
    @FindBy(xpath = "//div/input[contains(@id,'zipcodemeded-0')]")
    private WebElement zipcode;

    @FindBy(xpath="//*[contains(text(),'View plans')]")
    private WebElement viewPlans;

    public void enterZip(String zip) {
        zipcode.click();
        zipcode.clear();
        zipcode.sendKeys(zip);
    }

    public VppSummary viewPlans() {
        viewPlans.click();
        return new VppSummary(driver);
    }

}
