package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.BillPay.BillPayTap;
import pages.FxBooking.FXBookingTap;
import pages.FxBooking.FxbookingPage;
import utils.DataProviders;

public class BillPayTest extends BaseTest {

    @Test(
            priority = 4,
            dataProvider = "",
            dataProviderClass = DataProviders.class
    )
    public void executeBillPay () {
        executeBillPayTapping();
    }

    private void executeBillPayTapping() {
        BillPayTap BillPay = new BillPayTap();
        BillPay.BillPayActions();
    }
}
