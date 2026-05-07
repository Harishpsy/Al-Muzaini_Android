package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.RateCalculator.ForeignCurrency;
import pages.RateCalculator.RateCalculatorTap;
import pages.RateCalculator.Transfer;

public class RateCalculatorTest extends BaseTest {

    @Test(
            priority = 5
            // dataProvider = "",
            // dataProviderClass = DataProviders.class
    )

    public void executeRateCalculator() throws InterruptedException {
        TappingRateCalculator();
        executingTransfer();
        executeForiegnCurrency();
    }

    protected void TappingRateCalculator() {

        RateCalculatorTap TappingRateCalculator = new RateCalculatorTap();
        TappingRateCalculator.RateCalculatorTap();
    }

    protected void executingTransfer() throws InterruptedException {
        Transfer Transferaction = new  Transfer();
        Transferaction.TransferActions();
    }

    protected void executeForiegnCurrency() throws InterruptedException {
        ForeignCurrency  foreignCurrency = new  ForeignCurrency();
        foreignCurrency.ForeignCurrencyActions();
    }





}
