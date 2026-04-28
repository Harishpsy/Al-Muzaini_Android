package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import config.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {

   private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public static AppiumDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(String platform) throws MalformedURLException {
        if (driver.get() != null) {
            try {
                driver.get().getStatus(); // Check if driver is still alive
                return; // Reuse existing driver
            } catch (Exception e) {
                driver.get().quit();
                driver.remove(); // Remove dead driver
            }
        }

        System.out.println("Initializing driver for platform: " + platform);
        AppiumDriver appiumDriver;
        URL url = new URL(ConfigReader.getProperty("appium.server.url"));

        if (platform.equalsIgnoreCase("android")) {
            UiAutomator2Options options = new UiAutomator2Options()
                    .setPlatformName(ConfigReader.getProperty("android.platform.name"))
                    .setDeviceName(ConfigReader.getProperty("android.device.name"))
                    .setAutomationName(ConfigReader.getProperty("android.automation.name"))
                    .setAppPackage(ConfigReader.getProperty("android.app.package"))
                    .setAppActivity(ConfigReader.getProperty("android.app.activity"))
                    .setAppWaitActivity(ConfigReader.getProperty("android.app.wait.activity"))
                    .setNoReset(Boolean.parseBoolean(ConfigReader.getProperty("android.no.reset")))
                    .setFullReset(Boolean.parseBoolean(ConfigReader.getProperty("android.full.reset")))
                    .setNewCommandTimeout(Duration.ofSeconds(300));
            appiumDriver = new AndroidDriver(url, options);
        } else if (platform.equalsIgnoreCase("ios")) {
            XCUITestOptions options = new XCUITestOptions()
                    .setDeviceName(ConfigReader.getProperty("ios.device.name"))
                    .setAutomationName(ConfigReader.getProperty("ios.automation.name"))
                    .setBundleId(ConfigReader.getProperty("ios.bundle.id"))
                    .setUdid(ConfigReader.getProperty("ios.udid"))
                    .setNoReset(Boolean.parseBoolean(ConfigReader.getProperty("ios.no.reset")))
                    .setFullReset(Boolean.parseBoolean(ConfigReader.getProperty("ios.full.reset")))
                    .setPlatformVersion(ConfigReader.getProperty("ios.platform.version"));
            appiumDriver = new IOSDriver(url, options);
        } else {
            throw new RuntimeException("Platform not supported: " + platform);
        }

        appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        driver.set(appiumDriver);
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            System.out.println("Quitting driver...");
            try {
                driver.get().quit();
            } catch (Exception e) {
                System.out.println("Error quitting driver: " + e.getMessage());
            } finally {
                driver.remove();
            }
        }
    }
}
