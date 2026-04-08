package pages.TransferMoney.Beneficiaries.BankTransfer;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static base.DriverFactory.getDriver;

public class KnetPaymentGateway extends BasePage {

    public KnetPaymentGateway() {
        super();
    }
    public void KnetActions() {
        waitUntilAppReturns();
    }
    //SCANNER METHOD
    private void waitUntilAppReturns() {

        AndroidDriver driver = (AndroidDriver) getDriver();

        System.out.println("👉 Complete KNET payment manually... Waiting for app to return");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(5));

        wait.until(d ->
                driver.getCurrentPackage().equals("com.almuzaini.almuzaini")
        );

        System.out.println("Navigate Back to app. Continuing automation...");
    }
}


//package pages.TransferMoney.Beneficiaries.BankTransfer;
//
//import base.BasePage;
//
//import java.util.Scanner;
//
//public class KnetPaymentGateway extends BasePage {
//
//    public void knetActions() {
//        waitForUserConfirmation();
//    }
//
//    // Manual scanner method
//    private void waitForUserConfirmation() {
//
//        System.out.println("====================================");
//        System.out.println("Complete KNET payment manually.");
//        System.out.println("After clicking Continue, press ENTER to proceed...");
//        System.out.println("====================================");
//
//        Scanner scanner = new Scanner(System.in);
//        scanner.nextLine(); // waits for ENTER
//
//        System.out.println("✅ SOP: ENTER button triggered by user. Continuing automation flow...");
//    }
//
//}

