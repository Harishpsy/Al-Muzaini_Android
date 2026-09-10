package tests;

import base.BaseTest;
import utils.DataProviders;
import org.testng.annotations.Test;
import pages.AddBeneficiary.AddBeneficiaryTap;
import pages.AddBeneficiary.Select_CountryAndCurrency;



public class AddBeneficiaryTest extends BaseTest {

    @Test
    public void executeAddBeneficiary() throws InterruptedException {
        //executeAddBeneficiaryTapping();
    //}

    //protected void executeAddBeneficiaryTapping() throws InterruptedException {
        //Open Add Beneficiary
        AddBeneficiaryTap addbeneficiary = new AddBeneficiaryTap();
        addbeneficiary.AddBeneficiaryActions();
        String country = "BANGLADESH";

        //Select Country
        Select_CountryAndCurrency countryAndCurrency = new Select_CountryAndCurrency();
        //Step 1
        countryAndCurrency.clickSelectCountry();
        //Step 2
        countryAndCurrency.enterCountry("BANGLADESH");
        //Step 3
        countryAndCurrency.selectCountryFromDropdown(country);


    }

}

