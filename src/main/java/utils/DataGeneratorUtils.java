package utils;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * DataGeneratorUtils — Generates realistic, unique, and fully dynamic test data.
 *
 * No hardcoded data arrays. All values are produced algorithmically at runtime:
 *  - Names     : phonetic consonant-vowel patterns (pronounceable, realistic)
 *  - Mobile    : valid Kuwait prefix (5/6/9) + 7 random digits
 *  - Civil ID  : century + YYMMDD + sequence + Modulo-11 checksum
 *  - Email     : name-derived prefix + unique random 4-digit suffix
 *  - Username  : name-derived prefix + random 5-digit suffix
 *  - Password  : compliant strong password with random 4-digit pin
 *  - Amounts   : random within realistic ranges
 *  - Addresses : numeric block/building/floor/flat + alphanumeric street codes
 *  - Employers : dynamic coded company IDs
 *  - Occupations: dynamic coded role IDs
 */
public final class DataGeneratorUtils {

    private static final Random RANDOM = new SecureRandom();

    // Phonetic character sets — NOT data arrays, just algorithm character pools
    private static final char[] CONSONANTS = "bdfhjklmnrstvwyz".toCharArray();
    private static final char[] VOWELS     = "aeiou".toCharArray();

    private DataGeneratorUtils() { }

    // ==========================================
    // Empty Cell Detection
    // ==========================================

    /**
     * Returns true if the value is null, blank, or a placeholder token
     * (AUTO / RANDOM / EMPTY / NULL — case-insensitive).
     */
    public static boolean isCellEmpty(Object value) {
        if (value == null) return true;
        String str = value.toString().trim();
        if (str.isEmpty()) return true;
        String upper = str.toUpperCase();
        return upper.equals("AUTO") || upper.equals("RANDOM")
                || upper.equals("EMPTY") || upper.equals("NULL");
    }

    // ==========================================
    // Name Generation (Phonetic Algorithm)
    // ==========================================

    /**
     * Generates a pronounceable name using alternating consonant-vowel patterns.
     * Every run produces a different name of random length within [minLen, maxLen].
     *
     * Example outputs: "Falid", "Rozan", "Bemika", "Salid", "Tidoha"
     */
    private static String generatePhoneticName(int minLen, int maxLen) {
        int length = minLen + RANDOM.nextInt((maxLen - minLen) + 1);
        StringBuilder name = new StringBuilder(length);

        // Randomly start with either consonant or vowel
        boolean useConsonant = RANDOM.nextBoolean();

        for (int i = 0; i < length; i++) {
            if (useConsonant) {
                name.append(CONSONANTS[RANDOM.nextInt(CONSONANTS.length)]);
            } else {
                name.append(VOWELS[RANDOM.nextInt(VOWELS.length)]);
            }
            useConsonant = !useConsonant; // alternate every character
        }

        // Capitalize first letter
        name.setCharAt(0, Character.toUpperCase(name.charAt(0)));
        return name.toString();
    }

    /**
     * Generates a dynamic First Name (4–7 chars).
     * Examples: "Farid", "Somen", "Badik", "Lomav"
     */
    public static String generateFirstName() {
        return generatePhoneticName(4, 7);
    }

    /**
     * Generates a dynamic Middle Name (4–7 chars).
     */
    public static String generateMiddleName() {
        return generatePhoneticName(4, 7);
    }

    /**
     * Generates a dynamic Last Name (5–9 chars).
     * Examples: "Salidof", "Boramin", "Tamikur"
     */
    public static String generateLastName() {
        return generatePhoneticName(5, 9);
    }

    // ==========================================
    // Contact & Identity
    // ==========================================

    /**
     * Generates a valid 8-digit Kuwait Mobile Number.
     * Prefix: randomly one of 5, 6, or 9 (Kuwait telecom regulation).
     * Remaining 7 digits: fully random.
     * Example: "54831029", "62917483", "91028374"
     */
    public static String generateKuwaitMobileNumber() {
        int[] validPrefixes = {5, 6, 9};
        int prefix    = validPrefixes[RANDOM.nextInt(validPrefixes.length)];
        int remaining = 1000000 + RANDOM.nextInt(9000000); // guarantees exactly 7 digits
        return String.valueOf(prefix) + remaining;
    }

    /**
     * Generates a valid 12-digit Kuwait Civil ID.
     *
     * Algorithm:
     *   Digit  1   : Century indicator — 2 (1900–1999) or 3 (2000–2099)
     *   Digits 2–7 : YYMMDD birth date (algorithmically generated)
     *   Digits 8–11: Random 4-digit sequence number
     *   Digit  12  : Modulo-11 checksum digit (ensures mathematical validity)
     *
     * Every call produces a structurally and mathematically valid Civil ID.
     */
    public static String generateKuwaitCivilId() {
        int birthYear  = 1975 + RANDOM.nextInt(30); // 1975–2004
        int birthMonth = 1 + RANDOM.nextInt(12);
        int birthDay   = 1 + RANDOM.nextInt(28);    // max 28 avoids invalid dates

        int century = (birthYear >= 2000) ? 3 : 2;
        int yy = birthYear % 100;

        String base11 = String.format("%d%02d%02d%02d%04d",
                century, yy, birthMonth, birthDay,
                1000 + RANDOM.nextInt(9000));

        // Kuwait Civil ID Modulo-11 weight array
        int[] weights = {2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            sum += Character.getNumericValue(base11.charAt(i)) * weights[i];
        }
        int checkDigit = (11 - (sum % 11)) % 11;

        // checkDigit == 10 is invalid in Kuwait Civil ID — recurse to regenerate
        if (checkDigit == 10) return generateKuwaitCivilId();

        return base11 + checkDigit;
    }

