package com.manug2.scout.glue.browser;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.logging.Logger;

import static com.manug2.scout.glue.browser.BrowserConstants.HALT_FOR_DEMO;
import static com.manug2.scout.glue.browser.BrowserConstants.HALT_INTERVAL;

public class BrowserDriver {
    private static WebDriver mDriver;
    private static final Logger LOGGER = Logger.getLogger(BrowserDriver.class.getName());

    public synchronized static WebDriver getCurrentDriver() {
        if (mDriver==null) {
            try {
                LOGGER.info("loading browser");
                mDriver = DriverFactory.getBrowser(BrowserConstants.BROWSER);
            } finally{
                Runtime.getRuntime().addShutdownHook(
                        new Thread(new BrowserCleanup()));
            }
        }
        return mDriver;
    }


    private static class BrowserCleanup implements Runnable {
        public void run() {
            LOGGER.info("Closing the browser");
            close();
        }
    }

    public static void close() {
        try {
            getCurrentDriver().quit();
            mDriver = null;
        } catch (UnreachableBrowserException e) {
            LOGGER.info("cannot close browser: unreachable browser");
        }
    }

    public static void loadPage(String url){
        LOGGER.info(String.format("Directing browser to [%s]", url));
        getCurrentDriver().get(url);
    }

    public static void reopenAndLoadPage(String url) {
        mDriver = null;
        getCurrentDriver();
        loadPage(url);
    }

    public static WebElement waitForElement(WebElement elementToWaitFor){
        return waitForElement(elementToWaitFor, null);
    }

    public static WebElement waitForElement(WebElement elementToWaitFor, Integer waitTimeInSeconds) {
        if (waitTimeInSeconds == null) {
            waitTimeInSeconds = 10;
        }

        WebDriverWait wait = new WebDriverWait(getCurrentDriver(), waitTimeInSeconds);
        return wait.until(ExpectedConditions.visibilityOf(elementToWaitFor));
    }

    public static WebElement getParent(WebElement element) {
        return element.findElement(By.xpath(".."));
    }

    public static List<WebElement> getDropDownOptions(WebElement webElement) {
        Select select = new Select(webElement);
        return select.getOptions();
    }

    public static WebElement getDropDownOption(WebElement webElement, String value) {
        WebElement option = null;
        List<WebElement> options = getDropDownOptions(webElement);
        for (WebElement element : options) {
            if (element.getAttribute("value").equalsIgnoreCase(value)) {
                option = element;
                break;
            }
        }
        return option;
    }

    public static void halt() {
        if (HALT_FOR_DEMO) {
            LOGGER.info(String.format("halting for demonstration"));
            try {
                Thread.sleep(HALT_INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        LOGGER.info(String.format("halting complete"));
    }

}
