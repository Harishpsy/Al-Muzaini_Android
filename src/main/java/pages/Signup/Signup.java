package pages.Signup;

import base.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Signup extends BasePage {

    // Constructor
    public Signup() {
        super();
    }
    private final By Login_Difference_Account = By.xpath("//android.widget.TextView[@text='Login Different Account']");
    private final By Signup_Button = By.xpath("//android.widget.TextView[@text=\"Sign Up\"]");

    public void SignupActions() throws InterruptedException {
        LoginDifferentAccount();  // Login different Account
        SignupButton(); // Signup
    }

    // Clicking Login Different Account
    private void LoginDifferentAccount() throws InterruptedException {
        Thread.sleep(15000);
        WebElement loginDifferentAccount = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(Login_Difference_Account));
        loginDifferentAccount.click();
        System.out.println("Successfully clicked the 'Login Different Account' button");
    }

    // Clicking Signup Button
    private void SignupButton() {
        WebElement signUpButton = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(Signup_Button));
        signUpButton.click();
        System.out.println("Successfully clicked the Signup Button");
    }
}
