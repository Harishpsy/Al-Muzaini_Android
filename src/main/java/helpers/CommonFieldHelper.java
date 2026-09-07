package helpers;

import org.openqa.selenium.By;

/**
 * CommonFieldHelper — Ready-to-call helper methods for all common form fields.
 *
 * This class combines FieldDataHelper (smart data resolver) and InputHelper
 * (field interaction) into a single point of entry that any page class can use.
 *
 * It handles two things automatically:
 *   1. If the value from test data (Excel/DataProvider) is populated → uses that value.
 *   2. If the value is empty/blank/AUTO/RANDOM → auto-generates realistic, unique data.
 *
 * Designed to be the "go-to" helper for any module: Signup, Transfer, FX Booking,
 * Bill Pay, or any upcoming modules.
 *
 * ─────────────────────────────────────────────────────────────────────────────
 * USAGE EXAMPLE — inside a Page class:
 *
 *   CommonFieldHelper helper = new CommonFieldHelper();
 *
 *   // From DataProvider row (String from Excel):
 *   helper.enterFirstName(FIRST_NAME_LOCATOR, excelFirstName);
 *   helper.enterMobileNumber(MOBILE_LOCATOR, excelMobile);
 *   helper.enterAmount(AMOUNT_LOCATOR, excelAmount);
 *
 *   // Auto-generate everything (leave params empty or "AUTO"):
 *   helper.enterEmail(EMAIL_LOCATOR, "", firstName, lastName);
 * ─────────────────────────────────────────────────────────────────────────────
 */
public class CommonFieldHelper extends InputHelper {

    public CommonFieldHelper() {
        super();
    }

    // ==========================================
    // Personal Details
    // ==========================================

    /**
     * Resolves and enters First Name.
     * Auto-generates if value is empty/blank.
     *
     * @param locator  Locator of the First Name field
     * @param value    Value from test data (or empty string / "AUTO")
     * @return         The actual value entered (useful for chaining with email/username)
     */
    public String enterFirstName(By locator, String value) {
        String resolved = FieldDataHelper.resolveFirstName(value);
        click(locator);
        sendKeys(locator, resolved);
        return resolved;
    }

    /**
     * Resolves and enters Middle Name.
     * Auto-generates if value is empty/blank.
     *
     * @param locator  Locator of the Middle Name field
     * @param value    Value from test data (or empty string / "AUTO")
     * @return         The actual value entered
     */
    public String enterMiddleName(By locator, String value) {
        String resolved = FieldDataHelper.resolveMiddleName(value);
        click(locator);
        sendKeys(locator, resolved);
        return resolved;
    }

    /**
     * Resolves and enters Last Name.
     * Auto-generates if value is empty/blank.
     *
     * @param locator  Locator of the Last Name field
     * @param value    Value from test data (or empty string / "AUTO")
     * @return         The actual value entered
     */
    public String enterLastName(By locator, String value) {
        String resolved = FieldDataHelper.resolveLastName(value);
        click(locator);
        sendKeys(locator, resolved);
        return resolved;
    }

    // ==========================================
    // Contact & Identity
    // ==========================================

    /**
     * Resolves and enters Kuwait Mobile Number.
     * Generates a valid 8-digit Kuwait mobile (5x/6x/9x) if empty.
     *
     * @param locator  Locator of the Mobile Number field
     * @param value    Value from test data (or empty string / "AUTO")
     * @return         The actual value entered
     */
    public String enterMobileNumber(By locator, String value) {
        String resolved = FieldDataHelper.resolveMobile(value);
        click(locator);
        sendKeys(locator, resolved);
        return resolved;
    }

