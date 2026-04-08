package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(priority = 1, description = "Verify user can login with valid credentials", dataProvider = "Login", dataProviderClass = utils.DataProviders.class)
    public void testSuccessfulLogin(String username, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        
        loginPage.handleNotification();
        loginPage.login(username, password);
        loginPage.verifyLoginSuccess();
    }
}
