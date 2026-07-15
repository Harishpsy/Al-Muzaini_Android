package pages.RateCalculator;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import java.time.Duration;

public class RateCalculatorTap extends BasePage {

    private final By RateCalculator = new AppiumBy.ByAccessibilityId("Rate Calculator");

    public void RateCalculatorTap() {
        ClickingRateCalculator();
    }

    protected void ClickingRateCalculator(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        clickWithWait(RateCalculator);
    }
}
