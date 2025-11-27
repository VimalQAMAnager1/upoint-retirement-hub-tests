package com.cognizant.stepDefinition;

import com.cognizant.hooks.Hooks;
import com.cognizant.utilities.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;



public class StepDefinition {

    private WebDriver driver;

    public StepDefinition() {
        // Get the shared driver from the Hooks class
        this.driver = Hooks.driver;
        // Get the driver instance from the DriverManager
        this.driver = DriverManager.getDriver();
    }
    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password() {
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("User should be successfully logged in")
    public void user_should_be_successfully_logged_in() {
        // Write code here that turns the phrase above into concrete actions

    }
    }











