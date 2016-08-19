package com.manug2.scout.glue.assertions;


import org.openqa.selenium.NoSuchElementException;

public class ScoutAssert {
    public static boolean isNSEE(Exception ex) {
        return
                ex.getCause()!=null
                        && NoSuchElementException.class.equals(ex.getCause().getClass());

    }
}
