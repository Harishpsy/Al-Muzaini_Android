package base;

import config.ConfigReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.net.URL;
import java.time.Duration;

public class DriverFactory {

    private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    private static final ThreadLocal<String> currentPlatform = new ThreadLocal<>();

    private DriverFactory() {
        // Prevent object creation
    }

    public static AppiumDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(String platform) {

        try {

            if (driver.get() != null) {
                quitDriver();
            }

            currentPlatform.set(platform);

            URL appiumServerUrl =
                    new URL(ConfigReader.getProperty("appium.server.url"));

            AppiumDriver appiumDriver;

            switch (platform.toLowerCase()) {

                case "android":

                    UiAutomator2Options androidOptions =
                            createAndroidOptions();

                    appiumDriver =
                            new AndroidDriver(appiumServerUrl, androidOptions);

                    break;

                case "ios":

                    XCUITestOptions iosOptions =
                            createIOSOptions();

                    appiumDriver =
                            new IOSDriver(appiumServerUrl, iosOptions);

                    break;

                default:
                    throw new RuntimeException(
                            "Unsupported platform: " + platform
                    );
            }

            appiumDriver.manage()
                    .timeouts()
                    .implicitlyWait(Duration.ofSeconds(0));

            driver.set(appiumDriver);

            System.out.println(
                    "Driver initialized successfully for: " + platform
            );

        } catch (Exception e) {

            throw new RuntimeException(
                    "Failed to initialize driver: " + e.getMessage(),
                    e
            );
        }
    }

    private static UiAutomator2Options createAndroidOptions() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName(ConfigReader.getProperty("android.platform.name"));
        options.setDeviceName(ConfigReader.getProperty("android.device.name"));
        options.setUdid(ConfigReader.getProperty("android.device.udid"));
        options.setAutomationName(ConfigReader.getProperty("android.automation.name"));
        options.setAppPackage(ConfigReader.getProperty("android.app.package"));
        options.setAppActivity(ConfigReader.getProperty("android.app.activity"));
        options.setAppWaitActivity(ConfigReader.getProperty("android.app.wait.activity"));
        options.setNoReset(Boolean.parseBoolean(ConfigReader.getProperty("android.no.reset")));
        options.setFullReset(Boolean.parseBoolean(ConfigReader.getProperty("android.full.reset")));
        options.setNewCommandTimeout(Duration.ofSeconds(600));

        /*
         * ---------------------------------------------------
         * ANDROID STABILITY CAPABILITIES
         * ---------------------------------------------------
         */
        options.setCapability("autoGrantPermissions", true);
        options.setCapability("ignoreHiddenApiPolicyError", true);
        options.setCapability("disableWindowAnimation", true);
        options.setCapability("uiautomator2ServerLaunchTimeout", 120000);
        options.setCapability("uiautomator2ServerInstallTimeout", 120000);
        options.setCapability("adbExecTimeout", 120000);
        options.setCapability("androidInstallTimeout", 120000);
        options.setCapability("androidDeviceReadyTimeout", 120);
        options.setCapability("appWaitDuration", 60000);
        options.setCapability("ignoreUnimportantViews", false);
        options.setCapability("dontStopAppOnReset", true);
        options.setCapability("clearDeviceLogsOnStart", true);
        options.setCapability("enablePerformanceLogging", false);
        options.setCapability("disableSuppressAccessibilityService", true);
        options.setCapability("disableWindowAnimation", true);
        return options;
    }

    private static XCUITestOptions createIOSOptions() {

        XCUITestOptions options = new XCUITestOptions();

        options.setDeviceName(
                ConfigReader.getProperty("ios.device.name")
        );

        options.setAutomationName(
                ConfigReader.getProperty("ios.automation.name")
        );

        options.setBundleId(
                ConfigReader.getProperty("ios.bundle.id")
        );

        options.setUdid(
                ConfigReader.getProperty("ios.udid")
        );

        options.setPlatformVersion(
                ConfigReader.getProperty("ios.platform.version")
        );

        options.setNoReset(
                Boolean.parseBoolean(
                        ConfigReader.getProperty("ios.no.reset")
                )
        );

        options.setFullReset(
                Boolean.parseBoolean(
                        ConfigReader.getProperty("ios.full.reset")
                )
        );

        return options;
    }

    public static boolean isDriverAlive() {

        try {

            AppiumDriver currentDriver = driver.get();

            if (currentDriver == null) {
                return false;
            }

            currentDriver.getSessionId();

            if (currentDriver instanceof AndroidDriver) {

                AndroidDriver androidDriver =
                        (AndroidDriver) currentDriver;

                String currentPackage =
                        androidDriver.getCurrentPackage();

                return currentPackage != null;
            }

            return true;

        } catch (Exception e) {

            System.out.println(
                    "Driver session is dead: " + e.getMessage()
            );

            return false;
        }
    }

    public static void recreateDriver() {

        try {

            String platform = currentPlatform.get();

            if (platform == null) {
                throw new RuntimeException(
                        "Platform information not available"
                );
            }

            System.out.println(
                    "Recreating driver for platform: " + platform
            );

            quitDriver();

            Thread.sleep(3000);

            setDriver(platform);

        } catch (Exception e) {

            throw new RuntimeException(
                    "Driver recreation failed: " + e.getMessage(),
                    e
            );
        }
    }

    public static void restartApp() {

        try {

            AppiumDriver currentDriver = driver.get();

            if (currentDriver instanceof AndroidDriver) {

                AndroidDriver androidDriver =
                        (AndroidDriver) currentDriver;

                String appPackage =
                        ConfigReader.getProperty("android.app.package");

                androidDriver.terminateApp(appPackage);

                Thread.sleep(2000);

                androidDriver.activateApp(appPackage);

                Thread.sleep(3000);

                System.out.println("App restarted successfully");
            }

        } catch (Exception e) {

            System.out.println(
                    "App restart failed. Recreating driver..."
            );

            recreateDriver();
        }
    }

    public static void quitDriver() {

        try {

            AppiumDriver currentDriver = driver.get();

            if (currentDriver != null) {

                System.out.println("Closing driver session...");

                currentDriver.quit();
            }

        } catch (Exception e) {

            System.out.println("Error while quitting driver: " + e.getMessage());

        } finally {

            driver.remove();
            currentPlatform.remove();
        }
    }
}