    /**
     * Resolves and enters WhatsApp Number.
     * Falls back to mobileValue if empty.
     *
     * @param locator       Locator of the WhatsApp Number field
     * @param value         Value from test data
     * @param mobileValue   Already resolved mobile number (used as fallback)
     * @return              The actual value entered
     */
    public String enterWhatsappNumber(By locator, String value, String mobileValue) {
        String resolved = FieldDataHelper.resolveWhatsappNumber(value, mobileValue);
        scrollToEnd();
        click(locator);
        sendKeys(locator, resolved);
        hideKeyboard();
        return resolved;
    }

    /**
     * Resolves and enters Civil ID / ID Number.
     * Generates a valid 12-digit Kuwait Civil ID if empty.
     *
     * @param locator  Locator of the ID Number field
     * @param value    Value from test data (or empty string / "AUTO")
     * @return         The actual value entered
     */
    public String enterCivilId(By locator, String value) {
        String resolved = FieldDataHelper.resolveCivilId(value);
        click(locator);
        sendKeys(locator, resolved);
        return resolved;
    }

    /**
     * Resolves and enters Email Address.
     * Generates a unique email (e.g., ahmed.alotaibi1234@mailinator.com) if empty.
     *
     * @param locator    Locator of the Email field
     * @param value      Value from test data (or empty string / "AUTO")
     * @param firstName  Used for email prefix when auto-generating
     * @param lastName   Used for email prefix when auto-generating
     * @return           The actual value entered
     */
    public String enterEmail(By locator, String value, String firstName, String lastName) {
        String resolved = FieldDataHelper.resolveEmail(value, firstName, lastName);
        click(locator);
        sendKeys(locator, resolved);
        hideKeyboard();
        return resolved;
    }

    // ==========================================
    // Account Credentials
    // ==========================================

    /**
     * Resolves and enters Username.
     * Generates a unique username (e.g., ahmed_49201) if empty.
     *
     * @param locator    Locator of the Username field
     * @param value      Value from test data (or empty string / "AUTO")
     * @param firstName  Used as prefix when auto-generating username
     * @return           The actual value entered
     */
    public String enterUsername(By locator, String value, String firstName) {
        String resolved = FieldDataHelper.resolveUsername(value, firstName);
        click(locator);
        sendKeys(locator, resolved);
        return resolved;
    }

    /**
     * Resolves and enters Password.
     * Defaults to a strong auto-generated password if empty.
     *
     * @param locator  Locator of the Password field
     * @param value    Value from test data (or empty string / "AUTO")
     * @return         The actual password entered (needed to sync Confirm Password)
     */
    public String enterPassword(By locator, String value) {
        String resolved = FieldDataHelper.resolvePassword(value);
        click(locator);
        sendKeys(locator, resolved);
        return resolved;
    }

    /**
     * Resolves and enters Confirm Password.
     * Syncs to resolvedPassword if empty.
     *
     * @param locator           Locator of the Confirm Password field
     * @param value             Value from test data (or empty string)
     * @param resolvedPassword  The already-resolved password to sync with
     * @return                  The actual value entered
     */
    public String enterConfirmPassword(By locator, String value, String resolvedPassword) {
        String resolved = FieldDataHelper.resolveConfirmPassword(value, resolvedPassword);
        click(locator);
        sendKeys(locator, resolved);
        return resolved;
    }

    // ==========================================
    // Financial
    // ==========================================

    /**
     * Resolves and enters a monetary Amount.
     * Generates a sensible test amount if empty.
     * Hides keyboard after entry.
     *
     * @param locator  Locator of the Amount field
     * @param value    Amount value from test data (or empty / "AUTO")
     * @return         The actual amount entered
     */
    public String enterAmount(By locator, String value) {
        String resolved = FieldDataHelper.resolveAmount(value);
        click(locator);
        sendKeys(locator, resolved);
        hideKeyboard();
        System.out.println("[CommonFieldHelper] Entered amount: " + resolved);
        return resolved;
    }

