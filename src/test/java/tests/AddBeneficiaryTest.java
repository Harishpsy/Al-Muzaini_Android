package tests;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import java.util.List;
import java.util.Map;

import utils.DataProviders;
import utils.ExcelUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.DriverFactory;
import pages.AddBeneficiary.AddBeneficiaryTap;

import java.beans.Transient;

public class AddBeneficiaryTest {
    @BeforeMethod
    public void setup() {
        DriverFactory.setDriver("android");
    }

    @Test(dataProvider = "AddBeneficiary", dataProviderClass = DataProviders.class)
    public void executeAddBeneficiary(String countryCode, String currencyCode) throws InterruptedException {
        System.out.println("Country Code: " + countryCode);
        System.out.println("Currency Code: " + currencyCode);
        executeAddBeneficiaryTapping(countryCode, currencyCode);
    }

    protected void executeAddBeneficiaryTapping(String countryCode, String currencyCode) throws InterruptedException {
        AddBeneficiaryTap addbeneficiary = new AddBeneficiaryTap();
        addbeneficiary.AddBeneficiaryActions(countryCode, currencyCode);
    }

    @DataProvider(name = "AddBeneficiary")
    public Object[][] getAddBeneficiaryData() {
        List<Map<String, String>> data = ExcelUtils.getTestDataAsMap("AddBeneficiary.xlsx", "Sheet1");
        Object[][] result = new Object[data.size()][];

        for (int i = 0; i < data.size(); i++) {
            result[i] = new Object[]{data.get(i)};
        }
        return result;
    }
}

