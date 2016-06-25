package com.manug2.scout.glue.steps;


import com.manug2.scout.glue.browser.BrowserConstants;
import com.manug2.scout.glue.browser.BrowserDriver;
import com.manug2.scout.glue.constants.Outcome;
import com.manug2.scout.glue.pages.view.LoginView;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.logging.Logger;

import static com.manug2.scout.glue.browser.BrowserDriver.halt;
import static org.junit.Assert.assertEquals;

public class LoginSteps {

    private static final Logger LOGGER = Logger.getLogger(LoginSteps.class.getName());
    @Given("^I navigate to the mock application$")
    public void given_I_navigate_to_the_mock_application(){
        LOGGER.info("Entering: I navigate to the mock application");
        BrowserDriver.loadPage(BrowserConstants.APP_URL + "/login.html");
    }

    @When("^I try to login with '(.+)' and '(.+)'$")
    public void when_I_try_to_login(String user, String password){
        halt();
        LOGGER.info("Entering: I try to login with " +
                user + " credentials");
        LoginView.login(user, password);
    }

    @Then("^I should see that I logged in '(.+)'$")
    public void then_I_login(String outcomeString){
        LOGGER.info("Entering: I should see that I logged in " + outcomeString);
        Outcome outcome = Outcome.outcomeForName(outcomeString);
        switch(outcome){
            case SUCCESS:
                LoginView.checkLoginSuccess();
                break;
            case FAILURE:
                LoginView.checkLoginErrors();
                break;
        }

        final String resultPageTitle = BrowserDriver.getCurrentDriver().getTitle();
        assertEquals("Login Success", resultPageTitle);
        halt();
    }

    @Then("^I should check that title is '(.+)'$")
    public void i_should_check_that_title_is(String title) throws Throwable {
        assertEquals(title, BrowserDriver.getCurrentDriver().getTitle());
    }
}
