package com.manug2.scout.glue.pages.view;

import com.manug2.scout.glue.assertions.ScoutAssert;
import com.manug2.scout.glue.browser.BrowserDriver;
import com.manug2.scout.glue.pages.container.LoginContainer;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

import static com.manug2.scout.glue.browser.BrowserDriver.halt;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


public class LoginView {

    private static final Logger LOGGER = Logger.getLogger(LoginView.class.getName());
    private static final LoginContainer loginContainer =
            PageFactory.initElements(BrowserDriver.getCurrentDriver(), LoginContainer.class);

    public static void login(String username, String password){
        LOGGER.info("Logging in with username:"+username+" password:"+password);
        loginContainer.usernameInput.sendKeys(username);
        loginContainer.passwordInput.sendKeys(password);
        halt();
        loginContainer.submitButton.click();
        LOGGER.info("Login submitted");
    }

    public static void checkLoginErrors(){
        LOGGER.info("Check login errors displayed");
        BrowserDriver.waitForElement(loginContainer.badLogin);
    }

    public static void checkLoginSuccess() {
        try {
            assertTrue("Login page is not displayed", HomeView.isDisplayedCheck());
            HomeView.checkLoginSuccess();
        } catch (TimeoutException timeout) {
            if(ScoutAssert.isNSEE(timeout))
                fail("Could not detect Home Page!");
            else
                throw timeout;
        }
    }

    public static boolean isDisplayedCheck(){
        LOGGER.info("Checking login page is displayed");
        BrowserDriver.waitForElement(loginContainer.loginPageDiv);
        return loginContainer.loginPageDiv.isDisplayed();
    }

    public static void reset() {
        loginContainer.resetButton.click();
    }

    public static boolean isReset() {
        return StringUtils.isBlank(loginContainer.badLogin.getText());
    }
}
