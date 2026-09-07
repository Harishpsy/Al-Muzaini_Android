package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.DataGeneratorUtils;

import java.util.function.Supplier;

/**
 * FieldDataHelper — Smart data resolver for all form fields.
 *
 * For each field type, checks whether a test data value is present:
 *   - If the value exists in Excel / was explicitly provided  → use it as-is.
 *   - If the value is null, blank, "AUTO", or "RANDOM"        → auto-generate valid data.
 *
 * This ensures no two test runs produce duplicate user accounts, mobile numbers,
 * or email addresses, while still allowing pinned values for regression tests.
 *
 * Usage:
 *   String firstName = FieldDataHelper.resolveFirstName(excelValue);
 *   String mobile    = FieldDataHelper.resolveMobile(excelValue);
 *   String email     = FieldDataHelper.resolveEmail(excelValue, firstName, lastName);
 */
public final class FieldDataHelper {

    private static final Logger logger = LogManager.getLogger(FieldDataHelper.class);

    private FieldDataHelper() {
        // Utility class — no instantiation needed
    }

    // ==========================================
    // Core Resolver
    // ==========================================

    /**
     * Core resolution logic.
     * If rawValue is empty/blank/token → calls the generator Supplier.
     * Otherwise returns rawValue as-is.
     *
     * @param rawValue  Value from Excel or test data (can be null / blank)
     * @param fieldName Human-readable field name for logging
     * @param generator Lambda/method-reference that generates a valid value
     * @return Resolved string value (never null or blank)
     */
    public static String resolve(String rawValue, String fieldName, Supplier<String> generator) {
        if (DataGeneratorUtils.isCellEmpty(rawValue)) {
            String generated = generator.get();
            String msg = "[FieldDataHelper] '" + fieldName + "' is empty → Auto-generated: " + generated;
            logger.info(msg);
            System.out.println(msg);
            return generated;
        }
        return rawValue.trim();
    }

    // ==========================================
    // Personal Details
    // ==========================================

    /**
     * Resolves First Name — generates a realistic name if empty.
     */
    public static String resolveFirstName(String raw) {
        return resolve(raw, "First Name", DataGeneratorUtils::generateFirstName);
    }

    /**
     * Resolves Middle Name — generates a realistic name if empty.
     */
    public static String resolveMiddleName(String raw) {
        return resolve(raw, "Middle Name", DataGeneratorUtils::generateMiddleName);
    }

    /**
     * Resolves Last Name — generates a realistic name if empty.
     */
    public static String resolveLastName(String raw) {
        return resolve(raw, "Last Name", DataGeneratorUtils::generateLastName);
    }

    /**
     * Resolves Date of Birth — generates a random DOB (adult, 20-50 years) if empty.
     */
    public static String resolveDateOfBirth(String raw) {
        return resolve(raw, "Date of Birth", DataGeneratorUtils::generateDateOfBirth);
    }

    // ==========================================
    // Contact & Identity
    // ==========================================

    /**
     * Resolves Kuwait Mobile Number (8 digits, starting with 5, 6, or 9).
     */
    public static String resolveMobile(String raw) {
        return resolve(raw, "Mobile Number", DataGeneratorUtils::generateKuwaitMobileNumber);
    }

    /**
     * Resolves WhatsApp number. Falls back to mobileValue if both raw and mobileValue are populated;
     * if raw is empty, uses the already-resolved mobileValue.
     *
     * @param raw         Raw WhatsApp value from test data
     * @param mobileValue Already resolved mobile number to use as fallback
     */
    public static String resolveWhatsappNumber(String raw, String mobileValue) {
        if (DataGeneratorUtils.isCellEmpty(raw)) {
            String msg = "[FieldDataHelper] 'WhatsApp Number' is empty → Using Mobile Number: " + mobileValue;
            logger.info(msg);
            System.out.println(msg);
            return mobileValue;
        }
        return raw.trim();
    }

    /**
     * Resolves Kuwait Civil ID (12 digits, modulo-11 valid).
     */
    public static String resolveCivilId(String raw) {
        return resolve(raw, "Civil ID", DataGeneratorUtils::generateKuwaitCivilId);
    }

