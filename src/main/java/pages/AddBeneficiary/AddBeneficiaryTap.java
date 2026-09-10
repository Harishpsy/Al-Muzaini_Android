package pages.AddBeneficiary;

import base.BasePage;
import io.appium.java_client.AppiumBy;

import org.openqa.selenium.By;

import java.time.Duration;

public class AddBeneficiaryTap extends BasePage {

    private final By ClickingAddBeneficiary = new AppiumBy.ByAccessibilityId("Add Beneficiary");


    public void AddBeneficiaryActions() throws InterruptedException {
        AddBeneficiaryTapping();
    }
    protected void AddBeneficiaryTapping() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        clickWithWait(ClickingAddBeneficiary);

    }


}