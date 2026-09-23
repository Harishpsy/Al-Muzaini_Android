package pages.AddBeneficiary;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.OTPVerififcationPage;
import pages.TransferMoney.Beneficiaries.BankTransfer.KnetPaymentGateway;
import pages.TransferMoney.Beneficiaries.BankTransfer.MakeTransfer;
import pages.TransferMoney.Beneficiaries.BankTransfer.ReviewPayment;
import pages.TransferMoney.Beneficiaries.BankTransfer.TransaactionSummary;
import java.util.Map;

public class BeneficiaryDetails extends BasePage {

    // Locator for clicking Enter Mobile Number Without CountryCode
    private final By ClickMobileNO = new AppiumBy.ByAccessibilityId("Enter Mobile Number Without CountryCode");
    // Locator for entering Mobile Number
    private final By EnterMobileNo = By.className("android.widget.EditText");
    // Locator for clicking Beneficiary First Name
    private final By ClickingFirstName = new AppiumBy.ByAccessibilityId("Beneficiary First Name*");
    // Locator for entering First Name
    private final By EnterFirstName = By.xpath("//android.widget.EditText[@text=\"Beneficiary First Name\"]");
    // Locator for Clicking Middle Name
    private final By ClickingMiddleName = new AppiumBy.ByAccessibilityId("Beneficiary Middle Name");
    // Locator for entering Middle Name
    private final By EnterMiddleName = By.xpath("//android.widget.EditText[@text=\"Beneficiary Middle Name\"]");
    // Locator for Clicking Last Name
    private final By ClickingLastName = new AppiumBy.ByAccessibilityId("Beneficiary Last Name*");
    // Locator for entering Last Name
    private final By EnterLastName = By.xpath("//android.widget.EditText[@text=\"Beneficiary Last Name\"]");
    // Locator for Clicking Beneficiary Address1
    private final By ClickingBeneficiaryAddress1 = new AppiumBy.ByAccessibilityId("BeneficiaryAddress1*");
    // Locator for entering Beneficiary Address1
    private final By EnterBeneficiaryAddress1 = By.xpath("//android.widget.EditText[@text=\"BeneficiaryAddress1\"]");
    // Locator for Clicking Nationality
    private final By ClickingNationality = new AppiumBy.ByAccessibilityId("Nationality*");
    // Locator for entering Nationality in search box
    private final By NationalitySearchField = By.xpath("//android.widget.EditText[@text=\"Search Nationality\"]");
    // Default fallback Locator for Selecting Nationality
    private final By SelectingNationality = new AppiumBy.ByAccessibilityId("BANGLADESHI");
    // Locator for Clicking Submit Button
    private final By ClickingSubmit = new AppiumBy.ByAccessibilityId("Submit");
    // Locator for Clicking Continue Button After successfully adding beneficiary
    private final By ClickingContinue = new AppiumBy.ByAccessibilityId("Continue");

    public BeneficiaryDetails() {
        super();
    }

    public void BeneficiaryDetailsCommonActions(String mobile, String firstName, String middleName,
                                                String lastName, String address, String nationality) throws InterruptedException {
        clickingMobileNo(mobile);
//        enterMobileNo(mobile);
        clickingFirstName(firstName);
//        enterFirstName(firstName);
        clickingMiddleName(middleName);
//        enterMiddleName(middleName);
        clickingLastName(lastName);
//        enterLastName(lastName);
        clickingAddress1(address);
        KeyboardOkButton();
//        enterAddress1(address);
        clickingNationality();
        enterNationality(nationality);
        selectNationalityFromDropdown(nationality);
        clickingSubmitButton();
        callingBenefciaryAddedPage();
        callingMakeTransferPage();
        CallingReviewPayment();
        CallingPaymentGateway();
        CallingTransactionSummary();
    }

    // Step 1 Click Mobile Number
    public void clickingMobileNo(String mobileNumber) {
        clickWithWait(ClickMobileNO);
        sendKeys(EnterMobileNo,mobileNumber);
        System.out.println("Mobile number clicked");
    }

    // Step 2 Enter Mobile Number
    public void enterMobileNo(String mobileNumber) throws InterruptedException {
        WebElement mobileNo = wait.until(ExpectedConditions.elementToBeClickable(EnterMobileNo));
        mobileNo.click();
        mobileNo.sendKeys(mobileNumber);
        System.out.println("Mobile number is entered: " + mobileNumber);
        KeyboardOkButton();
    }

    // Step 3 Click First Name
    public void clickingFirstName(String firstNameText) {
        clickWithWait(ClickingFirstName);
        sendKeys(EnterFirstName,firstNameText);
        System.out.println("First Name clicked");
    }

