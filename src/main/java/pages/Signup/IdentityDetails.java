package pages.Signup;

import base.BasePage;

import org.openqa.selenium.By;

public class IdentityDetails extends BasePage {

    //Locaters
    private final By FrontID = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup");
    private final By BackID = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[3]/android.view.ViewGroup");
    private final By SelfieVideo = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[5]/android.view.ViewGroup");
    private final By UploadPhoto = By.xpath("//android.widget.TextView[@text=\"Choose from Gallery\"]");
    private final By  ImageUpload1= By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[5]/android.view.View[2]/android.view.View[2]/android.view.View");
    private final By  ImageUpload2= By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[5]/android.view.View[3]/android.view.View[2]/android.view.View");
    private final By SelfieVideoUpload = By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[5]/android.view.View[1]/android.view.View[2]/android.view.View");
    private final By Continue = By.xpath("//android.widget.TextView[@text=\"Continue\"]");

    public IdentityDetails(){
        super();
    }

    public void IdentityDetailsActions(){
        UploadId();
    }

    public void UploadId(){
        CivilIdFront();
        CivilIdBack();
//        SelfieVideo();
        ContinueButton();
    }

    private void CivilIdFront(){
        click(FrontID);
        ChooseFromGallery();
        click(ImageUpload1);
    }

    private void CivilIdBack(){
        click(BackID);
        ChooseFromGallery();
        click(ImageUpload2);
    }

    private void SelfieVideo(){
        click(SelfieVideo);
        ChooseFromGallery();
        click(SelfieVideoUpload);
    }

    private void ChooseFromGallery(){
        click(UploadPhoto);
    }

    private void ContinueButton(){
        click(Continue);
    }





}
