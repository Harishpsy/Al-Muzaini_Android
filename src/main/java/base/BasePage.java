package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtils;

import org.openqa.selenium.StaleElementReferenceException;

import java.time.Duration;
import java.util.Map;

import static base.DriverFactory.getDriver;

public abstract class BasePage {

    protected AppiumDriver driver;
    protected WebDriverWait wait;
    protected String APP_PACKAGE = "com.almuzaini.almuzaini";

    protected BasePage() {
        this.driver = getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /* ===================== CLICK ===================== */

    protected void click(WebElement element, String elementName) {
        WaitUtils.waitForElementToBeClickable(element);
        element.click();
        System.out.println("Clicked on: " + elementName);
    }

    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void clickWithWait(By locator) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
                return;
            } catch (StaleElementReferenceException e) {
                System.out.println("Stale element encountered for locator: " + locator + ". Retrying... Attempts: " + (attempts + 1));
            }
            attempts++;
        }
        // Final attempt
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    /* ===================== SEND KEYS ===================== */

    protected void type(WebElement element, String text, String elementName) {
        WaitUtils.waitForElementToBeVisible(element);
        element.clear();
        element.sendKeys(text);
        System.out.println("Typed '" + text + "' in: " + elementName);
    }

    protected void sendKeys(By locator, String text) {
        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    /* ===================== GET TEXT ===================== */

    protected String getText(WebElement element) {
        WaitUtils.waitForElementToBeVisible(element);
        return element.getText();
    }

    /* ===================== MOBILE HELPERS ===================== */

    protected void hideKeyboard() {
        try {
            if (driver instanceof HidesKeyboard) {
                ((HidesKeyboard) driver).hideKeyboard();
            }
        } catch (Exception ignored) {
        }
    }

/*   Navigate Back To Application */

    protected void NavigateBackToApp() {

        AndroidDriver driver = (AndroidDriver) getDriver();

        // wait until current package is NOT your app (means external opened)
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(d -> !driver.getCurrentPackage().equals(APP_PACKAGE));

        driver.activateApp(APP_PACKAGE);
    }

    protected void scrollToTop(){
        driver.executeScript("mobile: scroll", Map.of("direction", "up"));
    }

    protected void scrollToEnd() {
        driver.executeScript("mobile: scroll", Map.of("direction", "down"));
    }
}
