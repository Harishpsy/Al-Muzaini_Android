package pages.AddBeneficiary;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class BeneficiaryAddedPage extends BasePage {

    // Locator for Clicking Continue Button After successfully adding beneficiary
    private final By ClickingContinue = new AppiumBy.ByAccessibilityId("Continue");

    public void BeneficiaryAddedCommonActions() throws InterruptedException {
        clickingContinueButton();
    }

    protected void clickingContinueButton() throws InterruptedException {
        Thread.sleep(5000);
        clickWithWait(ClickingContinue);
        System.out.println("Continue button is clicked");
    }






}
