package pages.BillPay;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PayLocalBillsEnet extends BasePage {

    private final By payLocalBillsDisplay = By.xpath("//android.widget.TextView[@text='Pay Local Bills']");
    private final By showMoreButton = By.xpath("(//android.view.ViewGroup[@content-desc='Show More'])[1]");
    private final By showLessButton = new AppiumBy.ByAccessibilityId("Show Less");
    private final By telecom = new AppiumBy.ByAccessibilityId("Telecom");
    private final By ooredoo = new AppiumBy.ByAccessibilityId("Ooredoo");
    private final By billPayment = new AppiumBy.ByAccessibilityId("Bill Payment");
    private final By mobileNumber = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Enter Mobile Number\")");
    private final By amount = new AppiumBy.ByAccessibilityId("Amount*");
    private final By EnterAmount = By.xpath("//android.widget.EditText[@text=\"Enter Amount\"]");
    private final By checkbox = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]"); // better locator if possible
    private final By proceedButton = new AppiumBy.ByAccessibilityId("Proceed");

    // Main Flow
    public void eNetActions() throws InterruptedException {
        verifyEnetModuleDisplaying();
    }

    // Validation
    protected void verifyEnetModuleDisplaying() throws InterruptedException {
        try {
            System.out.println("Enet Module Displayed");
            WebElement eNet = driver.findElement(payLocalBillsDisplay);
            if (eNet.isDisplayed()) {
                Thread.sleep(40000);
//                clickShowMore();
//                clickShowLess();
                clickTelecom();
                clickOoredoo();
                clickBillPayment();
                enterMobileNumber("66000021");
                clickingAmountfield();
                enterAmount("10");
                clickCheckbox();
                clickProceed();
                Thread.sleep(5000);
                NavigateBack();
                NavigateBack();
                NavigateBack();
            }
        } catch (Exception e) {
            System.out.println("Failed To Run Enet Module error: " + e.getMessage());
            throw e;
        }
    }

    protected void clickShowMore() {
        clickWithWait(showMoreButton);
        System.out.println("Show more button clicked");

    }

    protected void clickShowLess() {
        clickWithWait(showLessButton);
        System.out.println("Show less button clicked");
    }

    protected void clickTelecom() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(telecom));
        clickWithWait(telecom);
        System.out.println("Telecom clicked");
    }

    protected void clickOoredoo() {
        clickWithWait(ooredoo);
        System.out.println("Ooredoo clicked");
    }

    protected void clickBillPayment() {
        clickWithWait(billPayment);
        System.out.println("Bill payment clicked");
    }

    protected void enterMobileNumber(String number) {
        clickWithWait(mobileNumber);
        System.out.println("Enter Mobile Number: " + number);
        sendKeys(mobileNumber, number);
        System.out.println("Enter Mobile Number: " + number);
    }

    protected void clickingAmountfield() {
        clickWithWait(amount);
        System.out.println("Clicked Amount Field");
    }

    protected void enterAmount(String value) {
        sendKeys(EnterAmount, value);
        System.out.println("Enter Amount: " + value);
    }

    protected void clickCheckbox() {
        clickWithWait(checkbox);
        System.out.println("Checkbox clicked");
    }

    protected void clickProceed() {
        clickWithWait(proceedButton);
        System.out.println("Proceed clicked");
    }



}