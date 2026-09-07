package pages.TransferMoney.Beneficiaries.BankTransfer;

import base.BasePage;
import io.appium.java_client.AppiumBy;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KnetPaymentGateway extends BasePage {

    private final By SelectYourBankName = By.xpath("//android.widget.EditText[@resource-id=\"debitNumber\"]");
    private final By ClickingTheBankNameInPopup = By.xpath("//android.widget.ListView[@resource-id=\"cardSuggestions\"]/android.view.View");
//    private final By CardNumber = By.xpath("//android.view.View[@resource-id=\"Paymentpagecardnumber\"]/android.view.View[3]");
//    private final By EnteringCardNumber = By.xpath("//android.widget.EditText[@resource-id=\"debitNumber\"]");
    private final By ExpireDateMonth = By.xpath("//android.widget.EditText[@resource-id=\"expiryDateInput\"]");
    private final By ClickingTheMonthInPopup = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"09\")");
    private final By ExpireDateYear = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"YYYY\")");
    private final By ClickingTheYearInPopup = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"2030\")");
    private final By Pin = By.xpath("//android.widget.EditText[@resource-id=\"cardPin\"]");
    private final By EnteringPin = By.xpath("//android.widget.EditText[@resource-id=\"cardPin\"]");
    private final By Submit = new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"proceed\")");
    private final By Confirm = new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"proceedConfirm\")");
private final By ClickingCarknumber = By.xpath("//android.widget.EditText[@text='8888 88']");



    public KnetPaymentGateway() {
        super();
    }

    public void KnetActions() throws InterruptedException {
        java.util.List<Object[]> knetData = utils.ExcelUtils.getTestData("Knet.xlsx");
        if (!knetData.isEmpty()) {
            Object[] row = knetData.get(0);
            KnetActions(row[0].toString(), row[1].toString(), row[2].toString());
        } else {
            throw new RuntimeException("No test data found in Knet.xlsx");
        }
    }

    public void KnetActions(String cardNumber, String expiryDate, String pin) throws InterruptedException {
        ClickingSelectYourBankAccount(cardNumber);
//        SelectingBankNameInTheModal();
//        ClickingCardNumberFiled();
        ClickingTheMonthTextField(expiryDate);
//        SelectingTheMonthInModal();
//        ClickingTheYearTextField();
//        SelectingTheYearInModal();
        ClickingAndEnteringCardPin(pin);
        ClickingSubmitButton();
        ClickingTheConfirmButton();
    }

    protected void ClickingSelectYourBankAccount(String cardNumber) throws InterruptedException {
        Thread.sleep(10000);
        clickWithWait(SelectYourBankName);
        sendKeys(SelectYourBankName, cardNumber);
    }

//    protected void SelectingBankNameInTheModal() throws InterruptedException {
//        clickWithWait(ClickingTheBankNameInPopup);
//        hideKeyboard();
//        clickWithWait(ClickingCarknumber);
//        sendKeys(ClickingCarknumber,"0000000001");
//    }

//    protected void ClickingCardNumberFiled() throws InterruptedException {
//        Thread.sleep(1000);
//        clickWithWait(CardNumber);
//        Thread.sleep(2000);
//        sendKeys(EnteringCardNumber, "1000000001");
//    }

    protected void ClickingTheMonthTextField(String expiryDate) {
        clickWithWait(ExpireDateMonth);
        sendKeys(ExpireDateMonth, expiryDate);
    }

//    protected void SelectingTheMonthInModal() {
//        clickWithWait(ClickingTheMonthInPopup);
//    }

//    protected void ClickingTheYearTextField() {
//        clickWithWait(ExpireDateYear);
//    }

//    protected void SelectingTheYearInModal() {
//        clickWithWait(ClickingTheYearInPopup);
//    }

    protected void ClickingAndEnteringCardPin(String pin) {
        clickWithWait(Pin);
        sendKeys(EnteringPin, pin);
    }

    protected void ClickingSubmitButton() {
        clickWithWait(Submit);
    }

    protected void ClickingTheConfirmButton() {
        clickWithWait(Confirm);
    }
}


