package com.evy.driver;

import com.evy.driver.local.ChromeDriverManager;
import com.evy.driver.local.EdgeDriverManager;
import com.evy.driver.local.FireFoxDriverManager;
import com.evy.enums.BrowserType;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.function.Supplier;

public final class DriverFactory {
    private DriverFactory() {
    }

    private static final EnumMap<BrowserType, Supplier<WebDriver>> MAP = new EnumMap<>(BrowserType.class);

    static {
        MAP.put(BrowserType.CHROME, new ChromeDriverManager()::getDriver);
        MAP.put(BrowserType.FIREFOX, new FireFoxDriverManager()::getDriver);
        MAP.put(BrowserType.EDGE, new EdgeDriverManager()::getDriver);
    }

    public static WebDriver getDriver(BrowserType browserType) {
        return MAP.get(browserType).get();
    }


}
