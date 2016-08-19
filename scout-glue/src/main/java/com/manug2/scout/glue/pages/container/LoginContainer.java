package com.manug2.scout.glue.pages.container;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginContainer {

    @FindBy(how = How.ID, using = "LoginPage")
    public WebElement loginPageDiv;

    @FindBy(how = How.ID, using = "username")
    public WebElement usernameInput;

    @FindBy(how = How.ID, using = "password")
    public WebElement passwordInput;

    @FindBy(how = How.ID, using = "SubmitLogin")
    public WebElement submitButton;

    @FindBy(how = How.ID, using = "badLogin")
    public WebElement badLogin;

    @FindBy(how = How.ID, using = "Reset")
    public WebElement resetButton;

}
