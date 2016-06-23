package com.manug2.scout.glue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BrowserFactory {

    public static WebDriver getBrowser() {
        System.setProperty("webdriver.chrome.driver", "target/test-classes/lib/chromedriver.exe");
        ChromeOptions co = new ChromeOptions();
        co.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        ChromeDriver cd = new ChromeDriver(co);
        return cd;
    }
}
