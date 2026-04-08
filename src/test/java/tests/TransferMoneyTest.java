package tests;

import org.testng.annotations.Test;
import pages.TransferMoney.Beneficiaries.BankTransfer.BankTransfer;
import pages.TransferMoney.Beneficiaries.BankTransfer.KnetPaymentGateway;
import pages.TransferMoney.TransferMoney;
import base.BaseTest;


public class TransferMoneyTest extends BaseTest {

    @Test (priority = 2, dataProvider = "BankTransfer", dataProviderClass = utils.DataProviders.class)
    public void executeTransferMoneyTest(String YouSend, String ReEnterYouSend, String TheyReceive) throws InterruptedException {
        executeTransferMoney();
        executeBankTransfer(YouSend,ReEnterYouSend);
        Thread.sleep(10000);
    }

    private void executeTransferMoney() throws InterruptedException {
        TransferMoney transferMoney = new TransferMoney();
        transferMoney.TransferMoneyActions();
    }

    private void executeBankTransfer(String YouSend, String ReEnterYouSend) throws InterruptedException {
        BankTransfer Banktransfer = new BankTransfer();
        Banktransfer.BankTransferAction(YouSend,ReEnterYouSend );
    }













}
