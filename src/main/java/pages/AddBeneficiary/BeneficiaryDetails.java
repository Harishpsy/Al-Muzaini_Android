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
import utils.ExcelUtils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
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
    // Locator for entering YouSend amount
    private final By YouSend = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"0.000\").instance(0)");
    // Locator for Clicking Purpose of Transfer
    private final By PURPOSEOFTRANSFER = By.xpath("//android.view.ViewGroup[@content-desc=\"Purpose of Transfer*\"]/android.view.ViewGroup/com.horcrux.svg.SvgView/com.horcrux.svg.B/com.horcrux.svg.J");
    // Locator for selecting Purpose of Transfer
    private final By PURPOSEOFTRANSFERSEARCH = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]");
    // Locator for clicking Send Now Button
    private final By SENDNOWBUTTON = By.xpath("//android.widget.TextView[@text=\"Send Now\"]");
    // Locator for clicking Confirm button on KNET page - NOT WORKING AS OF NOW - CLICK MANUALLY
    private final By ClickingConfirm = By.xpath("//android.widget.TextView[@text=\"Confirm\"]");

    private Map<String, String> cachedBeneficiaryData;

    public BeneficiaryDetails() {
        super();
    }

    public void BeneficiaryDetailsCommonActions(String mobile, String firstName, String middleName,
                                                String lastName, String address, String nationality) throws InterruptedException {
        clickingMobileNo();
        enterMobileNo(mobile);
        clickingFirstName();
        enterFirstName(firstName);
        clickingMiddleName();
        enterMiddleName(middleName);
        clickingLastName();
        enterLastName(lastName);
        clickingAddress1();
        enterAddress1(address);
        clickingNationality();
        enterNationality(nationality);
        selectNationalityFromDropdown(nationality);
        clickingSubmitButton();
        clickingContinueButton();
        callingMakeTransferPage();
        CallingReviewPayment();
        CallingPaymentGateway();
        CallingTransactionSummary();
    }

    // Step 1 Click Mobile Number
    public void clickingMobileNo() {
        clickWithWait(ClickMobileNO);
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
    public void clickingFirstName() {
        clickWithWait(ClickingFirstName);
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
    public void clickingMiddleName() {
        clickWithWait(ClickingMiddleName);
        System.out.println("Middle name clicked");
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
    public void clickingLastName() {
        clickWithWait(ClickingLastName);
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
    public void clickingAddress1() {
        clickWithWait(ClickingBeneficiaryAddress1);
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
    protected void clickingContinueButton() throws InterruptedException {
        Thread.sleep(10000);
        clickWithWait(ClickingContinue);
        System.out.println("Continue button is clicked");
    }

    // Calling the Make transfer page
    protected void callingMakeTransferPage() throws InterruptedException {
        new MakeTransfer().MakeTransferCommonActions();
    }

    // Calling the review payment screen
    private void CallingReviewPayment() throws InterruptedException {
        new ReviewPayment().ReviewPaymentActions();
        System.out.println("Successfully clicked the Review Payment Actions");
    }

    // Calling The Knet Page Here To Do Transaction
    private void CallingPaymentGateway() throws InterruptedException {
        KnetPaymentGateway PaymentGateway = new KnetPaymentGateway();
        PaymentGateway.KnetActions();
    }

    // Transaction Summary
    private void CallingTransactionSummary() throws InterruptedException {
        TransaactionSummary transaactionSummary = new TransaactionSummary();
        transaactionSummary.TranstionSummaryActions();
    }
}

