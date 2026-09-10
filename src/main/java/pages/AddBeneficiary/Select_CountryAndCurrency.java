package pages.AddBeneficiary;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import  io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AddBeneficiary.Select_CountryAndCurrency;

public class Select_CountryAndCurrency extends BasePage {

    //1.Locator for Click selecting Country
    private final By selectCountry = new AppiumBy.ByAccessibilityId("Select Country");

    //2. Locator for Enter Country(Country search text box)
    private final By countrySearchField = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Search Select Country\")");

    //3. Locator for Select Country option from dropdown
    private final By countryOption = new AppiumBy.ByAndroidUIAutomator("new UiSelector().description(\"BANGLADESH\")");

    //Locator for selecting Currency
    private final By selectCurrency = new  AppiumBy.ByAccessibilityId("Select Currency");
    //Locator for clicking Continue
    private final By ClickingCountinue = new  AppiumBy.ByAccessibilityId("Continue");

    //Step1 Click select Country
    public void clickSelectCountry() {
            clickWithWait(selectCountry);
            System.out.println("Select country clicked");
        }

    //Step2 Enter country Name
    public void enterCountry(String country) {
       clickWithWait(countrySearchField);
       sendKeys(countrySearchField, "BANGLADESH");
        System.out.println("Country entered:" + country);
    }

    //Step3 Select Country from dropdown
    public void selectCountryFromDropdown(String country) throws InterruptedException {

        //wait for keyboard/search result to appear
        System.out.println("Before hiding keyboard");
        //Close Android Keyboard
        hideKeyboard();
        Thread.sleep(5000);
        System.out.println("After hiding keyboard");

        //Searched country result appears below the search box
        WebElement countryOptionElement = wait.until(ExpectedConditions.elementToBeClickable(countryOption));

        countryOptionElement.click();
        System.out.println("Bangladesh country: " + country);
    }
}

