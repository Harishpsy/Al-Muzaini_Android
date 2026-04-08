package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.FxBooking.FXBookingTap;
import pages.FxBooking.FxbookingPage;
import utils.DataProviders;

public class FxBookingTest extends BaseTest {
    @Test(
            priority = 3,
            dataProvider = "FxBookingTap",
            dataProviderClass = DataProviders.class
    )
    public void executeFxBooking(String Amount) throws InterruptedException {
        this.executeFxBookingTapping(Amount);
        FxbookingPage fxPage = new FxbookingPage();
        fxPage.FXBookingPageCommonActions(Amount);
    }

    private void executeFxBookingTapping(String Amount) throws InterruptedException {
        FXBookingTap fxBookings = new FXBookingTap();
        fxBookings.FxBookingActions(Amount);
    }
}
