package com.manug2.scout.glue.browser;


public class BrowserConstants {
    public static final String APP_URL = System.getProperty("APP_URL", "http://localhost:8181/");
    public static final BROWSER_TYPE BROWSER = BROWSER_TYPE.valueOf(
            System.getProperty("browser", BROWSER_TYPE.CHROME.toString()).toUpperCase());

    public static final String PROP_CHROME_DRIVER_PATH = "webdriver.chrome.driver";
    public static final String CHROME_DRIVER_PATH =
            "target/test-classes/lib/chromedriver.exe";
    public static final String CHROME_BINARY_PATH =
            System.getProperty("chrome.binary.path",
                    "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");

    enum BROWSER_TYPE {
        CHROME,
        UNIT
    }

}