    /**
     * Generates a unique email.
     * Format: [firstName].[lastName][random4digits]@mailinator.com
     * Example: "falid.salidof4821@mailinator.com"
     */
    public static String generateEmail(String firstName, String lastName) {
        String first = sanitizeForEmail(firstName, "user");
        String last  = sanitizeForEmail(lastName,  "test");
        return first + "." + last + (1000 + RANDOM.nextInt(9000)) + "@mailinator.com";
    }

    /**
     * Generates a unique username.
     * Format: [firstName]_[random 5-digit number]
     * Example: "falid_49201"
     */
    public static String generateUsername(String firstName) {
        String prefix = sanitizeForEmail(firstName, "user");
        return prefix + "_" + (10000 + RANDOM.nextInt(90000));
    }

    /**
     * Generates a strong password.
     * Format: Test@[random 4-digit pin]
     * Example: "Test@4821", "Test@7293"
     */
    public static String generateStrongPassword() {
        return "Test@" + (1000 + RANDOM.nextInt(9000));
    }

    /**
     * Generates a random Date of Birth for an adult aged 20–50.
     * Format: DD-MM-YYYY
     * Example: "14-03-1991", "02-11-2001"
     */
    public static String generateDateOfBirth() {
        int yearsAgo = 20 + RANDOM.nextInt(30);
        LocalDate dob = LocalDate.now()
                .minusYears(yearsAgo)
                .minusDays(RANDOM.nextInt(365));
        return dob.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    // ==========================================
    // Address
    // ==========================================

    /** Random block number: 1–15. */
    public static String generateBlock() {
        return String.valueOf(1 + RANDOM.nextInt(15));
    }

    /**
     * Dynamic street descriptor.
     * Format: Street [1–300][A–E]
     * Example: "Street 47B", "Street 12A", "Street 203E"
     */
    public static String generateStreet() {
        char alpha = (char) ('A' + RANDOM.nextInt(5));
        return "Street " + (1 + RANDOM.nextInt(300)) + alpha;
    }

    /** Random building number: 1–99. */
    public static String generateBuilding() {
        return String.valueOf(1 + RANDOM.nextInt(99));
    }

    /** Random floor number: 1–20. */
    public static String generateFloor() {
        return String.valueOf(1 + RANDOM.nextInt(20));
    }

    /** Random flat number: 1–50. */
    public static String generateFlat() {
        return String.valueOf(1 + RANDOM.nextInt(50));
    }

    /**
     * Dynamic area/city code.
     * Format: Area-[3 random uppercase letters]
     * Example: "Area-KWT", "Area-FRB", "Area-SAX"
     */
    public static String generateAreaCity() {
        StringBuilder code = new StringBuilder(3);
        for (int i = 0; i < 3; i++) {
            code.append((char) ('A' + RANDOM.nextInt(26)));
        }
        return "Area-" + code;
    }

    // ==========================================
    // Employment
    // ==========================================

    /**
     * Dynamic employer/company identifier.
     * Format: Co-[6-char alphanumeric code]
     * Example: "Co-K4B2JX", "Co-R9M1ZQ"
     */
    public static String generateEmployerName() {
        return "Co-" + generateAlphanumericCode(6);
    }

    /**
     * Dynamic occupation/role identifier.
     * Format: Role-[4-char alphanumeric code]
     * Example: "Role-B2KZ", "Role-M7XQ"
     */
    public static String generateOccupation() {
        return "Role-" + generateAlphanumericCode(4);
    }

    /**
     * Random monthly income between 500 and 5000 (increments of 50).
     * Example: "650", "1250", "3450"
     */
    public static String generateMonthlyIncome() {
        int steps = RANDOM.nextInt(91); // 0–90 × 50 = 0–4500 added to base 500
        return String.valueOf(500 + (steps * 50));
    }

    // ==========================================
    // General Utilities
    // ==========================================

    /**
     * Generates a string of N random digits.
     * Example: generateRandomDigits(6) → "482917"
     */
    public static String generateRandomDigits(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(RANDOM.nextInt(10));
        }
        return sb.toString();
    }

    /**
     * Generates a random alphanumeric code using unambiguous characters.
     * Excludes confusing lookalikes: 0/O, 1/I.
     * Example: generateAlphanumericCode(6) → "K4B2JX"
     */
    public static String generateAlphanumericCode(int length) {
        String chars = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(RANDOM.nextInt(chars.length())));
        }
        return sb.toString();
    }

    // ==========================================
    // Private Helpers
    // ==========================================

    private static String sanitizeForEmail(String value, String fallback) {
        if (value == null || value.trim().isEmpty()) return fallback;
        return value.trim().toLowerCase().replaceAll("[^a-z0-9]", "");
    }
}
