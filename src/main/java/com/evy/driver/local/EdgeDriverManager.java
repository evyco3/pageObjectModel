package com.evy.driver.local;

import com.evy.driver.IDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public final class EdgeDriverManager implements IDriver {
    @Override
    public WebDriver getDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}
