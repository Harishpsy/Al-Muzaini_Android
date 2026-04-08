package tests;

import pages.Signup.*;
import base.BaseTest;


public class SignupTest extends BaseTest {

    public SignupTest() {
        
    }

    @org.testng.annotations.Test(priority = 2, dataProvider = "Signup", dataProviderClass = utils.DataProviders.class)
    public void executeSignupTest(
            String idNumber, String mobileNumber,
            String otp1, String otp2, String otp3, String otp4,
            String firstName, String middleName, String lastName,
            String dob, String email, String whatsappNumber,
            String pepPosition, String location, String nationality,
            String block, String street, String building, String floor, String flat, String areaCity,
            String employeeName, String monthlyIncome, String occupation,
            String username, String password, String confirmPassword
    ) throws InterruptedException {

        executingsignup();
        executingverifyYourAccount(idNumber, mobileNumber);
        executingOTPVerification(otp1, otp2, otp3, otp4);
        executingIdentityDetails();
        executingPersonalDetails(firstName, middleName, lastName, dob, email, whatsappNumber, pepPosition, location, nationality);
        executingAddressDetails(block, street, building, floor, flat, areaCity);
        executingEmployeeDetails(employeeName, monthlyIncome, occupation);
        executingCreateUserNameAndPassword(username, password, confirmPassword);
    }

    private void executingsignup() throws InterruptedException {
        new Signup().SignupActions();
    }

    private void executingverifyYourAccount(String idNumber, String mobileNumber) throws InterruptedException {
        new VerifyYourAccount().VerifyYourAccountActions(idNumber, mobileNumber);
    }

    private void executingOTPVerification(String otp1, String otp2, String otp3, String otp4) throws InterruptedException {
        new OTPVerification().OTPActions(otp1, otp2, otp3, otp4);
    }

    private void executingIdentityDetails() {
        new IdentityDetails().IdentityDetailsActions();
    }

    private void executingPersonalDetails(String firstName, String middleName, String lastName, String dob,
                                          String email, String whatsappNumber, String pepPosition,
                                          String location, String nationality) throws InterruptedException {
        new PersonalDetails().PersonalDetailsActions(firstName, middleName, lastName, dob, email, whatsappNumber, pepPosition, location, nationality);
    }

    private void executingAddressDetails(String block, String street, String building, String floor, String flat, String areaCity) {
        new AddressDetails().AddressDetailsActions(block, street, building, floor, flat, areaCity);
    }

    private void executingEmployeeDetails(String employeeName, String monthlyIncome, String occupation) {
        new EmployeeDetails().EmployeeDetailsActions(employeeName, monthlyIncome, occupation);
    }

    private void executingCreateUserNameAndPassword(String username, String password, String confirmPassword) {
        new CreateUserNameAndPassword().CreateUserNameAndPasswordActions(username, password, confirmPassword);
    }
}
