package com.manug2.scout.glue.pages.view;

import com.manug2.scout.glue.browser.BrowserDriver;
import com.manug2.scout.glue.pages.container.LoginContainer;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

import static com.manug2.scout.glue.browser.BrowserDriver.halt;


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

    public static void checkLoginSuccess(){
        LOGGER.info("Check login was successful");
        //HomeView.isDisplayedCheck();
    }

    public static void checkLoginErrors(){
        LOGGER.info("Check login errors displayed");
        BrowserDriver.waitForElement(loginContainer.usernameInput);
        BrowserDriver.waitForElement(loginContainer.passwordInput);
    }

}
