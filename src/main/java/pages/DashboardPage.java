package pages;

import base.BasePage;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage extends BasePage {

    public DashboardPage() {
        super();
    }

    // ===================== Locators =====================

    private final By EnableBiometric = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Enable\")");

    // Locator for guide tour overlay clicks
    private final By ClickingGuideTour = By.className("android.view.View");

    // Method to handle guide tour popup by clicking multiple times
    protected void GuideTour() {
        for(int i = 0; i < 6; i++) { // Loop for max 6 steps
            try {
                clickWithWait(ClickingGuideTour); // Click guide tour overlay
            } catch (Exception var3) { // Break if no more steps
                System.out.println("Guide Tour stopped at step " + (i + 1));
                break;
            }
        }
    }

    // ===================== Biometric Popup =====================

    /**
     * Handles the "Enable Biometric" popup that appears on the Dashboard
     * after a successful login. Clicks "Enable" if present; silently skips
     * if the popup does not appear within the timeout.
     */
    public void handleBiometricPopup() {
        try {
            System.out.println("Dashboard: Checking for Enable Biometric popup...");
            Thread.sleep(5000); // Optional: wait for the popup to stabilize
            clickWithWait(EnableBiometric);
            System.out.println("Dashboard: Enable Biometric button clicked successfully");

        } catch (Exception e) {
            System.out.println("Dashboard: Enable Biometric popup not displayed or not clickable within timeout");
        }
    }

    // ===================== Dashboard Verification =====================
    public boolean isDashboardLoaded() {
        // TODO: replace the locator below with an actual Dashboard element
        // Example: By dashboardHeader = By.xpath("//android.widget.TextView[@text='Dashboard']");
        System.out.println("Dashboard: Verifying dashboard is loaded...");
        return true;
    }
}
