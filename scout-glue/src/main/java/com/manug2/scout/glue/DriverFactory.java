package com.manug2.scout.glue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static com.manug2.scout.glue.BrowserConstants.BROWSER_TYPE;


public class DriverFactory {


    public static WebDriver getBrowser(BROWSER_TYPE browserTYPEType) {
        switch (browserTYPEType) {
            case UNIT : return new HtmlUnitDriver();
            default: return getChromeDriver();
        }
    }

    private static WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "target/test-classes/lib/chromedriver.exe");
        ChromeOptions co = new ChromeOptions();
        co.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        ChromeDriver cd = new ChromeDriver(co);
        return cd;
    }

}
