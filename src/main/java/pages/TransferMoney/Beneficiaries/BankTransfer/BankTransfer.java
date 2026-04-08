package pages.TransferMoney.Beneficiaries.BankTransfer;

import base.BasePage;
import io.appium.java_client.AppiumBy;

import org.openqa.selenium.By;

public class BankTransfer extends BasePage {

    public BankTransfer(){
        super();
    }
    private final By FIRSTUSERBENEFICIARY = new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(50)");
    private final By DROPDOWNOPEN = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup");
    private final By DROPDOWNCLOSE = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[3]/android.view.ViewGroup");
    private final By YOUSEND = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"0.000\").instance(0)");
    private final By PURPOSEOFTRANSFER = new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(40)");
    private final By PURPOSEOFTRANSFERSEARCH = new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(20)");
    private final By SENDNOWBUTTON = new AppiumBy.ByAndroidUIAutomator("new UiSelector().description(\"Send Now\")");


    public void BankTransferAction(String YouSend, String ReEnterYouSend) throws InterruptedException {
        ClickingFirstUserBeneficiary();
        EnteringYouSendValue(YouSend);
        PurposeOfTransfer();
        SendNow();
        CallingReviewPayment(ReEnterYouSend);
        CallingPaymentGateway();
//        CallingTransactionSummary();
    }

    private void ClickingFirstUserBeneficiary() throws InterruptedException {
          Thread.sleep(30000);
          clickWithWait(FIRSTUSERBENEFICIARY);
    }

    private void ClickingDropDownOpen() {
        click(DROPDOWNOPEN);
    }

    private void ClickingDropDownClose(){
        click(DROPDOWNCLOSE);
    }

    private void EnteringYouSendValue(String YouSend) throws InterruptedException {
        clickWithWait(YOUSEND);
        sendKeys(YOUSEND,YouSend);
    }

    private void PurposeOfTransfer() throws InterruptedException {
        click(PURPOSEOFTRANSFER);
        Thread.sleep(1000);
        clickWithWait(PURPOSEOFTRANSFERSEARCH);
    }

    private void SendNow() throws InterruptedException {
        Thread.sleep(5000);
        click(SENDNOWBUTTON);
    }

    // Review Payment
    private void CallingReviewPayment(String ReEnterYouSend) throws InterruptedException {
        ReviewPayment Reviewpayment = new ReviewPayment();
        Reviewpayment.ReviewPaymentActions(ReEnterYouSend);
    }

    // Knet Payment Gateway
    private void CallingPaymentGateway() throws InterruptedException {
        KnetPaymentGateway PaymentGateway = new KnetPaymentGateway();
        PaymentGateway.KnetActions();
    }

    // Transaction Summary
//    private void CallingTransactionSummary() {
//        TransactionSummary summary = new TransactionSummary();
//        summary.transactionSummary();
//    }







}
