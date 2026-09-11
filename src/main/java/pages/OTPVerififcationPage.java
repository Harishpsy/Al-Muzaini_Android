package pages;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class OTPVerififcationPage extends BasePage {

    private final By VerifyingOTPPage = By.xpath("//android.widget.TextView[@text=\"OTP Verification\"]");
    private final By OTPTextEnteringField = new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.widget.EditText\")");
    private final By VerifyButton = new AppiumBy.ByAccessibilityId("Verify");


    public void OtpVerificationPageCommonActions() throws InterruptedException {
        VerifyingOTPPage();
    }

    protected void VerifyingOTPPage() throws InterruptedException {
        Thread.sleep(5000);
        try {
            if (driver.findElement(VerifyingOTPPage).isDisplayed()) {
                hideKeyboard();
                sendKeys(OTPTextEnteringField, "1234");
                System.out.println("OTP Page was Displayed");
                ClickingVerifyButton();
            }
        } catch (Exception e) {
            System.out.println("OTP Page was Not Displaying");
        }
    }

    protected void ClickingVerifyButton(){
        clickWithWait(VerifyButton);
        System.out.println("Successfully clicked Verify Button");
    }
















}
