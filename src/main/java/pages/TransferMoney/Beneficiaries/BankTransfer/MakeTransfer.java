package pages.TransferMoney.Beneficiaries.BankTransfer;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import utils.ExcelUtils;

import java.util.List;

public class MakeTransfer extends BasePage {

    private final By DROPDOWNOPEN = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup");
    private final By DROPDOWNCLOSE = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[3]/android.view.ViewGroup");
    private final By YOUSEND = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"0.000\").instance(0)");
    private final By PURPOSEOFTRANSFER = By.xpath("//android.view.ViewGroup[@content-desc=\"Purpose of Transfer*\"]/android.view.ViewGroup/com.horcrux.svg.SvgView/com.horcrux.svg.B/com.horcrux.svg.J");
    private final By PURPOSEOFTRANSFERSEARCH = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]");
    private final By SENDNOWBUTTON = By.xpath("//android.widget.TextView[@text=\"Send Now\"]");

    public void MakeTransferCommonActions() throws InterruptedException {
        List<Object[]> data = ExcelUtils.getTestData("BankTransfer.xlsx");
        if (!data.isEmpty()) {
            MakeTransferCommonActions(data.get(0)[0].toString());
        } else {
            throw new RuntimeException("No test data found in BankTransfer.xlsx");
        }
    }

    public void MakeTransferCommonActions(String YouSend) throws InterruptedException{
        EnteringYouSendValue(YouSend);
        PurposeOfTransfer();
        SendNow();
    }

    private void ClickingDropDownOpen() {
        click(DROPDOWNOPEN);
    }

    private void ClickingDropDownClose(){
        click(DROPDOWNCLOSE);
    }

    protected void EnteringYouSendValue(String YouSend) throws InterruptedException {
        clickWithWait(YOUSEND);
        System.out.println("Entering You Send Value: " + YouSend);
        sendKeys(YOUSEND,YouSend);
        System.out.println("Successfully sent you Send Value: " + YouSend);
    }

    protected void PurposeOfTransfer() throws InterruptedException {
        click(PURPOSEOFTRANSFER);
        System.out.println("Successfully clicked the Purpose of Transfer");
        Thread.sleep(1000);
        clickWithWait(PURPOSEOFTRANSFERSEARCH);
        System.out.println("Successfully clicked the Purpose of Transfer");
    }

    protected void SendNow() throws InterruptedException {
        Thread.sleep(7000);
        clickWithWait(SENDNOWBUTTON);
        System.out.println("Successfully clicked the Send Now");
    }

















}
