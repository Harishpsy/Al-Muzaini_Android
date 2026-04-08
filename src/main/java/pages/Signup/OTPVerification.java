package pages.Signup;

import base.BasePage;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OTPVerification extends BasePage {

    private final By OTP_FIELDS = By.xpath("//android.widget.EditText");
    private final By RESEND_OTP_BUTTON = By.xpath("//android.widget.TextView[@text=\"Resend OTP\"]");
    private final By VERIFY_BUTTON = By.xpath("//android.view.ViewGroup[@content-desc=\"Verify\"]");

    public OTPVerification() {
        super();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void OTPActions(String otp1, String otp2, String otp3, String otp4) throws InterruptedException {
//        Thread.sleep(150000);
//        clickResendOTP();
        Thread.sleep(15000);
        enterOTP(otp1, otp2, otp3, otp4);
        clickVerify();
    }

    public void enterOTP(String otp1, String otp2, String otp3, String otp4) throws InterruptedException {
        List<WebElement> otpFields = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(OTP_FIELDS));
        String[] otpDigits = {otp1, otp2, otp3, otp4};

        for (int i = 0; i < 4; i++) {
            WebElement field = otpFields.get(i);
            wait.until(ExpectedConditions.elementToBeClickable(field));
               field.click();
            field.sendKeys(otpDigits[i]);
            // Press Enter (tick) after entering OTP
//            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
        }
        // Hiding the keyboard after entering the OTP
        hideKeyboard();
        System.out.println("Entered OTP successfully using separate digits");
    }

    public void clickResendOTP() {
        click(RESEND_OTP_BUTTON);
        System.out.println("Resend OTP button clicked");
    }

    public void clickVerify() {
        click(VERIFY_BUTTON);
        System.out.println("Verify button clicked");
    }


}
