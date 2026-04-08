package base;

import config.ConfigReader;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.*;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;

public class BaseTest {

    @BeforeSuite(alwaysRun = true)
    @Parameters({"platform"})
    public void setUp(@org.testng.annotations.Optional("android") String platform) throws MalformedURLException {
        // Optional: If platform is not provided via TestNG.xml, get from config
        if (platform == null || platform.isEmpty()) {
            platform = ConfigReader.getProperty("android.platform.name");
        }

        DriverFactory.setDriver(platform);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
