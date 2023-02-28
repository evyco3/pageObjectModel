package com.evy.pages;

import com.evy.utils.SeleniumUtils;
import org.openqa.selenium.By;

import static com.evy.utils.SeleniumUtils.click;
import static com.evy.utils.SeleniumUtils.sendKeys;

public final class CreateNewCustomerPage {

    private final By NAME_TEXTBOX = By.id("Name");
    private final By COMPANY_TEXTBOX = By.id("Company");
    private final By ADDRESS_TEXTBOX = By.id("Address");
    private final By CITY_TEXTBOX = By.id("City");
    private final By PHONE_TEXTBOX = By.id("Phone");
    private final By EMAIL_TEXTBOX = By.id("Email");
    private final By CREATE_BUTTON = By.cssSelector("input[value='Create']");

    public CreateNewCustomerPage setName(String name) {
        sendKeys(NAME_TEXTBOX, name, "name");
        return this;
    }

    public CreateNewCustomerPage setCompany(String company) {
        sendKeys(COMPANY_TEXTBOX, company, "company");
        return this;
    }

    public CreateNewCustomerPage setAddress(String address) {
        sendKeys(ADDRESS_TEXTBOX, address, "address");
        return this;
    }

    public CreateNewCustomerPage setCity(String city) {
        sendKeys(CITY_TEXTBOX, city, "city");
        return this;
    }

    public CreateNewCustomerPage setPhone(String phone) {
        sendKeys(PHONE_TEXTBOX, phone, "phone");
        return this;
    }

    public CreateNewCustomerPage setEmail(String email) {
        sendKeys(EMAIL_TEXTBOX, email, "email");
        return this;
    }

    public DashBoardPage clickCreate() {
        click(CREATE_BUTTON, "create customer button");
        return new DashBoardPage();
    }


}
