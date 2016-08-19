package com.manug2.scout.glue.pages.view;

import com.manug2.scout.glue.browser.BrowserDriver;
import com.manug2.scout.glue.pages.container.HomeContainer;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;


public class HomeView {

    private static final Logger LOGGER = Logger.getLogger(HomeView.class.getName());
    private static final HomeContainer homeContainer =
            PageFactory.initElements(BrowserDriver.getCurrentDriver(), HomeContainer.class);

    public static void checkLoginSuccess(){
        LOGGER.info("Check login was successful");
        checkLoginMessage();
    }

    private static void checkLoginMessage() {
        BrowserDriver.waitForElement(homeContainer.homePageTitle);
        assertEquals("Welcome to Home Page!", homeContainer.homePageTitle.getText());
    }

    public static boolean isDisplayedCheck() {
        LOGGER.info("Checking login page is displayed");
        BrowserDriver.waitForElement(homeContainer.homePageTitle);
        return homeContainer.homePageTitle.isDisplayed();
    }
}
