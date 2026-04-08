package pages.Signup;

import base.BasePage;

import org.openqa.selenium.By;

import java.time.Duration;

public class PersonalDetails extends BasePage {

    public PersonalDetails(){
        super();
    }

    // Locators - fixed typo in "Influence"
    private final By FirstName = By.xpath("//android.view.ViewGroup[@content-desc=\"First Name*\"]/android.view.ViewGroup[2]/android.widget.EditText");
    private final By MiddleName = By.xpath("//android.view.ViewGroup[@content-desc=\"Middle Name\"]/android.view.ViewGroup[2]/android.widget.EditText");
    private final By LastName = By.xpath("//android.view.ViewGroup[@content-desc=\"Last Name*\"]/android.view.ViewGroup[2]/android.widget.EditText");
    private final By EmailId = By.xpath("//android.view.ViewGroup[@content-desc=\"Email ID*\"]/android.view.ViewGroup[2]/android.widget.EditText");
    private final By PlaceOfBirth = By.xpath("//android.view.ViewGroup[@content-desc=\"Place of birth*\"]");
    private final By Nationality = By.xpath("//android.widget.TextView[@text=\"Nationality*\"]");
    private final By Gender = By.xpath("//android.widget.TextView[@text=\"Gender*\"]");
    private final By WhatsappNumber = By.xpath("//android.view.ViewGroup[@content-desc=\"WhatsApp Number, +965\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText");
    private final By AreYouAPEP = By.xpath("//android.view.ViewGroup[@content-desc=\"Are you a PEP?\"]/android.view.ViewGroup");
    private final By PoliticalInfluence = By.xpath("//android.widget.RadioButton[@content-desc=\"Local\"]");
    private final By AreYouARelativeOfAPEP = By.xpath("//android.widget.RadioButton[@content-desc=\"No\"]");
    private final By DegreeOfRelationship = By.xpath("//android.widget.RadioButton[@content-desc=\"Neutral\"]");
    private final By PEPPosition = By.xpath("//android.view.ViewGroup[@content-desc=\"PEP Position*\"]/android.view.ViewGroup[2]/android.widget.EditText");
    private final By Continue = By.xpath("//android.view.ViewGroup[@content-desc=\"Continue\"]");
    private final By PlaceOFBirthTextField =By.xpath("//android.widget.EditText[@text=\"Search Place of birth\"]");
    private final By Locations = By.xpath("//android.view.ViewGroup[@content-desc=\"INDIA\"]");
    private final By CloseIcon = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup");
    private final By SearchNationlity = By.xpath("//android.widget.EditText[@text=\"Search Nationality\"]");
    private final By NationalityClick = By.xpath("//android.view.ViewGroup[@content-desc=\"INDIAN\"]");
    private final By CommonFirstElementClick = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]");
    private final By ClickingGender = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]");
    private final By CLickingPOB = By.xpath("//android.view.ViewGroup[@content-desc=\"AFGHANISTAN\"]");
    private final By CLickingNationality = By.xpath("//android.view.ViewGroup[@content-desc=\"ANDORRAN\"]");


    public void PersonalDetailsActions(String Firstname, String Middlename, String Lastname, String DOB, String Emailid, String whatsappNumber, String PEPposition, String Location, String Nationalitys) throws InterruptedException {
        FirstName(Firstname);
        MiddleName(Middlename);
        LastName(Lastname);
        EmailId(Emailid);
        PlaceOfBirth(DOB, Location );
        Nationality(Nationalitys);
        Gender();
        WhatsappNumber(whatsappNumber);
        AreYouAPEPActions(PEPposition);
        Continue();
    }

    private void FirstName(String Firstname) throws InterruptedException {
        click(FirstName);
        System.out.println(Firstname + "FIRSTNAME");
        Thread.sleep(1000);
        sendKeys(FirstName, Firstname);
    }

    private void MiddleName(String Middlename){
        click(MiddleName);
        sendKeys(MiddleName, Middlename);
    }

    private void LastName(String Lastname){
        click(LastName);
        sendKeys(LastName, Lastname);
    }

    private void PlaceOfBirth(String DOB , String Location) throws InterruptedException {
        click(PlaceOfBirth);
        click(CloseIcon);
        click(PlaceOfBirth);
//        scrollList();
//        click(PlaceOFBirthTextField);
//        sendKeys(PlaceOFBirthTextField, Location);
//        driver.hideKeyboard();
//        click(Locations);
        click(CLickingPOB);
    }

    private void EmailId(String Emailid){
        click(EmailId);
        sendKeys(EmailId, Emailid);
        hideKeyboard();
    }

    private void Nationality(String Nationalitys) throws InterruptedException{
        click(Nationality);
        click(CloseIcon);
        click(Nationality);
//        scrollList();
//        click(SearchNationlity);
//        driver.hideKeyboard();
//        click(NationalityClick);
        click(CLickingNationality);

    }

    private void Gender(){
        click(Gender);
        click(CloseIcon);
        click(Gender);
        click(CommonFirstElementClick);
    }

    private void WhatsappNumber(String whatsappNumber){
        click(WhatsappNumber);
        scrollToEnd();
        sendKeys(WhatsappNumber, whatsappNumber);
        hideKeyboard();
    }

    private void AreYouAPEPActions(String PEPposition) throws InterruptedException{
        AreYouAPEP();
        PoliticalInfluence();
        AreYouARelativeOfAPEP();
        DegreeOfRelationship();
        PEPPosition(PEPposition);
    }

    private void AreYouAPEP(){
        click(AreYouAPEP);
    }

    private void PoliticalInfluence(){
        click(PoliticalInfluence);
    }

    private void AreYouARelativeOfAPEP(){
        click(AreYouARelativeOfAPEP);
        scrollToEnd();
    }

    private void DegreeOfRelationship() {
        click(DegreeOfRelationship);
        scrollToEnd();
    }

    private void PEPPosition(String PEPposition) throws InterruptedException {
        click(PEPPosition);
        scrollToEnd();
        sendKeys(PEPPosition, PEPposition);
        hideKeyboard();
    }

    private void Continue(){
        click(Continue);
    }
}
