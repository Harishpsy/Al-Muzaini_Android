package pages.TransferMoney.Beneficiaries.BankTransfer;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransaactionSummary extends BasePage {

    //Constructor
    public TransaactionSummary(){super();}

    //XPATHS
    private final By BACKTOHOME = By.xpath("//android.view.ViewGroup[@content-desc=\"Back To Home\"]");

    public void TranstionSummaryActions() throws InterruptedException {
        BackToHome();
    }

    private void BackToHome() throws InterruptedException {
        Thread.sleep(5000);
        clickWithWait(BACKTOHOME);
        System.out.println("Successfully clicked the Back To Home");
    }


}




