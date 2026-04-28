package pages.FxBooking; // Package declaration for FX Booking related page objects

import base.BasePage; // Importing BasePage class for common reusable methods
import io.appium.java_client.AppiumBy; // Import for Appium specific locators
import org.openqa.selenium.By; // Import for Selenium locator strategies
import org.openqa.selenium.Keys; // Import for keyboard actions

import pages.TransferMoney.Beneficiaries.BankTransfer.KnetPaymentGateway;

// Page class for FX Booking screen extending BasePage
public class FxbookingPage extends BasePage {

    // Locator for selecting currency dropdown
   private final By SelectCurrencyTapping = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]");

    // Locator for search input field
    private final By clickingSearch = By.className("android.widget.EditText");

    // Locator for selecting a currency from dropdown using UIAutomator
    private final By selectingCurrency = new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(18)");

    // Locator for entering amount field
    private final By EnteringAmount = By.xpath("//android.widget.EditText[@text=\"0.00\"]");

    // Locator For close icon
    private final By CloseIconInReviewOrder = new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.widget.Button\")");

    // Locator for guide tour overlay clicks
    private final By ClickingGuideTour = By.className("android.view.View");

    // Locator for Purpose of Transfer input field
    private final By PurposeOfTransfer = By.xpath("//android.view.ViewGroup[@content-desc=\"Purpose of Exchange*\"]/android.view.ViewGroup");

    // Locator for selecting purpose from dropdown
    private final By ClickingThePurposeOfTransferDropdown = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]");

    // Locator for closing popup (Purpose of Transfer)
    private final By ClickingClosingButton = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup");

    // Locator for Preferred Date input field
    private final By PrefferedDate = By.xpath("//android.view.ViewGroup[@content-desc=\"Preferred Date*\"]/android.view.ViewGroup");

    // Locator for Preferred Date dropdown
    private final By ClickingPrefferedDateDropdown = new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(14)");

    // Locator for closing Preferred Date popup
    private final By ClickingCloseIcon = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup");

    // Locator for selecting Time Slot
    private final By TimeSlot = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Time Slot*\")");
    // Locator for closing Time Slot popup
    private final By ClickingCloseIconTimeSlot = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]");

    private final By ClickingTimeSlotBottomSheetdata = new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(17)");

    // Locator for Proceed button
    private final By ProceedButton = new AppiumBy.ByAccessibilityId("Proceed");

    // Locator for Add Currency button
    private final By AddCurrency = new AppiumBy.ByAccessibilityId("Add Currency");

    private final By DeliveryInstruction = By.xpath("//android.view.ViewGroup[@content-desc=\"Delivery Instructions\"]/android.view.ViewGroup/android.view.ViewGroup[2]");

    private final By ClickingDeliveryInstructionBottonSheet = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]");

    private final By ClickingCloseIconInDelevieryInstructionsBottomsheet = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]");

    private final By TransferSummaryTermsAndConditions = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Terms & Conditions\")");

    private final By ClickingCloseIconInTermsAndConditionsModal = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup");

    private final By ClickingOkButtonInTermsAndConditionsModal = new AppiumBy.ByAccessibilityId("OK");

    private final By ClickingCheckBoxInTermsAndConditions = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.widget.Button");

    private final By ClickingBackButton = new AppiumBy.ByAccessibilityId("Back");

    private final By ClickingThePayButton = new AppiumBy.ByAccessibilityId("Pay");



    // Main method to perform all actions in FX Booking page
    public void FXBookingPageCommonActions(String Amount) throws InterruptedException {

        GuideTour(); // Handle guide tour popup
        SelectCurrencyDropDown(); // Open currency dropdown
        SelectingCurrencyInDropDown(); // Select a currency
        EnteringAmount(Amount); // Enter amount value
//      ClickingAddCurrencyButton(); // Click add currency button
        CloseIconInReviewOrder(); // Click Close icon
        PurposeOfTransfer(); // Select purpose of transfer
        PrefferedDate(); // Select preferred date
        TimeSlot(); // Select time slot
        ClickingTheProceedButton(); // Click proceed button
        ClickingAddCurrencyButton(); // Click add currency button
        ClickingTheProceedButton(); // Click proceed button
        TransferSummaryActions(); // Transfer Summary Page Actions

        KentPage();
        TransactionReceipt();
    }

    // Method to handle guide tour popup by clicking multiple times
    protected void GuideTour() {
        for(int i = 0; i < 6; i++) { // Loop for max 6 steps
            try {
                clickWithWait(ClickingGuideTour); // Click guide tour overlay
            } catch (Exception e) { // Break if no more steps
                System.out.println("Guide Tour stopped at step " + (i + 1));
                break;
            }
        }
    }

    // Method to open currency dropdown
    protected void SelectCurrencyDropDown() {
        clickWithWait(SelectCurrencyTapping); // Click dropdown
        System.out.println("Selecting Currency Dropdown");
    }

    // Method to perform search in currency field
    protected void ClickingSearch() {
        this.click(this.clickingSearch); // Click search field
        this.sendKeys(this.clickingSearch, "Aust"); // Enter search text
        this.sendKeys(this.clickingSearch, String.valueOf(Keys.DELETE)); // Delete last character
    }

    // Method to select currency from dropdown
    protected void SelectingCurrencyInDropDown() throws InterruptedException {
        Thread.sleep(1000); // Static wait (not recommended but used here)
        clickWithWait(selectingCurrency); // Select currency
        System.out.println("SuccessFully Clicked the Currency");
    }

    // Method to enter amount
    protected void EnteringAmount(String Amount) {
        clickWithWait(EnteringAmount); // Click amount field
        sendKeys(EnteringAmount, Amount); // Enter amount value
        System.out.println("SuccessFully Clicked and Entered The Amount");
    }

    // Method to click Add Currency button
    protected void ClickingAddCurrencyButton(){
        clickWithWait(AddCurrency); // Click Add Currency
        System.out.println("Successfully clicked the Add Currency Button");
    }

    // Method to click the close icon in review order
    protected void CloseIconInReviewOrder(){
        clickWithWait(CloseIconInReviewOrder);
    }

    // Method to handle Purpose of Transfer flow
    protected void PurposeOfTransfer() throws InterruptedException {
        ClickingThePuproseOfTransfer(); // Open dropdown
        ClickingCloseIconInPurposeofTransfer(); // Close dropdown
        ClickingThePuproseOfTransfer(); // Re-open dropdown
        SelectingAnPurposeOfTransferInDropDown(); // Select value
    }

    // Click Purpose of Transfer field
    protected void ClickingThePuproseOfTransfer() throws InterruptedException {
        Thread.sleep(2000);
        clickWithWait(PurposeOfTransfer);
        System.out.println("Successfully clicked the Purpose of Transfer");
    }

    // Select option from Purpose dropdown
    protected void SelectingAnPurposeOfTransferInDropDown() throws InterruptedException {
        Thread.sleep(1000);
        clickWithWait(ClickingThePurposeOfTransferDropdown);
        System.out.println("Successfully clicked the Purpose of Transfer");
    }

    // Close Purpose dropdown popup
    protected void ClickingCloseIconInPurposeofTransfer(){
        clickWithWait(ClickingClosingButton);
        System.out.println("Successfully clicked the Closing Icon in Purpose of Transfer");
    }

    // Method to handle Preferred Date flow
    protected void PrefferedDate() throws InterruptedException {
        clickingPrefferedDateDropdown(); // Open dropdown
        clickingCloseIconPrefferedDate(); // Close dropdown
        clickingPrefferedDateDropdown(); // Re-open dropdown
        SelectingPrefferedDate(); // Select date
    }

    // Click Preferred Date dropdown
    protected void clickingPrefferedDateDropdown() throws InterruptedException {
        Thread.sleep(1000);
        clickWithWait(PrefferedDate);
        System.out.println("Successfully clicked the Preffered Date Dropdown");
    }

    // Select Preferred Date
    protected void SelectingPrefferedDate() throws InterruptedException {
        Thread.sleep(1000);
        clickWithWait(ClickingPrefferedDateDropdown);
        System.out.println("Successfully clicked the Preffered Date Dropdown data");
    }

    // Close Preferred Date popup
    protected void clickingCloseIconPrefferedDate(){
        clickWithWait(ClickingCloseIcon);
        System.out.println("Successfully clicked the close icon in the Preffered Date Dropdown ");
    }

    // Method to handle Time Slot selection
    protected void TimeSlot() throws InterruptedException {
        ClickingTheTimeSlot(); // Open time slot
        ClickingTimeSlotDropdown(); // Close dropdown
        ClickingTheTimeSlot(); // Open time slot
        ClickingTheTimeSlotBottomSheet();
    }

    protected void ClickingTheTimeSlot() throws InterruptedException {
        System.out.println("Entering to the Time Slot");
        Thread.sleep(3000);
        System.out.println("wait to the Time Slot");
        click(TimeSlot);
        System.out.println("Successfully clicked the Time Slot");
    }

    // Click Time Slot field
    protected void ClickingTheTimeSlotBottomSheet() throws InterruptedException {
        Thread.sleep(1000);
        clickWithWait(ClickingTimeSlotBottomSheetdata);
        System.out.println("Successfully clicked the Time Slot");
    }

    // Close Time Slot popup
    protected void ClickingTimeSlotDropdown(){
        clickWithWait(ClickingCloseIconTimeSlot);
        System.out.println("Successfully clicked the Closed Time Slot bottom sheet data");
    }

    // Click Proceed button
    protected void ClickingTheProceedButton(){
        clickWithWait(ProceedButton);
        System.out.println("Successfully clicked the Proceed button");
    }

    protected void TransferSummaryActions(){
        ClickingBackButton(); // Back Button
        ClickingTheProceedButton();
//        DelevieryInstructionActions(); //Delivery Instruction Screen Actions
        TermsAndConditionsActions(); //Terms & Conditions Actions
    }

    protected void DelevieryInstructionActions(){
        DeliveryInstructions();
        clickingCloseIconInDeliveryInstructionsBottomSheet();
        DeliveryInstructions();
        ClickingDeleveryInstructionBottomSheetValue();
    }

    protected void DeliveryInstructions(){
        clickWithWait(DeliveryInstruction);
        System.out.println("Successfully clicked the Delivery Instructions");
    }

    protected void ClickingDeleveryInstructionBottomSheetValue(){
        clickWithWait(ClickingDeliveryInstructionBottonSheet);
        System.out.println("Successfully clicked the Delivery Instruction BottomSheet Value");
    }

    protected void clickingCloseIconInDeliveryInstructionsBottomSheet(){
        clickWithWait(ClickingCloseIconInDelevieryInstructionsBottomsheet);
        System.out.println("Successfully clicked the Close Icon In Delivery Instructions BottomSheet");
    }

    protected void TermsAndConditionsActions(){
        TermsAndConditionsTransferSummary();
        ClickingCloseIconInTermsAndConditionsModal();
        TermsAndConditionsTransferSummary();
        ClickingOkButtonInTermsAndConditionsModal();
        ClickingTermsAndConditionCheckBox();
        ClickingPayButton();
    }

    protected void TermsAndConditionsTransferSummary(){
        clickWithWait(TransferSummaryTermsAndConditions);
        System.out.println("Successfully clicked the TermsAndConditions");
    }

    protected void ClickingCloseIconInTermsAndConditionsModal(){
        clickWithWait(ClickingCloseIconInTermsAndConditionsModal);
        System.out.println("Successfully clicked the Close Icon In Terms And Conditions Modal ");
    }

    protected void ClickingOkButtonInTermsAndConditionsModal(){
        clickWithWait(ClickingOkButtonInTermsAndConditionsModal);
        System.out.println("Successfully clicked the Ok Button In Terms And Conditions Modal ");
    }

    protected void ClickingTermsAndConditionCheckBox() {
        clickWithWait(ClickingCheckBoxInTermsAndConditions);
        System.out.println("Successfully clicked Terms And Condition CheckBox");
    }

    protected void ClickingBackButton() {
        clickWithWait(ClickingBackButton);
        System.out.println("Successfully clicked the Back Button");
    }

    protected void ClickingPayButton(){
        clickWithWait(ClickingThePayButton);
        System.out.println("Successfully clicked the Pay Button");
    }

    // Calling The Knet Page Here To Do Transaction
    protected void KentPage() throws InterruptedException {
        Thread.sleep(5000);
        KnetPaymentGateway knet = new KnetPaymentGateway();
        knet.KnetActions();
        TransactionReceipt();
        System.out.println("Successfully Completed the Knet Payment");

    }

    protected void TransactionReceipt() throws InterruptedException {
        Thread.sleep(5000);
        Transaction_Receipt transactionReceipt = new Transaction_Receipt();
        transactionReceipt.TransactionReceiptActions();
        System.out.println("Successfully Completed the Transaction Receipt");
    }
    
}