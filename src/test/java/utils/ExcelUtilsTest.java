package utils;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Dynamic validation for Excel reading and DataProviders.
 * Tests verify structure, column counts, and format integrity (no scientific notation),
 * allowing users to freely modify the values in the Excel files without test failures.
 */
public class ExcelUtilsTest {

    @Test(description = "Verify reading Login.xlsx dynamically")
    public void testReadLoginExcel() {
        List<Object[]> rows = ExcelUtils.getTestData("Login.xlsx");
        Assert.assertFalse(rows.isEmpty(), "Login.xlsx must contain at least one data row");
        for (Object[] row : rows) {
            Assert.assertEquals(row.length, 2, "Login row must have 2 columns (username, password)");
            Assert.assertNotNull(row[0], "Username must not be null");
            Assert.assertNotNull(row[1], "Password must not be null");
            Assert.assertFalse(row[0].toString().trim().isEmpty(), "Username should not be empty");
        }

        // Verify DataProvider returns data
        Iterator<Object[]> dp = DataProviders.getLoginData();
        Assert.assertTrue(dp.hasNext(), "Login data provider must yield test records");
    }

    @Test(description = "Verify reading Signup.xlsx preserves long number formats dynamically")
    public void testReadSignupExcel() {
        List<Object[]> rows = ExcelUtils.getTestData("Signup.xlsx");
        Assert.assertFalse(rows.isEmpty(), "Signup.xlsx must contain at least one data row");
        for (Object[] row : rows) {
            Assert.assertEquals(row.length, 27, "Signup row must have 27 columns");
            // Validate that numeric fields (e.g. Civil ID, mobile) do not get converted to scientific notation
            String civilId = row[0].toString();
            String mobile = row[1].toString();
            Assert.assertFalse(civilId.contains("E+"), "Civil ID should not be formatted in scientific notation");
            Assert.assertFalse(mobile.contains("E+"), "Mobile number should not be formatted in scientific notation");
        }

        // Verify DataProvider
        Iterator<Object[]> dp = DataProviders.getSignupData();
        Assert.assertTrue(dp.hasNext(), "Signup data provider must yield test records");
    }

    @Test(description = "Verify reading BankTransfer.xlsx dynamically")
    public void testReadBankTransferExcel() {
        List<Object[]> rows = ExcelUtils.getTestData("BankTransfer.xlsx");
        Assert.assertFalse(rows.isEmpty(), "BankTransfer.xlsx must contain at least one data row");
        for (Object[] row : rows) {
            Assert.assertEquals(row.length, 3, "BankTransfer row must have 3 columns (YouSend, TheyReceive, ReEnterYouSend)");
            Assert.assertNotNull(row[0], "YouSend must not be null");
            Assert.assertNotNull(row[1], "TheyReceive must not be null");
            Assert.assertNotNull(row[2], "ReEnterYouSend must not be null");
        }

        // Verify DataProvider
        Iterator<Object[]> dp = DataProviders.getBankTransferData();
        Assert.assertTrue(dp.hasNext(), "BankTransfer data provider must yield test records");
    }

    @Test(description = "Verify reading FxBooking.xlsx dynamically")
    public void testReadFxBookingExcel() {
        List<Object[]> rows = ExcelUtils.getTestData("FxBooking.xlsx");
        Assert.assertFalse(rows.isEmpty(), "FxBooking.xlsx must contain at least one data row");
        for (Object[] row : rows) {
            Assert.assertEquals(row.length, 1, "FxBooking row must have 1 column (Amount)");
            Assert.assertNotNull(row[0], "Amount must not be null");
            Assert.assertFalse(row[0].toString().trim().isEmpty(), "Amount should not be empty");
        }

        // Verify DataProvider
        Iterator<Object[]> dp = DataProviders.getFxBookingData();
        Assert.assertTrue(dp.hasNext(), "FxBooking data provider must yield test records");
    }

    @Test(description = "Verify reading BillPay.xlsx dynamically")
    public void testReadBillPayExcel() {
        List<Object[]> rows = ExcelUtils.getTestData("BillPay.xlsx");
        Assert.assertFalse(rows.isEmpty(), "BillPay.xlsx must contain at least one data row");
        for (Object[] row : rows) {
            Assert.assertEquals(row.length, 2, "BillPay row must have 2 columns (mobileNumber, amount)");
            Assert.assertNotNull(row[0], "mobileNumber must not be null");
            Assert.assertNotNull(row[1], "amount must not be null");
            Assert.assertFalse(row[0].toString().contains("E+"), "mobileNumber should not be in scientific notation");
        }

        // Verify DataProvider
        Iterator<Object[]> dp = DataProviders.getBillPayData();
        Assert.assertTrue(dp.hasNext(), "BillPay data provider must yield test records");
    }

    @Test(description = "Verify reading RateCalculator.xlsx dynamically")
    public void testReadRateCalculatorExcel() {
        List<Object[]> rows = ExcelUtils.getTestData("RateCalculator.xlsx");
        Assert.assertFalse(rows.isEmpty(), "RateCalculator.xlsx must contain at least one data row");
        for (Object[] row : rows) {
            Assert.assertEquals(row.length, 3, "RateCalculator row must have 3 columns (fcAmount, lcAmount, currencySearch)");
            Assert.assertNotNull(row[0], "fcAmount must not be null");
            Assert.assertNotNull(row[1], "lcAmount must not be null");
            Assert.assertNotNull(row[2], "currencySearch must not be null");
        }

        // Verify DataProvider
        Iterator<Object[]> dp = DataProviders.getRateCalculatorData();
        Assert.assertTrue(dp.hasNext(), "RateCalculator data provider must yield test records");
    }

    @Test(description = "Verify reading Knet.xlsx dynamically")
    public void testReadKnetExcel() {
        List<Object[]> rows = ExcelUtils.getTestData("Knet.xlsx");
        Assert.assertFalse(rows.isEmpty(), "Knet.xlsx must contain at least one data row");
        for (Object[] row : rows) {
            Assert.assertEquals(row.length, 3, "Knet row must have 3 columns (cardNumber, expiryDate, pin)");
            Assert.assertNotNull(row[0], "cardNumber must not be null");
            Assert.assertNotNull(row[1], "expiryDate must not be null");
            Assert.assertNotNull(row[2], "pin must not be null");
            Assert.assertFalse(row[0].toString().contains("E+"), "cardNumber should not be in scientific notation");
        }

        // Verify DataProvider
        Iterator<Object[]> dp = DataProviders.getKnetData();
        Assert.assertTrue(dp.hasNext(), "Knet data provider must yield test records");
    }

    @Test(description = "Verify reading as Map dynamically")
    public void testReadAsMap() {
        List<Map<String, String>> mapList = ExcelUtils.getTestDataAsMap("Login.xlsx", null);
        Assert.assertFalse(mapList.isEmpty(), "Map list should not be empty");
        for (Map<String, String> row : mapList) {
            Assert.assertTrue(row.containsKey("username"), "Row map should contain 'username' header");
            Assert.assertTrue(row.containsKey("password"), "Row map should contain 'password' header");
        }
    }
}

