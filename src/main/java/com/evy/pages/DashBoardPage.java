package com.evy.pages;

import com.evy.utils.SeleniumUtils;
import org.openqa.selenium.By;

import static com.evy.utils.SeleniumUtils.click;
import static com.evy.utils.SeleniumUtils.getText;

public final class DashBoardPage {
    private CustomerTablePage customerTablePage;


    public DashBoardPage() {
        customerTablePage = new CustomerTablePage();
    }

    private final By USERNAME_TEXT = By.cssSelector("h1+h3");
    private final By CREATE_NEW_CUSTOMER_BUTTON = By.cssSelector("a.btn-primary");


    public String getUserNameWelcomeMessage() {
        return getText(USERNAME_TEXT, "Welcome userName message");
    }

    public CreateNewCustomerPage clickOnCreateNewCustomer() {
        click(CREATE_NEW_CUSTOMER_BUTTON, "Create new customer button");
        return new CreateNewCustomerPage();
    }

    public CustomerTablePage getCustomerTablePage() {
        return customerTablePage;
    }
}
