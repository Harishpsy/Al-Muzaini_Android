package pages.AddBeneficiary;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import locators.AddBeneficiary.BeneficiaryDetailsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.OTPVerififcationPage;
import pages.TransferMoney.Beneficiaries.BankTransfer.KnetPaymentGateway;
import pages.TransferMoney.Beneficiaries.BankTransfer.MakeTransfer;
import pages.TransferMoney.Beneficiaries.BankTransfer.ReviewPayment;
import pages.TransferMoney.Beneficiaries.BankTransfer.TransaactionSummary;

public class BeneficiaryDetails extends BasePage {

    // Page Object Module – all locators are centralised in BeneficiaryDetailsPage
    private final BeneficiaryDetailsPage locators = new BeneficiaryDetailsPage();


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
        clickWithWaitElement(locators.ClickMobileNO);
        locators.EnterMobileNo.sendKeys(mobileNumber);
        System.out.println("Mobile number clicked");
    }

    // Step 2 Enter Mobile Number
    public void enterMobileNo(String mobileNumber) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(locators.EnterMobileNo));
        clickWithWaitElement(locators.EnterMobileNo);
        locators.EnterMobileNo.sendKeys(mobileNumber);
        System.out.println("Mobile number is entered: " + mobileNumber);
        KeyboardOkButton();
    }

    // Step 3 Click First Name
    public void clickingFirstName(String firstNameText) {
        clickWithWaitElement(locators.ClickingFirstName);
        locators.EnterFirstName.sendKeys(firstNameText);
        System.out.println("First Name clicked");
    }

    // Step 4 Enter First Name
    public void enterFirstName(String firstNameText) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(locators.EnterFirstName));
        clickWithWaitElement(locators.EnterFirstName);
        locators.EnterFirstName.sendKeys(firstNameText);
        System.out.println("First name is entered: " + firstNameText);
        KeyboardOkButton();
    }

    // Step 5 Click Middle Name
    public void clickingMiddleName(String middleNameText) {
        clickWithWaitElement(locators.ClickingMiddleName);
        System.out.println("Middle name clicked");
        locators.EnterMiddleName.sendKeys(middleNameText);
    }

    // Step 6 Enter Middle Name
    public void enterMiddleName(String middleNameText) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(locators.EnterMiddleName));
        clickWithWaitElement(locators.EnterMiddleName);
        locators.EnterMiddleName.sendKeys(middleNameText);
        System.out.println("Middle name is entered: " + middleNameText);
        KeyboardOkButton();
    }


    // Step 7 Click Last Name
    public void clickingLastName(String lastNameText) {
        clickWithWaitElement(locators.ClickingLastName);
        locators.EnterLastName.sendKeys(lastNameText);
        System.out.println("Last name clicked");
    }

    // Step 8 Enter Last Name
    public void enterLastName(String lastNameText) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(locators.EnterLastName));
        clickWithWaitElement(locators.EnterLastName);
        locators.EnterLastName.sendKeys(lastNameText);
        System.out.println("Last name is entered: " + lastNameText);
        KeyboardOkButton();
    }


    // Step 9 Click Beneficiary Address1
    public void clickingAddress1(String addressText) {
        clickWithWaitElement(locators.ClickingBeneficiaryAddress1);
        locators.EnterBeneficiaryAddress1.sendKeys(addressText);
        System.out.println("Beneficiary Address1 is clicked");
    }

    // Step 10 Enter Beneficiary Address1
    public void enterAddress1(String addressText) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(locators.EnterBeneficiaryAddress1));
        clickWithWaitElement(locators.EnterBeneficiaryAddress1);
        locators.EnterBeneficiaryAddress1.sendKeys(addressText);
        System.out.println("Beneficiary Address1 is entered: " + addressText);
        KeyboardOkButton();
    }

    // Step 11 Click Nationality
    public void clickingNationality() {
        clickWithWaitElement(locators.ClickingNationality);
        System.out.println("Nationality is clicked");
    }

    // Step 12 Enter Nationality
    public void enterNationality(String nationalityText)  {
        locators.NationalitySearchField.sendKeys(nationalityText);
        System.out.println("Nationality is entered: " + nationalityText);
    }

    // Step 13 Select Nationality from the dropdown
    public void selectNationalityFromDropdown(String nationalityText)  {
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
        clickWithWaitElement(locators.ClickingSubmit);
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

