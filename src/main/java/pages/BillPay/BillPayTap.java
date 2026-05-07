package pages.BillPay;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import java.time.Duration;

public class BillPayTap extends BasePage {

    private final By ClickingBillPay = new AppiumBy.ByAccessibilityId("Bill Pay");
    private final By ClickingGuideTour = By.className("android.view.View");

    public void BillPayActions() throws InterruptedException {
        BillPayTapping();
        BillPayGuideTour();
    }

    protected void BillPayTapping() throws InterruptedException {
//        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
         clickWithWait(ClickingBillPay);

    }

    // Method to handle guide tour popup by clicking multiple times
    protected void BillPayGuideTour() {
        for(int i = 0; i < 6; i++) { // Loop for max 6 steps
            try {
                clickWithWait(ClickingGuideTour); // Click guide tour overlay
            } catch (Exception e) { // Break if no more steps
                System.out.println("Guide Tour stopped at step " + (i + 1));
                break;
            }
        }
    }
}
