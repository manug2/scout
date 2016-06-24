package com.manug2.scout.glue;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import java.util.logging.Logger;

public class BrowserDriver {
    private static WebDriver mDriver;
    private static final Logger LOGGER = Logger.getLogger(BrowserDriver.class.getName());

    public synchronized static WebDriver getCurrentDriver() {
        if (mDriver==null) {
            try {
                mDriver = DriverFactory.getBrowser();
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
            LOGGER.info("closing the browser");
        } catch (UnreachableBrowserException e) {
            LOGGER.info("cannot close browser: unreachable browser");
        }
    }

    public static void loadPage(String url){
        LOGGER.info("Directing browser to:" + url);
        getCurrentDriver().get(url);
    }

}
