package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.AddBeneficiary.AddBeneficiaryTap;
import pages.AddBeneficiary.Select_CountryAndCurrency;

public class AddBeneficiaryTest extends BaseTest {

    @Test
    public void AddBeneficiaryflow() throws InterruptedException {
        executeAddBeneficiary();
        AddBeneficiaryDropdown();
    }

    protected void executeAddBeneficiary() throws InterruptedException {
        //Open Add Beneficiary
        AddBeneficiaryTap beneficiary = new AddBeneficiaryTap();
        beneficiary.AddBeneficiaryActions();
    }

    protected void AddBeneficiaryDropdown() throws InterruptedException {
        Select_CountryAndCurrency selectCountryAndCurrency = new Select_CountryAndCurrency();
        selectCountryAndCurrency.Select_CountryAndCurrencyCommonActions();

    }

}

