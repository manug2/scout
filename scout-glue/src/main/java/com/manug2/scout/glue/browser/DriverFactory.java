package com.manug2.scout.glue.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static com.manug2.scout.glue.browser.BrowserConstants.*;


public class DriverFactory {


    public static WebDriver getBrowser(BROWSER_TYPE browserTYPEType) {
        switch (browserTYPEType) {
            case UNIT : return new HtmlUnitDriver();
            default: return getChromeDriver();
        }
    }

    private static WebDriver getChromeDriver() {
        System.setProperty(PROP_CHROME_DRIVER_PATH, CHROME_DRIVER_PATH);
        ChromeOptions co = new ChromeOptions();
        co.setBinary(CHROME_BINARY_PATH);
        ChromeDriver cd = new ChromeDriver(co);
        return cd;
    }

}
