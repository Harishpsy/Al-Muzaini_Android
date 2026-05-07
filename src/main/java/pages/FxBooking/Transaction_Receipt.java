package pages.FxBooking;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Transaction_Receipt extends BasePage {

    public Transaction_Receipt() {
        super();
    }

    private final By Share = new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(35)");
    private final By DownloadIcon = new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(38)");
    private final By BackToHome = new AppiumBy.ByAccessibilityId("Back To Home");



    public void TransactionReceiptActions(){
//        ClickingShare();
//        ClickingDownloadIcon();
        ClickingBackToHome();
    }

    protected void ClickingShare(){
        clickWithWait(Share);
    }

    protected void ClickingDownloadIcon(){
        clickWithWait(DownloadIcon);
    }

    protected void ClickingBackToHome(){
        clickWithWait(BackToHome);
        System.out.println(" Successfully navigated Back To Home");
    }







}
