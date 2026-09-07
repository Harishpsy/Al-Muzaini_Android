package helpers;

import base.BasePage;
import org.openqa.selenium.By;

/**
 * InputHelper — Low-level reusable field interaction helpers.
 *
 * Provides common input patterns used across all modules (Signup, Transfer,
 * FX Booking, Bill Pay, etc.). Extend this class or inject it wherever
 * you need basic field-level actions without duplicating logic per page.
 *
 * Usage:
 *   InputHelper helper = new InputHelper();
 *   helper.enterText(LOCATOR, "value");
 *   helper.enterAmount(AMOUNT_LOCATOR, "250");
 */
public class InputHelper extends BasePage {

    public InputHelper() {
        super();
    }

    // ==========================================
    // Basic Text Entry
    // ==========================================

    /**
     * Clicks a field and types the given text. Clears existing content first.
     *
     * @param locator  The By locator of the target field
     * @param value    Text to enter
     */
    public void enterText(By locator, String value) {
        click(locator);
        sendKeys(locator, value);
        System.out.println("[InputHelper] Entered text '" + value + "' into: " + locator);
    }

    /**
     * Clicks a field, types the given text, then hides the keyboard.
     *
     * @param locator  The By locator of the target field
     * @param value    Text to enter
     */
    public void enterTextAndHideKeyboard(By locator, String value) {
        click(locator);
        sendKeys(locator, value);
        hideKeyboard();
        System.out.println("[InputHelper] Entered text with keyboard dismissed '" + value + "' into: " + locator);
    }

    /**
     * Scrolls to the end of the scrollable view, then enters text into the field.
     * Useful for fields at the bottom of long forms.
     *
     * @param locator  The By locator of the target field
     * @param value    Text to enter
     */
    public void enterTextWithScroll(By locator, String value) {
        scrollToEnd();
        click(locator);
        sendKeys(locator, value);
        System.out.println("[InputHelper] Scrolled then entered '" + value + "' into: " + locator);
    }

    /**
     * Scrolls to end, enters text, then hides keyboard.
     *
     * @param locator  The By locator of the target field
     * @param value    Text to enter
     */
    public void enterTextWithScrollAndHideKeyboard(By locator, String value) {
        scrollToEnd();
        click(locator);
        sendKeys(locator, value);
        hideKeyboard();
        System.out.println("[InputHelper] Scrolled, entered, and dismissed keyboard '" + value + "' into: " + locator);
    }

    // ==========================================
    // Amount / Numeric Entry
    // ==========================================

    /**
     * Enters a numeric amount into the specified field and hides the keyboard.
     * Validates that the amount is non-null and non-empty before entering.
     *
     * @param locator  The By locator of the amount field
     * @param amount   Numeric amount as String (e.g., "250", "1000.5")
     */
    public String enterAmount(By locator, String amount) {
        if (amount == null || amount.trim().isEmpty()) {
            throw new IllegalArgumentException("[InputHelper] Amount value cannot be null or empty.");
        }
        click(locator);
        sendKeys(locator, amount.trim());
        hideKeyboard();
        System.out.println("[InputHelper] Entered amount '" + amount + "' into: " + locator);
        return amount.trim();
    }

    /**
     * Enters a numeric amount and presses the keyboard OK/Done button.
     *
     * @param locator  The By locator of the amount field
     * @param amount   Numeric amount as String
     */
    public String enterAmountAndConfirm(By locator, String amount) {
        if (amount == null || amount.trim().isEmpty()) {
            throw new IllegalArgumentException("[InputHelper] Amount value cannot be null or empty.");
        }
        click(locator);
        sendKeys(locator, amount.trim());
        KeyboardOkButton();
        System.out.println("[InputHelper] Entered amount and confirmed '" + amount + "' into: " + locator);
        return amount.trim();
    }

    // ==========================================
    // Dropdown / Picker Selection
    // ==========================================

    /**
     * Opens a dropdown and selects an item from the list.
     *
     * @param dropdownLocator  Locator of the dropdown/picker trigger
     * @param optionLocator    Locator of the specific item to select
     */
    public void selectFromDropdown(By dropdownLocator, By optionLocator) {
        click(dropdownLocator);
        click(optionLocator);
        System.out.println("[InputHelper] Selected option from dropdown: " + optionLocator);
    }

    /**
     * Opens a dropdown, dismisses the close icon if it appears, reopens,
     * and selects an item. Handles the common Al-Muzaini bottom-sheet pattern.
     *
     * @param dropdownLocator  Locator of the dropdown/picker trigger
     * @param closeIconLocator Locator of the close icon (to dismiss any overlay)
     * @param optionLocator    Locator of the specific item to select
     */
    public void selectFromDropdownWithCloseHandling(By dropdownLocator, By closeIconLocator, By optionLocator) {
        click(dropdownLocator);
        click(closeIconLocator);
        click(dropdownLocator);
        click(optionLocator);
        System.out.println("[InputHelper] Selected option with close handling: " + optionLocator);
    }

    // ==========================================
    // OTP Entry
    // ==========================================

    /**
     * Enters 4 individual OTP digits into separate fields.
     *
     * @param otp1Locator  Locator for OTP digit 1
     * @param otp2Locator  Locator for OTP digit 2
     * @param otp3Locator  Locator for OTP digit 3
     * @param otp4Locator  Locator for OTP digit 4
     * @param d1           Digit 1 value
     * @param d2           Digit 2 value
     * @param d3           Digit 3 value
     * @param d4           Digit 4 value
     */
    public void enterOtp(By otp1Locator, By otp2Locator, By otp3Locator, By otp4Locator,
                         String d1, String d2, String d3, String d4) {
        sendKeys(otp1Locator, d1);
        sendKeys(otp2Locator, d2);
        sendKeys(otp3Locator, d3);
        sendKeys(otp4Locator, d4);
        System.out.println("[InputHelper] Entered OTP: " + d1 + d2 + d3 + d4);
    }

    /**
     * Enters OTP as a single combined string into one field.
     *
     * @param locator  Locator of the OTP field
     * @param otpCode  Full OTP code (e.g., "1234")
     */
    public void enterOtpSingleField(By locator, String otpCode) {
        click(locator);
        sendKeys(locator, otpCode);
        System.out.println("[InputHelper] Entered OTP (single field): " + otpCode);
    }
}
