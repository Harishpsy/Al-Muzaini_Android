package pages.Signup;

import base.BasePage;

import org.openqa.selenium.By;

public class AddressDetails extends BasePage {

    public AddressDetails() {
        super();
    }

    private final By GOVERNOATE = By.xpath("//android.widget.TextView[@text=\"Governorate*\"]");
    private final By LISTOFGOVERNOATE = By.xpath("//android.view.ViewGroup[@content-desc=\"Al Farwaniya\"]");
    private final By AREA_CITY = By.xpath("//android.widget.TextView[@text=\"Area / City*\"]");
    private final By LISTOFAREA_CITY = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]");
    private final By BLOCK = By.xpath("//android.view.ViewGroup[@content-desc=\"Block*\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText");
    private final By STREET = By.xpath("//android.view.ViewGroup[@content-desc=\"Street*\"]/android.view.ViewGroup[2]/android.widget.EditText");
    private final By BUILDING = By.xpath("//android.view.ViewGroup[@content-desc=\"Building*\"]/android.view.ViewGroup[2]/android.widget.EditText");
    private final By FLOOR = By.xpath("//android.view.ViewGroup[@content-desc=\"Floor*\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText");
    private final By FLAT = By.xpath("//android.view.ViewGroup[@content-desc=\"Flat*\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText");
    private final By CONTINUE = By.xpath("//android.view.ViewGroup[@content-desc=\"Continue\"]");
    private final By CLOSEICON = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup");



    public void AddressDetailsActions(String block , String street, String building, String floor, String flat, String area_city){
        Governoate();
        Area_City(area_city);
        Block(block);
        Street(street);
        Building(building);
        Floor(floor);
        Flat(flat);
        Continue();
    }

    private void Governoate(){
        click(GOVERNOATE);
        click(CLOSEICON);
        click(GOVERNOATE);
        click(LISTOFGOVERNOATE);
    }

    private void Area_City(String area_city){
        click(AREA_CITY);
//        sendKeys(AREA_CITY, area_city);
        click(CLOSEICON);
        click(AREA_CITY);
        click(LISTOFAREA_CITY);
    }

    private void Block(String block){
        click(BLOCK);
        sendKeys(BLOCK , block);
    }

    private void Street(String street){
        click(STREET);
        sendKeys(STREET, street);
    }

    private void Building(String building){
        click(BUILDING);
        sendKeys(BUILDING, building);
    }

    private void Floor(String floor){
        click(FLOOR);
        sendKeys(FLOOR, floor);
    }

    private void Flat(String flat){
        click(FLAT);
        sendKeys(FLAT, flat);
        hideKeyboard();
    }

    private void Continue(){
        click(CONTINUE);
    }
}
