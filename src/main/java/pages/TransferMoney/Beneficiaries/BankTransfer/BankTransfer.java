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

    public void BankTransferAction(String YouSend, String ReEnterYouSend) throws InterruptedException {
        ClickingFirstUserBeneficiary();
        callingMakeTransferPage(YouSend);
        CallingReviewPayment(ReEnterYouSend);
        CallingPaymentGateway();
        CallingTransactionSummary();
    }

    private void ClickingFirstUserBeneficiary() throws InterruptedException {
          Thread.sleep(20000);
          clickWithWait(FIRSTUSERBENEFICIARY);
          System.out.println("Successfully clicked the First Beneficiary");
    }

    private void callingMakeTransferPage(String YouSend) throws InterruptedException {
        MakeTransfer maketransfer= new MakeTransfer();
        maketransfer.MakeTransferCommonActions(YouSend);
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
