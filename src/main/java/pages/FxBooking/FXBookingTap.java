package pages.FxBooking;

import base.BasePage;
import org.openqa.selenium.By;

public class FXBookingTap extends BasePage {
    private By FxBookingTapping = By.xpath("//android.view.ViewGroup[@content-desc=\"Forex Booking\"]");

    public void FxBookingActions(String amount) {
        this.FxBookingclicking();
        System.out.println("SuccessFully CLicked The FxBooking");
    }

    protected void FxBookingclicking() {
        this.clickWithWait(this.FxBookingTapping);
    }
}
