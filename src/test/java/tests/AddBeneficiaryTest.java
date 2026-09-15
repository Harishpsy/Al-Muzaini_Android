package tests;

import base.BaseTest;
import org.bouncycastle.asn1.dvcs.ServiceType;
import org.testng.annotations.Test;
import pages.AddBeneficiary.AddBeneficiaryTap;
import pages.AddBeneficiary.Select_CountryAndCurrency;
import pages.AddBeneficiary.Select_ServiceAndProvider;

public class AddBeneficiaryTest extends BaseTest {

    @Test
    public void AddBeneficiaryflow() throws InterruptedException {
        executeAddBeneficiary();
        AddBeneficiaryDropdown();
        ServiceTypeAndProvider();
    }

    protected void executeAddBeneficiary() throws InterruptedException {
        //Open Add Beneficiary
        AddBeneficiaryTap beneficiary = new AddBeneficiaryTap();
        beneficiary.AddBeneficiaryActions();
    }

    // Add Beneficiary
    protected void AddBeneficiaryDropdown() throws InterruptedException {
        Select_CountryAndCurrency selectCountryAndCurrency = new Select_CountryAndCurrency();
        selectCountryAndCurrency.Select_CountryAndCurrencyCommonActions();
    }

    protected void ServiceTypeAndProvider(){
        Select_ServiceAndProvider SelectServiceTypeAndProvider = new Select_ServiceAndProvider();
        SelectServiceTypeAndProvider.SelectServiceAndProviderCommonActions();
    }
}

