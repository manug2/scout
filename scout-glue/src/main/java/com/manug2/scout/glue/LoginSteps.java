package com.manug2.scout.glue;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

public class LoginSteps {

    private static final Logger LOGGER = Logger.getLogger(LoginSteps.class.getName());
    @Given("^I navigate to the mock application$")
    public void given_I_navigate_to_the_mock_application(){
        LOGGER.info("Entering: I navigate to the mock application");
        BrowserDriver.loadPage(BrowserConstants.APP_URL);

    }

    @When("^I try to login with '(.+)' credentials$")
    public void when_I_try_to_login(String credentialsType){
        LOGGER.info("Entering: I try to login with " +
                credentialsType + " credentials");
    }

    @Then("^I should see that I logged in '(.+)'$")
    public void then_I_login(String outcome){

        LOGGER.info("Entering: I should see that I logged in " + outcome);
    }

    @Then("^I should check that title is '(.+)'$")
    public void i_should_check_that_title_is(String title) throws Throwable {
        assertEquals(title, BrowserDriver.getCurrentDriver().getTitle());
    }
}
