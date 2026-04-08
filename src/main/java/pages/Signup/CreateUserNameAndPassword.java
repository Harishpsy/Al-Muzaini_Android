package pages.Signup;

import base.BasePage;

import org.openqa.selenium.By;

public class CreateUserNameAndPassword extends BasePage {

    public CreateUserNameAndPassword(){
        super();
    }

    private final By USERNAME = By.xpath("//android.widget.EditText[@text=\"Username\"]");
    private final By PASSWORD = By.xpath("//android.widget.EditText[@text=\"Password\"]");
    private final By PASSWORDEYEICON = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]");
    private final By CONFIRMPASSWORD = By.xpath("//android.widget.EditText[@text=\"Confirm Password\"]");
    private final By CONFIRMPASSWORDEYEICON = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[12]/android.view.ViewGroup[2]");
    private final By TERMSADCONDITIONCHECKBOX = By.xpath("//android.widget.Button");
    private final By TERMSANDCONDITION = By.xpath("//android.widget.TextView[@text=\" Terms & Conditions\"]");
    private final By TERMSANDCONDITIONOKBUTTON = By.xpath("//android.view.ViewGroup[@content-desc=\"OK\"]");
    private final By CONFIRM = By.xpath("//android.view.ViewGroup[@content-desc=\"Confirm\"]");
    private final By YOURPROFILEISUNDERREVIEW = By.xpath("//android.view.ViewGroup[@content-desc=\"Continue\"]");


    public void CreateUserNameAndPasswordActions(String username, String password, String confirmpassword){
        Username(username);
        Password(password);
        ConfirmPassword(confirmpassword);
        TermsAndCondition();
        Confirm();
        YourProfileIsUnderReview();
    }

    private void Username(String username){
     click(USERNAME);
     sendKeys(USERNAME, username);
    }

    private void Password(String password){
        click(PASSWORD);
        sendKeys(PASSWORD, password);
        click(PASSWORDEYEICON);
    }

    private void ConfirmPassword(String confirmpassword){
        click(CONFIRMPASSWORD);
        sendKeys(CONFIRMPASSWORD,confirmpassword);
        click(CONFIRMPASSWORDEYEICON);
    }

    private void TermsAndCondition(){
        click(TERMSADCONDITIONCHECKBOX);
        click(TERMSANDCONDITION);
        click(TERMSANDCONDITIONOKBUTTON);
    }

    private void Confirm(){
       click(CONFIRM);
    }

    private void YourProfileIsUnderReview(){

        click(YOURPROFILEISUNDERREVIEW);
    }
}

