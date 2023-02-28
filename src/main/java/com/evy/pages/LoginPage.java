package com.evy.pages;

import com.evy.utils.SeleniumUtils;
import org.openqa.selenium.By;

import static com.evy.utils.SeleniumUtils.click;
import static com.evy.utils.SeleniumUtils.sendKeys;

public class LoginPage {

    private final By USERNAME_TEXTBOX = By.id("Username");
    private final By PASSWORD_TEXTBOX = By.id("Password");
    private final By LOGIN_BUTTON = By.name("login");

    private LoginPage setUserName(String userName) {
        sendKeys(USERNAME_TEXTBOX, userName, "userName");
        return this;
    }

    private LoginPage setPassword(String password) {
        sendKeys(PASSWORD_TEXTBOX, password, "password");
        return this;
    }

    private LoginPage clickLoginButton() {
        click(LOGIN_BUTTON, "loginButton");
        return this;
    }

    public DashBoardPage loginToApplication(String userName, String password) {
        setUserName(userName);
        setPassword(password);
        clickLoginButton();
        return new DashBoardPage();
    }
}
