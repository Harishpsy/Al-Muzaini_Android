package utils;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    // ==========================================
    // 1. Login Data Provider
    // ==========================================
    @DataProvider(name = "Login", parallel = false)
    public static Iterator<Object[]> getLoginData() {
        return ExcelUtils.getTestData("Login.xlsx").iterator();
    }

    // ==========================================
    // 2. Signup Data Provider
    // ==========================================
    @DataProvider(name = "Signup")
    public static Iterator<Object[]> getSignupData() {
        return ExcelUtils.getTestData("Signup.xlsx").iterator();
    }

    // ==========================================
    // 3. Bank Transfer Data Provider
    // ==========================================
    @DataProvider(name = "BankTransfer")
    public static Iterator<Object[]> getBankTransferData() {
        return ExcelUtils.getTestData("BankTransfer.xlsx").iterator();
    }

    // ==========================================
    // 4. FX Booking Data Provider
    // ==========================================
    @DataProvider(name = "FxBookingTap")
    public static Iterator<Object[]> getFxBookingData() {
        return ExcelUtils.getTestData("FxBooking.xlsx").iterator();
    }

    // ==========================================
    // 5. Bill Pay Data Provider
    // ==========================================
    @DataProvider(name = "BillPay")
    public static Iterator<Object[]> getBillPayData() {
        return ExcelUtils.getTestData("BillPay.xlsx").iterator();
    }

    // ==========================================
    // 6. Rate Calculator Data Provider
    // ==========================================
    @DataProvider(name = "RateCalculator")
    public static Iterator<Object[]> getRateCalculatorData() {
        return ExcelUtils.getTestData("RateCalculator.xlsx").iterator();
    }

    // ==========================================
    // 7. Knet Payment Data Provider
    // ==========================================
    @DataProvider(name = "Knet")
    public static Iterator<Object[]> getKnetData() {
        return ExcelUtils.getTestData("Knet.xlsx").iterator();
    }

    //Add Beneficiary Data Provider
    @DataProvider(name = "AddBeneficiary")
    public static Iterator<Object[]> getAddBeneficiaryData() throws Exception{
        String filePath = "src/main/resources/Testdata/AddBeneficiary.xlsx";
        List<Object[]> testData = new ArrayList<>();
        //Read Excel using ExcelUtils
        return testData.iterator();
    }
}


