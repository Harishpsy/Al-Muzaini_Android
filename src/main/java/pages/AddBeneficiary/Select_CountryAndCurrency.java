package pages.AddBeneficiary;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Select_CountryAndCurrency extends BasePage {

    //1.Locator for Click selecting Country
    private final By selectCountry = new AppiumBy.ByAccessibilityId("Select Country");
    //2. Locator for Enter Country(Country search text box)
    private final By countrySearchField = By.className("android.widget.EditText");
    //3. Locator for Select Country option from dropdown
    private final By Selectingcountry = new AppiumBy.ByAccessibilityId("BANGLADESH");
    //Locator for selecting Currency
    private final By SelectCurrency = By.xpath("//android.widget.TextView[@text=\"Select Currency\"]");
    //Locator for Selecting Currency in the searched bottom sheet
    private final By SelectingCurrency = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]");
    //Locator for clicking Continue
    private final By ClickingContinue = new  AppiumBy.ByAccessibilityId("Continue");


    public void Select_CountryAndCurrencyCommonActions() throws InterruptedException {
        clickSelectCountry();
        enterCountry();
        selectCountryFromDropdown();
        SelectingCurrency();
        ClickingSearchField();
        ClickingCurrency();
        ClickingContinueButton();
    }

    //Step1 Click select Country
    protected void clickSelectCountry() {
            clickWithWait(selectCountry);
            System.out.println("Select country clicked");
        }

    //Step2 Enter country Name
    protected void enterCountry() throws InterruptedException {
        WebElement country = wait.until(ExpectedConditions.elementToBeClickable(countrySearchField));
        country.click();
        country.sendKeys("BANGLADESH");
        System.out.println("Country entered in the Search Field");

    }

    //Step3 Select Country from dropdown
    protected void selectCountryFromDropdown() throws InterruptedException {
        KeyboardOkButton();
        clickWithWait(Selectingcountry);
        System.out.println("Successfully clicked the Country from Dropdown");
    }

    // Step 4 Selecting Currency
    protected void SelectingCurrency(){
        clickWithWait(SelectCurrency);
    }

    // Step 5 Clicking the Search field and passing the value
    protected void ClickingSearchField(){
        WebElement country = wait.until(ExpectedConditions.elementToBeClickable(countrySearchField));
        country.click();
        country.sendKeys("BANGLADESH");
        System.out.println("Country entered in the Search Field");
    }

    // Step 6 Clicking the Search currency
    protected void ClickingCurrency(){
        KeyboardOkButton();
        clickWithWait(SelectingCurrency);
    }

    // Step 7 Clicking the Continue button
    public void ClickingContinueButton(){
        clickWithWait(ClickingContinue);
    }
}