    /**
     * Resolves Email — generates a unique email combining first + last name with a suffix.
     *
     * @param raw       Raw email from test data
     * @param firstName Already resolved first name (for generated email prefix)
     * @param lastName  Already resolved last name (for generated email prefix)
     */
    public static String resolveEmail(String raw, String firstName, String lastName) {
        return resolve(raw, "Email", () -> DataGeneratorUtils.generateEmail(firstName, lastName));
    }

    // ==========================================
    // Account Credentials
    // ==========================================

    /**
     * Resolves Username — generates a unique username using first name if empty.
     *
     * @param raw       Raw username from test data
     * @param firstName Already resolved first name (used as prefix for generated username)
     */
    public static String resolveUsername(String raw, String firstName) {
        return resolve(raw, "Username", () -> DataGeneratorUtils.generateUsername(firstName));
    }

    /**
     * Resolves Password — defaults to "Test@1234" if empty.
     */
    public static String resolvePassword(String raw) {
        return resolve(raw, "Password", DataGeneratorUtils::generateStrongPassword);
    }

    /**
     * Resolves Confirm Password — syncs to resolvedPassword if raw is empty.
     *
     * @param raw              Raw confirm-password from test data
     * @param resolvedPassword Already resolved main password value
     */
    public static String resolveConfirmPassword(String raw, String resolvedPassword) {
        if (DataGeneratorUtils.isCellEmpty(raw)) {
            return resolvedPassword;
        }
        return raw.trim();
    }

    // ==========================================
    // Financial
    // ==========================================

    /**
     * Resolves a monetary amount — auto-generates a sensible amount if empty.
     * Default generated values: realistic transfer amounts (e.g., 50, 100, 250).
     *
     * @param raw  Raw amount string from test data
     */
    public static String resolveAmount(String raw) {
        return resolve(raw, "Amount", () -> {
            int[] amounts = {50, 100, 150, 250, 500};
            return String.valueOf(amounts[(int) (Math.random() * amounts.length)]);
        });
    }

    /**
     * Resolves Monthly Income — generates a realistic income if empty.
     */
    public static String resolveMonthlyIncome(String raw) {
        return resolve(raw, "Monthly Income", DataGeneratorUtils::generateMonthlyIncome);
    }

    /**
     * Resolves Occupation — generates a realistic occupation if empty.
     */
    public static String resolveOccupation(String raw) {
        return resolve(raw, "Occupation", DataGeneratorUtils::generateOccupation);
    }

    /**
     * Resolves Employer Name — generates a realistic employer if empty.
     */
    public static String resolveEmployerName(String raw) {
        return resolve(raw, "Employer Name", DataGeneratorUtils::generateEmployerName);
    }

    // ==========================================
    // Address Details
    // ==========================================

    /**
     * Resolves Block number — generates a random block (1-12) if empty.
     */
    public static String resolveBlock(String raw) {
        return resolve(raw, "Block", DataGeneratorUtils::generateBlock);
    }

    /**
     * Resolves Street name — generates a random Kuwait street name if empty.
     */
    public static String resolveStreet(String raw) {
        return resolve(raw, "Street", DataGeneratorUtils::generateStreet);
    }

    /**
     * Resolves Building number — generates a random building (1-50) if empty.
     */
    public static String resolveBuilding(String raw) {
        return resolve(raw, "Building", DataGeneratorUtils::generateBuilding);
    }

    /**
     * Resolves Floor number — generates a random floor (1-15) if empty.
     */
    public static String resolveFloor(String raw) {
        return resolve(raw, "Floor", DataGeneratorUtils::generateFloor);
    }

    /**
     * Resolves Flat number — generates a random flat (1-30) if empty.
     */
    public static String resolveFlat(String raw) {
        return resolve(raw, "Flat", DataGeneratorUtils::generateFlat);
    }

    /**
     * Resolves Area / City — generates a random Kuwait area if empty.
     */
    public static String resolveAreaCity(String raw) {
        return resolve(raw, "Area / City", DataGeneratorUtils::generateAreaCity);
    }

    // ==========================================
    // OTP Digits
    // ==========================================

    /**
     * Resolves a single OTP digit — defaults to the given fallback digit if empty.
     *
     * @param raw           Raw OTP digit from test data
     * @param fallbackDigit The default digit to use (e.g., "1", "2")
     */
    public static String resolveOtpDigit(String raw, String fallbackDigit) {
        return DataGeneratorUtils.isCellEmpty(raw) ? fallbackDigit : raw.trim();
    }
}
