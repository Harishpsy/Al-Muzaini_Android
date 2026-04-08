package pages.Signup;

import base.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VerifyYourAccount extends BasePage {

    //Constructor
    public VerifyYourAccount(){
        super();
    }

    private final By Enter_Id_Number = By.xpath("//android.widget.EditText[@text='Enter ID Number']");
    private final By Enter_Mobile_Number = By.xpath("//android.widget.EditText[@text='Enter Mobile Number']");
    private final By Continue = By.xpath("//android.view.ViewGroup[@content-desc=\"Continue\"]");

    //Accept values from test class
    public void VerifyYourAccountActions(String idNumber, String mobileNumber) throws InterruptedException {
        EnterIdNumber(idNumber);
        EnterMobileNumber(mobileNumber);
        ClickingContinueButton();
    }

    private void EnterIdNumber(String idNumber) throws InterruptedException {
        WebElement enterIdNumber = new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.visibilityOfElementLocated(Enter_Id_Number));
//        Thread.sleep(3000);
        enterIdNumber.click();
        enterIdNumber.sendKeys(idNumber);
        System.out.println("Entered ID Number: " + idNumber);
    }

    private void EnterMobileNumber(String mobileNumber) {
        WebElement enterMobileNumber = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(Enter_Mobile_Number));
        enterMobileNumber.click();
        enterMobileNumber.sendKeys(mobileNumber);
        System.out.println("Entered Mobile Number: " + mobileNumber);
    }

    private void ClickingContinueButton(){
        WebElement clickingContinue = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(Continue));
        clickingContinue.click();

    }


}
