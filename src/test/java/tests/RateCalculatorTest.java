package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.RateCalculator.ForeignCurrency;
import pages.RateCalculator.RateCalculatorTap;
import pages.RateCalculator.Transfer;

import utils.DataProviders;

public class RateCalculatorTest extends BaseTest {

    @Test(
            priority = 5,
            dataProvider = "RateCalculator",
            dataProviderClass = DataProviders.class
    )

    public void executeRateCalculator(String fcAmount, String lcAmount, String currencySearch) throws InterruptedException {
        TappingRateCalculator();
        executingTransfer(fcAmount, lcAmount, currencySearch);
        executeForiegnCurrency(fcAmount, lcAmount);
    }

    protected void TappingRateCalculator() {

        RateCalculatorTap TappingRateCalculator = new RateCalculatorTap();
        TappingRateCalculator.RateCalculatorTap();
    }

    protected void executingTransfer(String fcAmount, String lcAmount, String currencySearch) throws InterruptedException {
        Transfer Transferaction = new  Transfer();
        Transferaction.TransferActions(fcAmount, lcAmount, currencySearch);
    }

    protected void executeForiegnCurrency(String fcAmount, String lcAmount) throws InterruptedException {
        ForeignCurrency  foreignCurrency = new  ForeignCurrency();
        foreignCurrency.ForeignCurrencyActions(fcAmount, lcAmount);
    }





}
