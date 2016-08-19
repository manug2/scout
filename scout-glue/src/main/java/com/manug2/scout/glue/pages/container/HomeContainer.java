package com.manug2.scout.glue.pages.container;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomeContainer {

    @FindBy(how = How.ID, using = "homePageTitle")
    public WebElement homePageTitle;

}
