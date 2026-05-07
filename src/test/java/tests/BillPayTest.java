package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.BillPay.BillPayTap;
import pages.BillPay.PayBills_BharatConnect;
import pages.BillPay.PayLocalBillsEnet;
import utils.DataProviders;

public class BillPayTest extends BaseTest {

    @Test(
            priority = 4
            // dataProvider = "",
            // dataProviderClass = DataProviders.class
    )
    public void executeBillPay () throws InterruptedException{
        executeBillPayTapping();
        executePayLocalBillsEnet();
        executePayBills_BharatConnect();
    }

    protected void executeBillPayTapping() throws InterruptedException {
        BillPayTap billPay = new BillPayTap();
        billPay.BillPayActions();
    }

    protected void executePayLocalBillsEnet() throws InterruptedException {
        PayLocalBillsEnet payLocalBills_enet = new PayLocalBillsEnet();
        payLocalBills_enet.eNetActions();
    }

    protected void executePayBills_BharatConnect() throws InterruptedException {
        PayBills_BharatConnect Bharatconnect = new PayBills_BharatConnect();
        Bharatconnect.ClubAndAssociationsCommonActions();
    }
}