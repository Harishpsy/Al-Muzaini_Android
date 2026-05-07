package pages.BillPay;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class PayBills_BharatConnect extends BasePage {

    private final By ClubAndAssociations= By.xpath("//android.view.ViewGroup[@content-desc=\"Clubs and Associations\"]");
    private final By BillerName= new AppiumBy.ByAccessibilityId("Madhya Pradesh Chamber Of Commerce And Industry test");
    private final By SerialNo =new AppiumBy.ByAccessibilityId("Serial No*");
    private final By EnteringSerialNo = By.xpath("//android.widget.EditText[@text=\"Enter Serial No\"]");
    private final By GroupNo=new AppiumBy.ByAccessibilityId("Group No*");
    private final By EnteringGroupNo = By.xpath("//android.widget.EditText[@text=\"Enter Group No\"]");
    private final By FirstName = new AppiumBy.ByAccessibilityId("First Name*");
    private final By EnteringFirstName = By.xpath("//android.widget.EditText[@text=\"First Name\"]");
    private final By LastName = new AppiumBy.ByAccessibilityId("Last Name*");
    private final By EnteringLastName = By.xpath("//android.widget.EditText[@text=\"Last Name\"]");
    private final By RegisteredMobileNo = By.xpath("//android.view.ViewGroup[@content-desc=\"Registered Mobile Number*\"]/android.view.ViewGroup[1]");
    private final By EnteringRegisteredMobileNo = By.xpath("//android.widget.EditText[@text=\"Registered Mobile Number\"]");
    private final By PurposeOfTransfer= By.xpath("//android.widget.TextView[@text=\"Purpose of Transfer*\"]");
    private final By SelectingPurposeOfTransfer= new AppiumBy.ByAccessibilityId("College fees");
    private final By ViewBill = new AppiumBy.ByAccessibilityId("View Bill");

    public void ClubAndAssociationsCommonActions() throws InterruptedException {
        Thread.sleep(5000);
        clickingClubAndAssociations();
        clickingBillerName();
        clickingSerialNo();
        clickingGroupNo();
        clickingFirstName();
        clickingLastName();
        clickingRegisteredMobileNo();
        clickingPurposeOfTransfer();
        selectingPurposeOfTransfer();
        clickingViewBill();
        Thread.sleep(3000);
        NavigateBack();
        NavigateBack();
        NavigateBack();

    }

    protected void clickingClubAndAssociations(){
        clickWithWait(ClubAndAssociations);
    }

    protected void clickingBillerName(){
       clickWithWait(BillerName);
    }

    protected void clickingSerialNo(){
       clickWithWait(SerialNo);
       sendKeys(EnteringSerialNo, "21");
       System.out.println("Entering Serial No");
    }

    protected void clickingGroupNo(){
        clickWithWait(GroupNo);
        sendKeys(EnteringGroupNo, "31");
        System.out.println("Entering Group No");

    }

    protected void clickingFirstName (){
        clickWithWait(FirstName);
        sendKeys(EnteringFirstName, "John");
        System.out.println("Entering First Name");
    }

    protected void clickingLastName (){
        clickWithWait(LastName);
        sendKeys(EnteringLastName, "Doe");
        ((AndroidDriver) driver).hideKeyboard();
        System.out.println("Entering Last Name");
    }

    protected void clickingRegisteredMobileNo() throws InterruptedException {
        Thread.sleep(3000);
        clickWithWait(RegisteredMobileNo);
        sendKeys(EnteringRegisteredMobileNo, "12345678860");
        ((AndroidDriver) driver).hideKeyboard();
        System.out.println("Entering Registered Mobile No");
    }

    protected void clickingPurposeOfTransfer() throws InterruptedException {
        Thread.sleep(3000);
        clickWithWait(PurposeOfTransfer);
        System.out.println("Successfully Clicked Purpose of Transfer");
    }

    protected void selectingPurposeOfTransfer(){
        clickWithWait(SelectingPurposeOfTransfer);
        System.out.println("Successfully  Selecting Purpose of Transfer");
    }

    protected void clickingViewBill() {
        clickWithWait(ViewBill);
        System.out.println("Successfully Clicked View Bill");
    }

}
