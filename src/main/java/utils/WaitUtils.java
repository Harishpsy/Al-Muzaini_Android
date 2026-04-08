package utils;

import base.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private static final Duration TIMEOUT = Duration.ofSeconds(20);

    private WaitUtils() {}

    public static void waitForElementToBeVisible(WebElement element) {
        new WebDriverWait(DriverFactory.getDriver(), TIMEOUT)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementToBeClickable(WebElement element) {
        new WebDriverWait(DriverFactory.getDriver(), TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForInvisibilityOf(WebElement element) {
        new WebDriverWait(DriverFactory.getDriver(), TIMEOUT)
                .until(ExpectedConditions.invisibilityOf(element));
    }
}
