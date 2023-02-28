package com.evy.pages;

import org.openqa.selenium.By;

import static com.evy.utils.SeleniumUtils.*;

public class SignupPage {

    private final By FIRSTNAME_TEXTBOX = By.id("FirstName");
    private final By SURENAME_TEXTBOX = By.id("Surname");
    private final By EMAIL_TEXTBOX = By.id("E_post");
    private final By MOBILE_TEXTBOX = By.id("Mobile");
    private final By USERNAME_TEXTBOX = By.id("Username");
    private final By PASSWORD_TEXTBOX = By.id("Password");
    private final By CONFIRM_PASSWORD_TEXTBOX = By.id("ConfirmPassword");
    private final By SUBMIT_BUTTON = By.id("submit");
    private final By SERVER_RESPONSE_MESSAGE_TEXT = By.cssSelector(".label-success");


    public SignupPage setFirstName(String firstName) {
        sendKeys(FIRSTNAME_TEXTBOX, firstName, "firstName");
        return this;
    }

    public SignupPage setSureName(String sureName) {
        sendKeys(SURENAME_TEXTBOX, sureName, "sureName");
        return this;
    }

    public SignupPage setEmail(String email) {
        sendKeys(EMAIL_TEXTBOX, email, "email");
        return this;
    }

    public SignupPage setMobile(String mobile) {
        sendKeys(MOBILE_TEXTBOX, mobile, "mobile");
        return this;
    }

    public SignupPage setUserName(String userName) {
        sendKeys(USERNAME_TEXTBOX, userName, "userName");
        return this;
    }

    public SignupPage setPassword(String password) {
        sendKeys(PASSWORD_TEXTBOX, password, "password");
        return this;
    }

    public SignupPage setConfirmPassword(String confirmPassword) {
        sendKeys(CONFIRM_PASSWORD_TEXTBOX, confirmPassword, "confirmPassword");
        return this;
    }

    public SignupPage clickSubmit() {
        click(SUBMIT_BUTTON, "submitButton");
        return this;
    }

    public String getServerResponseMessage() {
        return getText(SERVER_RESPONSE_MESSAGE_TEXT, "Server Response Message");
    }


}
