package pages.RateCalculator;

import base.BasePage;
import org.openqa.selenium.By;

public class Transfer extends BasePage {

    private final By FCAmount = By.xpath("(//android.widget.EditText[contains(@text, \"\")])[1]");
    private final By LCAmount = By.xpath("(//android.widget.EditText[contains(@text, \"\")])[2]");
    private final By ChangeCurrency = By.xpath("(//android.view.ViewGroup[contains(@content-desc, \",\")])[1]");
    private final By SelectingCurrency = By.xpath("//android.view.ViewGroup[@content-desc=\"BHD - BAHRAINI DINAR\"]");
    private final By ClickingClose = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup");
    private final By ClickingSearchField = By.xpath("//android.widget.EditText[contains(@text, \"\")]");

    public void TransferActions() throws InterruptedException {
        implicitwait();
        ClickingFcCurrency();
        ClickingLCTextField();
        ClickingTheCurrency();
        CloseIcon();
        ClickingTheCurrency();
        ClickingSeacrhField();
        KeyboardOkButton();
        scrollToEnd();
        scrollToTop();
        ClickingBharain();
    }

    protected void ClickingFcCurrency() throws InterruptedException {
        clickWithWait(FCAmount);
        System.out.println("Successfully clicked the FC Currency");
        sendKeys(FCAmount, "100");
        Thread.sleep(5000);
        clear(FCAmount);
        System.out.println("Successfully cleared the FC Currency");
    }

    protected void ClickingLCTextField() throws InterruptedException {
        clickWithWait(LCAmount);
        System.out.println("Successfully clicked the LC Currency");
        sendKeys(LCAmount, "1000");
        Thread.sleep(5000);
        clear(LCAmount);
        System.out.println("Successfully cleared the LC Currency");
    }

    protected void ClickingTheCurrency(){
        click(ChangeCurrency);
        System.out.println("Successfully clicked the Change Currency");
    }

    protected void ClickingBharain() throws InterruptedException {
        Thread.sleep(2000);
        clickWithWait(SelectingCurrency);
        System.out.println("Successfully clicked the Bharain Currency");
    }

    protected void CloseIcon(){
        clickWithWait(ClickingClose);
    }

    protected void ClickingSeacrhField() throws InterruptedException {
        Thread.sleep(2000);
        clickWithWait(ClickingSearchField);
        sendKeys(ClickingSearchField, "BAH");
        clear(ClickingSearchField);
    }

}
