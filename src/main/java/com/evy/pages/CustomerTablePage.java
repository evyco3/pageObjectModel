package com.evy.pages;

import com.evy.config.ConfigFactory;
import com.evy.driver.Driver;
import com.evy.enums.WaitStrategyType;
import com.evy.explicit.ExplicitWaitFactory;
import com.evy.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.evy.utils.SeleniumUtils.*;

public final class CustomerTablePage {

    private final By SEARCH_TEXTBOX = By.id("searching");
    private final By SEARCH_BUTTON = By.cssSelector("input[value='Search']");

    public boolean isCustomerNameExist(String customerName) {
        sendKeys(SEARCH_TEXTBOX, customerName, "customerName");
        click(SEARCH_BUTTON, "searchButton");
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().explicitTime())).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".btn.btn-outline-info")));
        int rows = getSize(By.xpath("//table/tbody//tr"), "Rows");
        int cols = getSize(By.xpath("//table/tbody//tr[1]//th"), "cols");
        for (int i = 2; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                String txt = getText(By.xpath("//table//tbody//tr[" + i + "]//td[" + j + "]"), "a");
                if (txt.equalsIgnoreCase(customerName)) {
                    return true;
                }
            }
        }
        return false;

    }

}
