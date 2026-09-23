package locators.AddBeneficiary;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import base.BasePage;

/**
 * Page Object Module - BeneficiaryDetailsPage
 * Contains all locators for the Beneficiary Details screen using @AndroidFindBy annotations.
 * This class is a pure locator repository; no action methods are defined here.
 */
public class BeneficiaryDetailsPage extends BasePage {

    public BeneficiaryDetailsPage() {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Locator for clicking Enter Mobile Number Without CountryCode
    @AndroidFindBy(accessibility = "Enter Mobile Number Without CountryCode")
    public WebElement ClickMobileNO;

    // Locator for entering Mobile Number
    @AndroidFindBy(className = "android.widget.EditText")
    public WebElement EnterMobileNo;

    // Locator for clicking Beneficiary First Name
    @AndroidFindBy(accessibility = "Beneficiary First Name*")
    public WebElement ClickingFirstName;

    // Locator for entering First Name
    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Beneficiary First Name\"]")
    public WebElement EnterFirstName;

    // Locator for Clicking Middle Name
    @AndroidFindBy(accessibility = "Beneficiary Middle Name")
    public WebElement ClickingMiddleName;

    // Locator for entering Middle Name
    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Beneficiary Middle Name\"]")
    public WebElement EnterMiddleName;

    // Locator for Clicking Last Name
    @AndroidFindBy(accessibility = "Beneficiary Last Name*")
    public WebElement ClickingLastName;

    // Locator for entering Last Name
    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Beneficiary Last Name\"]")
    public WebElement EnterLastName;

    // Locator for Clicking Beneficiary Address1
    @AndroidFindBy(accessibility = "BeneficiaryAddress1*")
    public WebElement ClickingBeneficiaryAddress1;

    // Locator for entering Beneficiary Address1
    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"BeneficiaryAddress1\"]")
    public WebElement EnterBeneficiaryAddress1;

    // Locator for Clicking Nationality
    @AndroidFindBy(accessibility = "Nationality*")
    public WebElement ClickingNationality;

    // Locator for entering Nationality in search box
    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Search Nationality\"]")
    public WebElement NationalitySearchField;

    // Default fallback Locator for Selecting Nationality
    @AndroidFindBy(accessibility = "BANGLADESHI")
    public WebElement SelectingNationality;

    // Locator for Clicking Submit Button
    @AndroidFindBy(accessibility = "Submit")
    public WebElement ClickingSubmit;

    // Locator for Clicking Continue Button After successfully adding beneficiary
    @AndroidFindBy(accessibility = "Continue")
    public WebElement ClickingContinue;

}
