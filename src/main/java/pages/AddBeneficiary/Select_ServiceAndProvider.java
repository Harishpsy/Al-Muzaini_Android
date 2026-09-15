package pages.AddBeneficiary;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.*;

public class Select_ServiceAndProvider extends BasePage {

    Select_CountryAndCurrency CallingContinueButton = new Select_CountryAndCurrency();

    // Service Type
    private final By BankTransfer = new AppiumBy.ByAccessibilityId("Bank Transfer");
    private final By Cash_pick_up = new AppiumBy.ByAccessibilityId("Cash Pick Up");
    private final By MobileWallet = new AppiumBy.ByAccessibilityId("Mobile Wallet");

    // Service Provider For Cash Pickup
    private final By BracBank = new AppiumBy.ByAccessibilityId("BRAC BANK");

    // Service Type and Service Provider Common Actions
    public void SelectServiceAndProviderCommonActions(){
        ClickingCashPickup();
        ClickingBracBank();
        ClickingContinueButton();
    }

    // Bank Transfer
    protected void ClickingBankTransfer(){
        clickWithWait(BankTransfer);
    }
    // Cash pick up
    protected void ClickingCashPickup(){
        clickWithWait(Cash_pick_up);
    }
    // Mobile wallet
    protected void ClickingMobileWallet(){
        clickWithWait(MobileWallet);
    }
    // Service Provider - BracBank
    protected void ClickingBracBank(){
        scrollWithClick(BracBank);
    }
    // Clicking Continue button
    protected void ClickingContinueButton(){
        CallingContinueButton.ClickingContinueButton();
    }















}
