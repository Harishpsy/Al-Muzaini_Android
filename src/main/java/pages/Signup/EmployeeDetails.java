package pages.Signup;

import base.BasePage;

import org.openqa.selenium.By;

public class EmployeeDetails extends BasePage {

    public EmployeeDetails(){
        super();

    }

    private final By EMPLOYEENAME = By.xpath("//android.view.ViewGroup[@content-desc=\"Employer Name*\"]/android.view.ViewGroup[2]/android.widget.EditText");
    private final By OCCUPATION = By.xpath("//android.view.ViewGroup[@content-desc=\"Occupation*\"]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.EditText");
    private final By MONTHLYINCOME = By.xpath("//android.view.ViewGroup[@content-desc=\"Monthly Income*\"]/android.view.ViewGroup[2]/android.widget.EditText");
    private final By SOURCEOFINCOME = By.xpath("//android.view.ViewGroup[@content-desc=\"Source of Income*\"]/android.view.ViewGroup");
    private final By CONTINUE = By.xpath("//android.view.ViewGroup[@content-desc=\"Continue\"]");
    private final By SOURCEOFINCOMEMANUALENTRY = By.xpath("//android.view.ViewGroup[@content-desc=\"Source of Income*\"]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.EditText");
    private final By SOURCEOFINCOMEDROPOWNENTRY = By.xpath("//android.view.ViewGroup[@content-desc=\"Bank Loan\"]");
    private final By OCCUPATIONDROPOWNENTRY = By.xpath("//android.view.ViewGroup[@content-desc=\"3D Designer\"]")  ;

    public void EmployeeDetailsActions(String employeename, String monthlyIncome, String occupation){
        EmployeeName(employeename);
        Occupation(occupation);
        MonthlyIncome(monthlyIncome);
        SourceOfIncome();
        Continue();
    }

    private void EmployeeName(String employeename){
        click(EMPLOYEENAME);
        sendKeys(EMPLOYEENAME, employeename);

    }

    private void Occupation(String occupation){
        click(OCCUPATION);
        sendKeys(OCCUPATION, occupation);

    }

    private void MonthlyIncome(String monthlyIncome){
        click(MONTHLYINCOME);
        sendKeys(MONTHLYINCOME,monthlyIncome);
    }

    private void SourceOfIncome(){
        click(SOURCEOFINCOME);
        click(SOURCEOFINCOMEDROPOWNENTRY);
    }

    private void Continue(){
        click(CONTINUE);
    }

}
