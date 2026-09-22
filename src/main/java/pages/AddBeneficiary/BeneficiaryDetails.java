package pages.AddBeneficiary;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.DashboardPage;
import pages.FxBooking.Transaction_Receipt;
import pages.OTPVerififcationPage;
import pages.TransferMoney.Beneficiaries.BankTransfer.KnetPaymentGateway;
import pages.TransferMoney.Beneficiaries.BankTransfer.MakeTransfer;
import pages.TransferMoney.Beneficiaries.BankTransfer.ReviewPayment;
import pages.TransferMoney.Beneficiaries.BankTransfer.TransaactionSummary;

public class BeneficiaryDetails extends BasePage {

    //Locator for clicking Enter Mobile Number Without CountryCode
    private final By ClickMobileNO = new AppiumBy.ByAccessibilityId("Enter Mobile Number Without CountryCode");
    //Locator for entering Mobile Number
    private final By EnterMobileNo = By.className("android.widget.EditText");
    // Locator for clicking Beneficiary First Name
    private final By ClickingFirstName = new AppiumBy.ByAccessibilityId("Beneficiary First Name*");
    // Locator for entering First Name
    private final By EnterFirstName = By.xpath("//android.widget.EditText[@text=\"Beneficiary First Name\"]");
    //Locator for Clicking Middle Name
    private final By ClickingMiddleName = new AppiumBy.ByAccessibilityId("Beneficiary Middle Name");
    //Locator for entering Middle Name
    private final By EnterMiddleName = By.xpath("//android.widget.EditText[@text=\"Beneficiary Middle Name\"]");
    //private final By EnterMiddleName = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Beneficiary Middle Name\")");
    //Locator for Clicking Last Name
    private final By ClickingLastName = new AppiumBy.ByAccessibilityId("Beneficiary Last Name*");
    //Locator for entering Last Name
    private final By EnterLastName = By.xpath("//android.widget.EditText[@text=\"Beneficiary Last Name\"]");
    //Locator for Clicking Beneficiary Address1
    private final By ClickingBeneficiaryAddress1 = new AppiumBy.ByAccessibilityId("BeneficiaryAddress1*");
    //Locator for entering Beneficiary Address1
    private final By EnterBeneficiaryAddress1 = By.xpath("//android.widget.EditText[@text=\"BeneficiaryAddress1\"]");
    //Locator for Clicking Nationality
    private final By ClickingNationality = new AppiumBy.ByAccessibilityId("Nationality*");
    //Locator for entering Nationality in search box
    private final By NationalitySearchField = By.xpath("//android.widget.EditText[@text=\"Search Nationality\"]");
    //Locator for Selecting Nationality
    private final By SelectingNationality = new AppiumBy.ByAccessibilityId("BANGLADESHI");
    //Locator for Clicking Submit Button
    private final By ClickingSubmit = new AppiumBy.ByAccessibilityId("Submit");
    //Locator for Clicking Continue Button After successfully adding beneficiary
    private final By ClickingContinue = new AppiumBy.ByAccessibilityId("Continue");
    //Locator for entering YouSend amount
    private final By YouSend = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"0.000\").instance(0)");
    //Locator for Clicking Purpose of Transfer
    private final By PURPOSEOFTRANSFER = By.xpath("//android.view.ViewGroup[@content-desc=\"Purpose of Transfer*\"]/android.view.ViewGroup/com.horcrux.svg.SvgView/com.horcrux.svg.B/com.horcrux.svg.J");
    //Locator for selecting Purpose of Transfer
    private final By PURPOSEOFTRANSFERSEARCH = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]");
    //Locator for clicking Send Now Button
    private final By SENDNOWBUTTON = By.xpath("//android.widget.TextView[@text=\"Send Now\"]");
    //Locator for clicking Confirm button on KNET page - NOT WORKING AS OF NOW - CLICK MANUALLY
    private final By ClickingConfirm = By.xpath("//android.widget.TextView[@text=\"Confirm\"]");

    public void BeneficiaryDetailsCommonActions(String YouSend, String ReEnterYouSend) throws InterruptedException {
        clickingMobileNo();
        enterMobileNo();
        clickingFirstName();
        enterFirstName();
        clickingMiddleName();
        enterMiddleName();
        clickingLastName();
        enterLastName();
        clickingAddress1();
        enterAddress1();
        clickingNationality();
        enterNationality();
        selectNationalityFromDropdown();
        clickingSubmitButton();
        clickingContinueButton();
        callingMakeTransferPage(YouSend);
        CallingReviewPayment(ReEnterYouSend);
        CallingPaymentGateway();
        CallingTransactionSummary();
    }

    //Step1 Click Mobile Number
    public void clickingMobileNo() {
        clickWithWait(ClickMobileNO);
        System.out.println("Mobile number clicked");
    }

    //Step2 Enter Mobile Number
    protected void enterMobileNo() throws InterruptedException {
        WebElement mobileNo = wait.until(ExpectedConditions.elementToBeClickable(EnterMobileNo));
        mobileNo.click();
        mobileNo.sendKeys("1712345678");
        System.out.println("Mobile number is entered");
        KeyboardOkButton();
    }

    //Step3 Click First Name
    public void clickingFirstName() {
        clickWithWait(ClickingFirstName);
        System.out.println("First Name clicked");
    }

    //Step4 Enter First Name
    protected void enterFirstName() throws InterruptedException {
        WebElement firstName = wait.until(ExpectedConditions.elementToBeClickable(EnterFirstName));
        firstName.click();
        firstName.sendKeys("Auto");
        System.out.println("First name is entered");
        KeyboardOkButton();
    }

    //Step5 Click Middle Name
    public void clickingMiddleName() {
        clickWithWait(ClickingMiddleName);
        System.out.println("Middle name clicked");
    }

    //Step6 Enter Middle Name
    protected void enterMiddleName() throws InterruptedException {
        WebElement middleName = wait.until(ExpectedConditions.elementToBeClickable(EnterMiddleName));
        middleName.click();
        //scrollWithClick(EnterMiddleName);
        middleName.sendKeys("mation");
        System.out.println("Middle name is entered");
        KeyboardOkButton();
    }

    //Step7 Click Last Name
    public void clickingLastName() {
        clickWithWait(ClickingLastName);
        System.out.println("Last name clicked");
    }

    //Step8 Enter Last Name
    protected void enterLastName() throws InterruptedException {
        WebElement lastName = wait.until(ExpectedConditions.elementToBeClickable(EnterLastName));
        lastName.click();
        lastName.sendKeys("TestOne");
        System.out.println("Last name is entered");
        KeyboardOkButton();
    }

    //Step9 Click Beneficiary Address1
    public void clickingAddress1() {
        clickWithWait(ClickingBeneficiaryAddress1);
        System.out.println("Beneficiary Address1 is clicked");
    }

    //Step10 Enter Beneficiary Address1
    protected void enterAddress1() throws InterruptedException {
        WebElement address1 = wait.until(ExpectedConditions.elementToBeClickable(EnterBeneficiaryAddress1));
        address1.click();
        address1.sendKeys("Bangla");
        System.out.println("Beneficiary Address1 is enterd");
        KeyboardOkButton();
    }

    //Step11 Click Nationality
    public void clickingNationality() {
        clickWithWait(ClickingNationality);
        System.out.println("Nationality is clicked");
    }

    //Step12 Enter Nationality
    protected void enterNationality() throws InterruptedException {
        WebElement nationality = wait.until(ExpectedConditions.elementToBeClickable(NationalitySearchField));
        nationality.click();
        nationality.sendKeys("BANGLADESHI");
        System.out.println("Nationality is entered");
    }

    //Step13 Select Nationality from the dropdown
    protected void selectNationalityFromDropdown() throws InterruptedException {
        KeyboardOkButton();
        clickWithWait(SelectingNationality);
        System.out.println("Successfully clicked the Nationality from Dropdown");
    }

    //Step14 Click Submit Button
    protected void clickingSubmitButton() throws InterruptedException {
        clickWithWait(ClickingSubmit);
        System.out.println("Submit button is clicked");
        Thread.sleep(5000);
        OTPVerififcationPage otpVerififcationPage = new OTPVerififcationPage();
        otpVerififcationPage.OtpVerificationPageCommonActions();
    }

    // Step 14 Clicking the Continue button
    protected void clickingContinueButton() throws InterruptedException {
        Thread.sleep(10000);
        clickWithWait(ClickingContinue);
        System.out.println("Continue button is clicked");
    }

    // Calling the Make transfer page
    protected void callingMakeTransferPage(String YouSend) throws InterruptedException {
        MakeTransfer maketransfer= new MakeTransfer();
        maketransfer.MakeTransferCommonActions(YouSend);
    }

    // Calling the review payment screen
    private void CallingReviewPayment(String ReEnterYouSend) throws InterruptedException {
        ReviewPayment Reviewpayment = new ReviewPayment();
        Reviewpayment.ReviewPaymentActions(ReEnterYouSend);
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

