
package com.cognizant.stepDefinition;

import com.cognizant.base.BaseClass;
import com.cognizant.pages.Homepage;
import com.cognizant.pages.VppSummary;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {

        Homepage hm = new Homepage(BaseClass.getDriver());
        hm.enterZip(String.valueOf(12345)); // convert int to String
        VppSummary vpp= hm.viewPlans();
    }

    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password() {
        System.out.println("Raju");
        // TODO: Implement entering username/password and clicking login using a LoginPage object
    }

    @Then("User should be successfully logged in")
    public void user_should_be_successfully_logged_in() {
        System.out.println("vimal");
        // TODO: Assert post-login element (e.g., user menu on Homepage)
    }
}