    /**
     * Resolves and enters Monthly Income.
     * Generates a realistic income if empty.
     *
     * @param locator  Locator of the Monthly Income field
     * @param value    Value from test data (or empty / "AUTO")
     * @return         The actual value entered
     */
    public String enterMonthlyIncome(By locator, String value) {
        String resolved = FieldDataHelper.resolveMonthlyIncome(value);
        click(locator);
        sendKeys(locator, resolved);
        return resolved;
    }

    /**
     * Resolves and enters Employer/Employee Name.
     * Generates a realistic employer name if empty.
     *
     * @param locator  Locator of the Employer field
     * @param value    Value from test data (or empty / "AUTO")
     * @return         The actual value entered
     */
    public String enterEmployerName(By locator, String value) {
        String resolved = FieldDataHelper.resolveEmployerName(value);
        click(locator);
        sendKeys(locator, resolved);
        return resolved;
    }

    // ==========================================
    // OTP
    // ==========================================

    /**
     * Resolves and enters 4 individual OTP digits into separate fields.
     * Defaults to "1", "2", "3", "4" if values are empty.
     *
     * @param otp1Locator  Locator for OTP digit 1
     * @param otp2Locator  Locator for OTP digit 2
     * @param otp3Locator  Locator for OTP digit 3
     * @param otp4Locator  Locator for OTP digit 4
     * @param d1           Digit 1 from test data
     * @param d2           Digit 2 from test data
     * @param d3           Digit 3 from test data
     * @param d4           Digit 4 from test data
     */
    public void enterOtpDigits(By otp1Locator, By otp2Locator, By otp3Locator, By otp4Locator,
                               String d1, String d2, String d3, String d4) {
        sendKeys(otp1Locator, FieldDataHelper.resolveOtpDigit(d1, "1"));
        sendKeys(otp2Locator, FieldDataHelper.resolveOtpDigit(d2, "2"));
        sendKeys(otp3Locator, FieldDataHelper.resolveOtpDigit(d3, "3"));
        sendKeys(otp4Locator, FieldDataHelper.resolveOtpDigit(d4, "4"));
        System.out.println("[CommonFieldHelper] Entered OTP: "
                + FieldDataHelper.resolveOtpDigit(d1, "1")
                + FieldDataHelper.resolveOtpDigit(d2, "2")
                + FieldDataHelper.resolveOtpDigit(d3, "3")
                + FieldDataHelper.resolveOtpDigit(d4, "4"));
    }

    // ==========================================
    // Address Details
    // ==========================================

    /**
     * Resolves and enters Block number.
     * Generates a random block (1-12) if empty.
     */
    public String enterBlock(By locator, String value) {
        String resolved = FieldDataHelper.resolveBlock(value);
        click(locator);
        sendKeys(locator, resolved);
        return resolved;
    }

    /**
     * Resolves and enters Street name.
     * Generates a realistic Kuwait street name if empty.
     */
    public String enterStreet(By locator, String value) {
        String resolved = FieldDataHelper.resolveStreet(value);
        click(locator);
        sendKeys(locator, resolved);
        return resolved;
    }

    /**
     * Resolves and enters Building number.
     * Generates a random building number (1-50) if empty.
     */
    public String enterBuilding(By locator, String value) {
        String resolved = FieldDataHelper.resolveBuilding(value);
        click(locator);
        sendKeys(locator, resolved);
        return resolved;
    }

    /**
     * Resolves and enters Floor number.
     * Generates a random floor (1-15) if empty.
     */
    public String enterFloor(By locator, String value) {
        String resolved = FieldDataHelper.resolveFloor(value);
        click(locator);
        sendKeys(locator, resolved);
        return resolved;
    }

    /**
     * Resolves and enters Flat number.
     * Generates a random flat (1-30) if empty and hides keyboard.
     */
    public String enterFlat(By locator, String value) {
        String resolved = FieldDataHelper.resolveFlat(value);
        click(locator);
        sendKeys(locator, resolved);
        hideKeyboard();
        return resolved;
    }
}
