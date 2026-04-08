package pages.TransferMoney.Beneficiaries.BankTransfer;

import base.BasePage;
import io.appium.java_client.AppiumBy;

import org.openqa.selenium.By;

public class ReviewPayment extends BasePage {

    public ReviewPayment(){
        super();
    }

    // Xpaths
    private final By EDITICON = By.xpath("//android.view.ViewGroup[contains(@content-desc,\"Receive Amount\")]//android.view.ViewGroup[2]/android.view.ViewGroup");
    private final By REENTERYOUSEND = By.xpath("(//android.widget.EditText)[1] ");
    private final By SENDNOWBUTTON = By.xpath("//android.view.ViewGroup[@content-desc=\"Send Now\"]");
    private final By CONFIRM = By.xpath("//android.view.ViewGroup[@content-desc=\"Confirm\"]");


    public void ReviewPaymentActions(String ReEnterYouSend) throws InterruptedException {
        ClickingEditIcon();
        ReEnterYouSend(ReEnterYouSend);
        SendNow();
        Confirm();
    }

    private void ClickingEditIcon() throws InterruptedException {
        Thread.sleep(5000);
        click(EDITICON);
    }

    private void ReEnterYouSend(String ReEnterYouSend) throws InterruptedException {
        Thread.sleep(5000);
        click(REENTERYOUSEND);
        Thread.sleep(5000);
        sendKeys(REENTERYOUSEND,ReEnterYouSend);
    }

    private void SendNow() throws InterruptedException {
        Thread.sleep(5000);
        click(SENDNOWBUTTON);
    }

    private void Confirm(){
        click(CONFIRM);
    }











}
