package com.manug2.scout.glue;


public class BrowserConstants {
    public static final String APP_URL = System.getProperty("APP_URL", "http://localhost:8181/");
    public static final BROWSER_TYPE BROWSER =
            BROWSER_TYPE.valueOf(System.getProperty("BROWSER_TYPE", BROWSER_TYPE.CHROME.toString()));


    enum BROWSER_TYPE {
        CHROME,
        UNIT
    }

}
