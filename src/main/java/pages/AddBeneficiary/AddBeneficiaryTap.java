package pages.AddBeneficiary;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;

import java.time.Duration;

public class AddBeneficiaryTap extends BasePage {

    private final By ClickingAddBeneficiary = new AppiumBy.ByAccessibilityId("Add Beneficiary");
    private final By selectCountry = new AppiumBy.ByAccessibilityId("Select Country");
    private final By selectCurrency = new AppiumBy.ByAccessibilityId("SelectCurrency");
    private final By clickingContinue = new AppiumBy.ByAccessibilityId("Continue");


    public void AddBeneficiaryActions(String countryCode, String currencyCode) throws InterruptedException {
        AddBeneficiaryTapping();
        selectCountry(countryCode);
        selectCurrency(currencyCode);
        continueTapping();
    }
    protected void AddBeneficiaryTapping() throws InterruptedException {
//        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        clickWithWait(ClickingAddBeneficiary);

    }
    protected void selectCountry(String countryCode) throws InterruptedException {
        clickWithWait(selectCountry);
    }
    protected void selectCurrency(String currencyCode) throws InterruptedException {
        clickWithWait(selectCurrency);
    }
    protected  void continueTapping() throws InterruptedException{
        clickWithWait(clickingContinue);
    }


}