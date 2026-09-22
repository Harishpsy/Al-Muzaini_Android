package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.AddBeneficiary.AddBeneficiaryTap;
import pages.AddBeneficiary.BeneficiaryDetails;
import pages.AddBeneficiary.Select_CountryAndCurrency;
import pages.AddBeneficiary.Select_ServiceAndProvider;
import utils.DataProviders;

public class AddBeneficiaryTest extends BaseTest {

    @Test(dataProvider = "BankTransfer", dataProviderClass = DataProviders.class)
    public void AddBeneficiaryflow(String YouSend, String TheyReceive, String ReEnterYouSend) throws InterruptedException {
        executeAddBeneficiary();
        AddBeneficiaryDropdown();
        ServiceTypeAndProvider();
        BeneficiaryDetailsPage(YouSend, ReEnterYouSend);
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

    protected void BeneficiaryDetailsPage(String YouSend, String ReEnterYouSend) throws InterruptedException {
        BeneficiaryDetails beneficiaryPage = new BeneficiaryDetails();
        beneficiaryPage.BeneficiaryDetailsCommonActions(YouSend,ReEnterYouSend);
    }
}

