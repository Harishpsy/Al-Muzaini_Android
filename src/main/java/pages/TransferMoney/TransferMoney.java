package pages.TransferMoney;

import base.BasePage;

import org.openqa.selenium.By;

import java.time.Duration;

public class TransferMoney extends BasePage {

    public TransferMoney(){
        super();
    }

    private final By TRANSFERMONEY = By.xpath("//android.widget.TextView[@text=\"Send/Transfer Money\"]");

    public void TransferMoneyActions() throws InterruptedException {
        Transfermoney();
    }

    private void Transfermoney() throws InterruptedException {
        clickWithWait(TRANSFERMONEY);
    }

}
