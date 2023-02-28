package com.evy.explicit;

import com.evy.config.ConfigFactory;
import com.evy.driver.Driver;
import com.evy.enums.WaitStrategyType;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.EnumMap;
import java.util.function.Function;

public final class ExplicitWaitFactory {
    private ExplicitWaitFactory() {
    }

    private static final EnumMap<WaitStrategyType, Function<By, ExpectedCondition<WebElement>>> WAIT_STRATEGY_MAP = new EnumMap<>(WaitStrategyType.class);

    static {
        WAIT_STRATEGY_MAP.put(WaitStrategyType.CLICKABLE, ExpectedConditions::elementToBeClickable);
        WAIT_STRATEGY_MAP.put(WaitStrategyType.PRESENCE, ExpectedConditions::presenceOfElementLocated);
        WAIT_STRATEGY_MAP.put(WaitStrategyType.VISIBLE, ExpectedConditions::visibilityOfElementLocated);
    }

    public static WebElement performExplicit(By by, WaitStrategyType waitStrategy) {
        Function<By, ExpectedCondition<WebElement>> expectedCondition = WAIT_STRATEGY_MAP.get(waitStrategy);
        if (expectedCondition == null) {
            expectedCondition = ExpectedConditions::presenceOfElementLocated;
        }
        return getWait().until(expectedCondition.apply(by));
    }

    private static WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().explicitTime()));
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(NoSuchElementException.class);
        return wait;
    }

}
