package pages.TransferMoney.Beneficiaries.BankTransfer;

import base.BasePage;
import io.appium.java_client.AppiumBy;

import org.openqa.selenium.By;

public class KnetPaymentGateway extends BasePage {

    private final By SelectYourBankName = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Select Your Bank\")");
    private final By ClickingTheBankNameInPopup = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Knet Test Card [KNET1]\")");
    private final By CardNumber = By.xpath("//android.view.View[@resource-id=\"Paymentpagecardnumber\"]/android.view.View[3]");
    private final By EnteringCardNumber = By.xpath("//android.widget.EditText[@resource-id=\"debitNumber\"]");
    private final By ExpireDateMonth = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"MM\")");
    private final By ClickingTheMonthInPopup = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"09\")");
    private final By ExpireDateYear = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"YYYY\")");
    private final By ClickingTheYearInPopup = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"2030\")");
    private final By Pin = By.xpath("//android.view.View[@resource-id=\"PinRow\"]/android.view.View[2]");
    private final By EnteringPin = By.xpath("//android.widget.EditText[@resource-id=\"cardPin\"]");
    private final By Submit = new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"proceed\")");
    private final By Confirm = new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"proceedConfirm\")");

    public KnetPaymentGateway() {
        super();
    }

    public void KnetActions() throws InterruptedException {
        ClickingSelectYourBankAccount();
        SelectingBankNameInTheModal();
        ClickingCardNumberFiled();
        ClickingTheMonthTextField();
        SelectingTheMonthInModal();
        ClickingTheYearTextField();
        SelectingTheYearInModal();
        ClickingAndEnteringCardPin();
        ClickingSubmitButton();
        ClickingTheConfirmButton();
    }

    protected void ClickingSelectYourBankAccount() {
        clickWithWait(SelectYourBankName);
    }

    protected void SelectingBankNameInTheModal() {
        clickWithWait(ClickingTheBankNameInPopup);
    }

    protected void ClickingCardNumberFiled() throws InterruptedException {
        Thread.sleep(1000);
        clickWithWait(CardNumber);
        Thread.sleep(2000);
        sendKeys(EnteringCardNumber, "1000000001");
    }

    protected void ClickingTheMonthTextField() {
        clickWithWait(ExpireDateMonth);
    }

    protected void SelectingTheMonthInModal() {
        clickWithWait(ClickingTheMonthInPopup);
    }

    protected void ClickingTheYearTextField() {
        clickWithWait(ExpireDateYear);
    }

    protected void SelectingTheYearInModal() {
        clickWithWait(ClickingTheYearInPopup);
    }

    protected void ClickingAndEnteringCardPin() {
        clickWithWait(Pin);
        sendKeys(EnteringPin, "0000");
    }

    protected void ClickingSubmitButton() {

        clickWithWait(Submit );
    }

    protected void ClickingTheConfirmButton() {
        clickWithWait(Confirm);
    }
}


