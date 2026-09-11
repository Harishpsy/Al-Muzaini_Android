package pages;

import base.BasePage;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class LoginPage extends BasePage {


    public LoginPage() {
        super();
    }

    private final By allowNotification = By.id("com.android.permissioncontroller:id/permission_allow_button");
    private final By usernameField = By.xpath("//android.widget.EditText[@text=\"Username\"]");
    private final By passwordField = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Password\")");
    private final By passwordFieldExistingUser = By.className("android.widget.EditText");
    private final By loginButton = By.xpath("//android.view.ViewGroup[@content-desc=\"Login\"]");
    private final By GoogleNoThanks = By.id("android:id/autofill_dialog_no");
    private final By GoogleDialog = By.xpath("//android.widget.LinearLayout[@resource-id=\"android:id/autofill_dialog_picker\"]");
    private final By DeviceActivation = By.xpath("//android.widget.TextView[@text=\"Device Activation\"]");
    private final By ClickingOkInDeviceActivationPopup = new AppiumBy.ByAccessibilityId("OK");

    public void login(String username, String password) throws InterruptedException {
//        // Adding a small delay to ensure app is loaded
        try {
            System.out.println("Waiting 2 seconds for application to stabilize...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (isUsernameFieldVisible()) {
            // Username field is visible - enter both username and password
//            Notfication();
            enterUsername(username);
            enterPassword(password);
            clickLoginButton();
            deviceActivation();
            System.out.println("Login with username and password");
        } else {
            // Username field is not visible - enter only password
            enterPassword(password);
            clickLoginButton();
            deviceActivation();
            System.out.println("Login with password only (username field not present)");
        }

        //OTP Verification page
        OTPVerififcationPage otpVerififcationPage = new OTPVerififcationPage();
        otpVerififcationPage.OtpVerificationPageCommonActions();

        // After login, navigate to Dashboard and handle biometric popup
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.handleBiometricPopup();

        // Guide tour
//        dashboardPage.GuideTour();
    }

    public void handleNotification(){
        try{

        WebElement AllowNotification = wait.until(ExpectedConditions.visibilityOfElementLocated(allowNotification));
        AllowNotification.click();

        }
        catch (Exception e) {
            System.out.println("Notification permission button not found or already handled: " + e.getMessage());
        }
    }

    private boolean isUsernameFieldVisible() {
        try {
            WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
            return usernameElement.isDisplayed();
        } catch (Exception e) {
            System.out.println("Username field not found or not visible - Screen might have changed or app is slow.");
            return false;
        }
    }

    private void enterUsername(String username) {
        if (username != null && !username.trim().isEmpty()) {
            WebElement enteringUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
            enteringUsername.click();
            enteringUsername.sendKeys(username);
            System.out.println("Username entered: " + username);
        }
    }

    private void enterPassword(String password) throws InterruptedException {
        System.out.println("Entering password...");

        if (password != null && !password.trim().isEmpty()) {
            try {
                // Try regular password field first
                clickWithWait(passwordField);
                GoogleDialog();
                sendKeys(passwordField,password);
                System.out.println("Password entered for new user");
            } catch (Exception e) {
                System.out.println("Regular password field not found, trying existing user field...");

                // Try existing user password field
                clickWithWait(passwordFieldExistingUser);
                GoogleDialog();
                sendKeys(passwordFieldExistingUser, password);
                System.out.println("Password entered for existing user");
            }
        }
    }

    private void clickLoginButton() {
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginBtn.click();
        System.out.println("Login button clicked");
    }

    // Biometric popup is now handled by DashboardPage#handleBiometricPopup()
    public void verifyLoginSuccess() {
        // This is a placeholder for actual verification logic
        // For now, we'll just log that verification is requested
        System.out.println("Verification of login success requested.");
        // Example: wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dashboard_view")));
    }

    protected void deviceActivation() throws InterruptedException {
        Thread.sleep(5000);
        try {

            if (driver.findElement(DeviceActivation).isDisplayed()) {
                System.out.println("Device activation popup was displayed.");
                clickWithWait(ClickingOkInDeviceActivationPopup);
            }

        }catch (Exception e) {
            System.out.println("Device activation popup was not displayed.");
        }
    }

    protected void GoogleNoThanksButton(){
        click(GoogleNoThanks);
    }

    protected void GoogleDialog() {

        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            WebElement dialog = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(GoogleDialog));

            if (dialog.isDisplayed()) {

                GoogleNoThanksButton();
            }

        } catch (TimeoutException e) {

            System.out.println("Google Password Dialog was not found");
        }
    }
}
