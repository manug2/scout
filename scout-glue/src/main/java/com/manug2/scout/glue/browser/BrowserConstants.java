package com.manug2.scout.glue.browser;


public class BrowserConstants {
    public static final String APP_URL = System.getProperty("APP_URL", "http://localhost:8181/");
    public static final BrowserType BROWSER = BrowserType.valueOf(
            System.getProperty("browser", BrowserType.CHROME.toString()).toUpperCase());

    public static final String PROP_CHROME_DRIVER_PATH = "webdriver.chrome.driver";
    public static final String CHROME_DRIVER_PATH =
            "target/test-classes/lib/chromedriver.exe";
    public static final String CHROME_BINARY_PATH =
            System.getProperty("chrome.binary.path",
                    "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");

    public static boolean HALT_FOR_DEMO = Boolean.parseBoolean(
            System.getProperty("halt", "false"));

    public static int HALT_INTERVAL = Integer.parseInt(
            System.getProperty("halt.duration", "4000"));
}
