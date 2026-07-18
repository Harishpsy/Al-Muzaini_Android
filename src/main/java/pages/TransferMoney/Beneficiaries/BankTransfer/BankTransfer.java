package pages.TransferMoney.Beneficiaries.BankTransfer;

import base.BasePage;
import io.appium.java_client.AppiumBy;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BankTransfer extends BasePage {

    public BankTransfer(){
        super();
    }
    private final By FIRSTUSERBENEFICIARY = By.xpath("//android.view.ViewGroup[@content-desc=\"HC, HARISH BANK CARDS, BANQUE DU CAIRE, ****2968, EGP\"]");
    private final By DROPDOWNOPEN = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup");
    private final By DROPDOWNCLOSE = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[3]/android.view.ViewGroup");
    private final By YOUSEND = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"0.000\").instance(0)");
    private final By PURPOSEOFTRANSFER = By.xpath("//android.view.ViewGroup[@content-desc=\"Purpose of Transfer*\"]/android.view.ViewGroup/com.horcrux.svg.SvgView/com.horcrux.svg.B/com.horcrux.svg.J");
    private final By PURPOSEOFTRANSFERSEARCH = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]");
    private final By SENDNOWBUTTON = By.xpath("//android.widget.TextView[@text=\"Send Now\"]");


    public void BankTransferAction(String YouSend, String ReEnterYouSend) throws InterruptedException {
        ClickingFirstUserBeneficiary();
        EnteringYouSendValue(YouSend);
//        PurposeOfTransfer();
        SendNow();
        CallingReviewPayment(ReEnterYouSend);
        CallingPaymentGateway();
        CallingTransactionSummary();
    }

    private void ClickingFirstUserBeneficiary() throws InterruptedException {
          Thread.sleep(20000);
          clickWithWait(FIRSTUSERBENEFICIARY);
          System.out.println("Successfully clicked the First Beneficiary");
    }

    private void ClickingDropDownOpen() {
        click(DROPDOWNOPEN);
    }

    private void ClickingDropDownClose(){
        click(DROPDOWNCLOSE);
    }

    private void EnteringYouSendValue(String YouSend) throws InterruptedException {
        clickWithWait(YOUSEND);
        System.out.println("Entering You Send Value: " + YouSend);
        sendKeys(YOUSEND,YouSend);
        System.out.println("Successfully sent you Send Value: " + YouSend);
    }

    private void PurposeOfTransfer() throws InterruptedException {
        click(PURPOSEOFTRANSFER);
        System.out.println("Successfully clicked the Purpose of Transfer");
        Thread.sleep(1000);
        clickWithWait(PURPOSEOFTRANSFERSEARCH);
        System.out.println("Successfully clicked the Purpose of Transfer");
    }

    private void SendNow() throws InterruptedException {
        Thread.sleep(5000);
        click(SENDNOWBUTTON);
        System.out.println("Successfully clicked the Send Now");
    }

    // Review Payment
    private void CallingReviewPayment(String ReEnterYouSend) throws InterruptedException {
        ReviewPayment Reviewpayment = new ReviewPayment();
        Reviewpayment.ReviewPaymentActions(ReEnterYouSend);
        System.out.println("Successfully clicked the Review Payment Actions");
    }

    // Knet Payment Gateway
    private void CallingPaymentGateway() throws InterruptedException {
        KnetPaymentGateway PaymentGateway = new KnetPaymentGateway();
        PaymentGateway.KnetActions();
    }

    // Transaction Summary
    private void CallingTransactionSummary() throws InterruptedException {
       TransaactionSummary transaactionSummary = new TransaactionSummary();
       transaactionSummary.TranstionSummaryActions();

    }







}
