package com.evy.driver;

import com.evy.config.ConfigFactory;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public final class Driver {
    private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

    private Driver() {
    }

    public static void initDriver() {
        DRIVER_THREAD_LOCAL.set(DriverFactory.getDriver(ConfigFactory.getConfig().browserType()));
        DRIVER_THREAD_LOCAL.get().manage().window().maximize();
        DRIVER_THREAD_LOCAL.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ConfigFactory.getConfig().pageLoadTime()));
        DRIVER_THREAD_LOCAL.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigFactory.getConfig().implicitTime()));
        DRIVER_THREAD_LOCAL.get().get(ConfigFactory.getConfig().url());
    }

    public static WebDriver getDriver() {
        return DRIVER_THREAD_LOCAL.get();
    }

    public static void quitDriver() {
        DRIVER_THREAD_LOCAL.get().quit();
        DRIVER_THREAD_LOCAL.remove();
    }

}
