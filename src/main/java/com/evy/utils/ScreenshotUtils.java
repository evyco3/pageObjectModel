package com.evy.utils;

import com.evy.driver.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ScreenshotUtils {
    private ScreenshotUtils() {
    }

    public static String get64BaseImg() {
        return ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
