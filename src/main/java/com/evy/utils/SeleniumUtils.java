package com.evy.utils;

import com.evy.config.ConfigFactory;
import com.evy.driver.Driver;
import com.evy.enums.LogType;
import com.evy.enums.WaitStrategyType;
import com.evy.explicit.ExplicitWaitFactory;
import com.evy.report.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public final class SeleniumUtils {
    private SeleniumUtils() {
    }


    public static void sendKeys(By by, String value, String fieldName) {
        ExtentLogger.log(LogType.INFO, "Sending keys to " + fieldName + ":" + value);
        ExplicitWaitFactory.performExplicit(by, WaitStrategyType.PRESENCE).sendKeys(value);
    }

    public static void click(By by, String fieldName) {
        ExtentLogger.log(LogType.INFO, "Clicking on " + fieldName);
        ExplicitWaitFactory.performExplicit(by, WaitStrategyType.CLICKABLE).click();
    }

    public static String getText(By by, String fieldName) {
        String value = ExplicitWaitFactory.performExplicit(by, WaitStrategyType.VISIBLE).getText();
        ExtentLogger.log(LogType.INFO, "Getting Text from " + fieldName + ":" + value);
        return value;
    }

    public static boolean isDisplayed(By by, String fieldName) {
        try {
            WebElement element = ExplicitWaitFactory.performExplicit(by, WaitStrategyType.VISIBLE);
            element.isDisplayed();
            ExtentLogger.log(LogType.INFO, fieldName + " Is Displayed");
            return true;
        } catch (Exception e) {
            ExtentLogger.log(LogType.FAIL, fieldName + "Is Not Displayed");
            return false;
        }
    }

    public static int getSize(By by, String fieldName) {
        int size = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().explicitTime()))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by)).size();
        ExtentLogger.log(LogType.INFO, "Getting  " + fieldName + " size: " + size);
        return size;
    }
}