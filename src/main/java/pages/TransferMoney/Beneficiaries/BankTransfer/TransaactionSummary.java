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
        takeTransactionSummaryScreenshot();
        BackToHome();
    }

    public void takeTransactionSummaryScreenshot() throws InterruptedException {
        Thread.sleep(30000);
        takeScreenshot("Transaction Summary", "Transaction_Summary");
        System.out.println("Successfully took screenshot of Transaction Summary and saved in 'Transaction Summary' folder");
    }

    private void BackToHome() throws InterruptedException {
        Thread.sleep(3000);
        clickWithWait(BACKTOHOME);
        System.out.println("Successfully clicked the Back To Home");
    }
}




