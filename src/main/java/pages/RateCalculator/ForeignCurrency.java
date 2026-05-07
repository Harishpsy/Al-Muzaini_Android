package pages.RateCalculator;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForeignCurrency extends BasePage {

    private final By ForeignCurrency = new AppiumBy.ByAccessibilityId("Foreign Currency");
    private final By FCAmount = By.xpath("(//android.widget.EditText[contains(@text, \"\")])[1]");
    private final By LCAmount = By.xpath("(//android.widget.EditText[contains(@text, \"\")])[2]");
    private final By SelectingCurrency = By.xpath("//android.view.ViewGroup[@content-desc=\"BHD - BAHRAINI DINAR\"]");
    private final By ChangeCurrency = By.xpath("(//android.view.ViewGroup[contains(@content-desc, \",\")])[1]");
    private final By ClickingClose = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup");
    private final By ClickingSearchField = By.xpath("//android.widget.EditText[contains(@text, \"\")]");
    private final By BankTransfer = new AppiumBy.ByAccessibilityId("Bank Transfer");
    private final By ConfirmationPopup = By.xpath("//android.widget.TextView[@text=\"Confirmation\"]");
    private final By OkButton =new AppiumBy.ByAccessibilityId("OK");
    private final By CancelButton =new AppiumBy.ByAccessibilityId("Cancel");


    public void ForeignCurrencyActions() throws InterruptedException {
        TappingForeignCurrencyTab();
        ClickingFcCurrency();
        clear(FCAmount);
        System.out.println("Successfully cleared the FC Currency");
        ClickingLCTextField();
        ClickingTheCurrency();
        CloseIcon();
        ClickingTheCurrency();
        ClickingSeacrhField();
        KeyboardOkButton();
        scrollToEnd();
        scrollToTop();
        ClickingBharain();
        ClickingBankTransfer();
        Thread.sleep(5000);
        NavigateBack();
        TappingForeignCurrencyTab();
        ClickingFcCurrency();
        KeyboardOkButton();
        Thread.sleep(5000);
        ClickingBankTransfer();
        confirmationPopup();
        ConfirmationPopupInFxBooking();

    }

    protected void TappingForeignCurrencyTab(){
        clickWithWait(ForeignCurrency);
    }

    protected void ClickingFcCurrency(){
        clickWithWait(FCAmount);
        System.out.println("Successfully clicked the FC Currency");
        sendKeys(FCAmount, "100");
    }

    protected void ClickingLCTextField(){
        clickWithWait(LCAmount);
        System.out.println("Successfully clicked the LC Currency");
        sendKeys(LCAmount, "1000");
        wait.until(ExpectedConditions.visibilityOfElementLocated(LCAmount));
        clear(LCAmount);
        System.out.println("Successfully cleared the LC Currency");
    }

    protected void ClickingTheCurrency(){
        click(ChangeCurrency);
        System.out.println("Successfully clicked the Change Currency");
    }

    protected void CloseIcon(){
        clickWithWait(ClickingClose);
        System.out.println("Successfully clicked the Close Icon");

    }

    protected void ClickingSeacrhField() {
        clickWithWait(ClickingSearchField);
        sendKeys(ClickingSearchField, "BAH");
        clear(ClickingSearchField);
    }
    protected void ClickingBharain() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SelectingCurrency));
        clickWithWait(SelectingCurrency);
        System.out.println("Successfully clicked the Bharain Currency");
    }

    protected void ClickingBankTransfer(){
        clickWithWait(BankTransfer);
        System.out.println("Successfully clicked the Bank Transfer");
    }

    protected void confirmationPopup() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmationPopup));

        if (driver.findElements(ConfirmationPopup).size() > 0) {

            System.out.println("First popup displayed");

            CancelButton();

            Thread.sleep(5000);
            NavigateBack();

            ClickingFcCurrency();
            KeyboardOkButton();
            Thread.sleep(5000);
            ClickingBankTransfer();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            if (wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmationPopup)).isDisplayed()) {

                System.out.println("Second popup displayed");

                OKButton();
            }
        } else {
            System.out.println("Confirmation Popup was Not Displayed");
        }
    }

    protected void OKButton(){
        clickWithWait(OkButton);
        System.out.println("Successfully clicked the OK Button");
    }

    protected void CancelButton(){
        clickWithWait(CancelButton);
        System.out.println("Successfully clicked the Cancel Button");
    }

    protected void ConfirmationPopupInFxBooking() throws InterruptedException {
        if (driver.findElements(ConfirmationPopup).size() > 0) {
            System.out.println("Confirmation popup displayed in the Fx Booking");
            CancelButton();
            NavigateBack();
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmationPopup)).isDisplayed()) {
                System.out.println("Second popup displayed");
                OKButton();
            }
        } else {
            System.out.println("Confirmation Popup was Not Displayed In FX Booking");
        }
    }













}
