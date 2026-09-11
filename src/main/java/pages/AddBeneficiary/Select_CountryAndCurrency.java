package pages.AddBeneficiary;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import  io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AddBeneficiary.Select_CountryAndCurrency;

public class Select_CountryAndCurrency extends BasePage {

    //1.Locator for Click selecting Country
    private final By selectCountry = new AppiumBy.ByAccessibilityId("Select Country");

    //2. Locator for Enter Country(Country search text box)
    private final By countrySearchField = By.className("android.widget.EditText");

    //3. Locator for Select Country option from dropdown
    private final By Selectingcountry = new AppiumBy.ByAccessibilityId("BANGLADESH");

    //Locator for selecting Currency
    private final By selectCurrency = new  AppiumBy.ByAccessibilityId("Select Currency");
    //Locator for clicking Continue
    private final By ClickingCountinue = new  AppiumBy.ByAccessibilityId("Continue");


    public void Select_CountryAndCurrencyCommonActions() throws InterruptedException {
        clickSelectCountry();
        enterCountry();
        hideKeyboard();
        selectCountryFromDropdown();
    }


    //Step1 Click select Country
    public void clickSelectCountry() {
            clickWithWait(selectCountry);
            System.out.println("Select country clicked");
        }

    //Step2 Enter country Name
    public void enterCountry() throws InterruptedException {
        Thread.sleep(5000);
        WebElement country = wait.until(ExpectedConditions.elementToBeClickable(countrySearchField));
        country.click();
        country.sendKeys("BANGLADESH");
        System.out.println("Country entered:");

    }

    //Step3 Select Country from dropdown
    public void selectCountryFromDropdown() throws InterruptedException {
        Thread.sleep(5000);
        //Searched country result appears below the search box
//        WebElement countryOptionElement = wait.until(ExpectedConditions.elementToBeClickable(countryOption));
//        countryOptionElement.click();
        clickWithWait(Selectingcountry);
        System.out.println("Successfully clicked the Country from Dropdown");
    }
}