    // Step 4 Enter First Name
    public void enterFirstName(String firstNameText) throws InterruptedException {
        WebElement firstName = wait.until(ExpectedConditions.elementToBeClickable(EnterFirstName));
        firstName.click();
        firstName.sendKeys(firstNameText);
        System.out.println("First name is entered: " + firstNameText);
        KeyboardOkButton();
    }

    // Step 5 Click Middle Name
    public void clickingMiddleName(String middleNameText) {
        clickWithWait(ClickingMiddleName);
        System.out.println("Middle name clicked");
        sendKeys(EnterMiddleName,middleNameText);
    }

    // Step 6 Enter Middle Name
    public void enterMiddleName(String middleNameText) throws InterruptedException {
        WebElement middleName = wait.until(ExpectedConditions.elementToBeClickable(EnterMiddleName));
        middleName.click();
        middleName.sendKeys(middleNameText);
        System.out.println("Middle name is entered: " + middleNameText);
        KeyboardOkButton();
    }


    // Step 7 Click Last Name
    public void clickingLastName(String lastNameText) {
        clickWithWait(ClickingLastName);
        sendKeys(EnterLastName,lastNameText);
        System.out.println("Last name clicked");
    }

    // Step 8 Enter Last Name
    public void enterLastName(String lastNameText) throws InterruptedException {
        WebElement lastName = wait.until(ExpectedConditions.elementToBeClickable(EnterLastName));
        lastName.click();
        lastName.sendKeys(lastNameText);
        System.out.println("Last name is entered: " + lastNameText);
        KeyboardOkButton();
    }


    // Step 9 Click Beneficiary Address1
    public void clickingAddress1(String addressText) {
        clickWithWait(ClickingBeneficiaryAddress1);
        sendKeys(EnterBeneficiaryAddress1, addressText);
        System.out.println("Beneficiary Address1 is clicked");
    }

    // Step 10 Enter Beneficiary Address1
    public void enterAddress1(String addressText) throws InterruptedException {
        WebElement address1 = wait.until(ExpectedConditions.elementToBeClickable(EnterBeneficiaryAddress1));
        address1.click();
        address1.sendKeys(addressText);
        System.out.println("Beneficiary Address1 is entered: " + addressText);
        KeyboardOkButton();
    }

    // Step 11 Click Nationality
    public void clickingNationality() {
        clickWithWait(ClickingNationality);
        System.out.println("Nationality is clicked");
    }

    // Step 12 Enter Nationality
    public void enterNationality(String nationalityText) throws InterruptedException {
        WebElement nationality = wait.until(ExpectedConditions.elementToBeClickable(NationalitySearchField));
        nationality.click();
        nationality.sendKeys(nationalityText);
        System.out.println("Nationality is entered: " + nationalityText);
    }

    // Step 13 Select Nationality from the dropdown
    public void selectNationalityFromDropdown(String nationalityText) throws InterruptedException {
        KeyboardOkButton();
        By dynamicLocator = new AppiumBy.ByAccessibilityId(nationalityText.toUpperCase());
        try {
            clickWithWait(dynamicLocator);
        } catch (Exception e) {
            clickWithWait(new AppiumBy.ByAccessibilityId(nationalityText));
        }
        System.out.println("Successfully clicked the Nationality from Dropdown: " + nationalityText);
    }

    // Step 14 Click Submit Button
    protected void clickingSubmitButton() throws InterruptedException {
        clickWithWait(ClickingSubmit);
        System.out.println("Submit button is clicked");
        Thread.sleep(5000);
        OTPVerififcationPage otpVerififcationPage = new OTPVerififcationPage();
        otpVerififcationPage.OtpVerificationPageCommonActions();
    }

    // Step 15 Clicking the Continue button
      protected void callingBenefciaryAddedPage() throws InterruptedException {
        new BeneficiaryAddedPage().BeneficiaryAddedCommonActions();
      }

    // Step 16 Calling the Make transfer page
    protected void callingMakeTransferPage() throws InterruptedException {
        new MakeTransfer().MakeTransferCommonActions();
    }

    // Step 17 Calling the review payment screen
    private void CallingReviewPayment() throws InterruptedException {
        new ReviewPayment().ReviewPaymentActions();
        System.out.println("Successfully clicked the Review Payment Actions");
    }

    // Step 18 Calling The Knet Page Here To Do Transaction
    private void CallingPaymentGateway() throws InterruptedException {
        KnetPaymentGateway PaymentGateway = new KnetPaymentGateway();
        PaymentGateway.KnetActions();
    }

    // Step 19 Transaction Summary
    private void CallingTransactionSummary() throws InterruptedException {
        TransaactionSummary transaactionSummary = new TransaactionSummary();
        transaactionSummary.TranstionSummaryActions();
    }
}

