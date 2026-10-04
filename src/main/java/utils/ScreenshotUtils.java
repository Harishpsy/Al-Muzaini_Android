package utils;

import base.DriverFactory;
import constants.FrameworkConstants;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    private ScreenshotUtils() {
        // Prevent instantiation
    }

    /**
     * Captures a screenshot and saves it in a new folder specified by folderName.
     * Creates the folder if it does not exist.
     *
     * @param folderName Name of the folder (e.g., "Transaction Summary")
     * @param fileNamePrefix Base prefix for the screenshot file name
     * @return The absolute path of the primary saved screenshot
     */
    public static String captureScreenshot(String folderName, String fileNamePrefix) {
        AppiumDriver driver = DriverFactory.getDriver();
        if (driver == null) {
            System.err.println("Driver is not initialized. Cannot capture screenshot.");
            return null;
        }

        try {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String sanitizedPrefix = (fileNamePrefix != null && !fileNamePrefix.trim().isEmpty())
                    ? fileNamePrefix.trim().replaceAll("\\s+", "_")
                    : "Screenshot";
            String fullFileName = sanitizedPrefix + "_" + timestamp + ".png";

            // 1. Save in the requested folder directly under the project root: <project_root>/[folderName]
            File targetFolder = new File(FrameworkConstants.PROJECT_PATH + File.separator + folderName);
            if (!targetFolder.exists()) {
                boolean created = targetFolder.mkdirs();
                if (created) {
                    System.out.println("Created new directory: " + targetFolder.getAbsolutePath());
                }
            }
            File destinationFile = new File(targetFolder, fullFileName);
            FileHandler.copy(sourceFile, destinationFile);
            System.out.println("Screenshot successfully saved to: " + destinationFile.getAbsolutePath());

            // 2. Also save a copy under screenshots/<folderName> to support standard framework reporting & CI archiving
            try {
                File screenshotsSubFolder = new File(FrameworkConstants.SCREENSHOTS_PATH + File.separator + folderName);
                if (!screenshotsSubFolder.exists()) {
                    screenshotsSubFolder.mkdirs();
                }
                File frameworkDestination = new File(screenshotsSubFolder, fullFileName);
                FileHandler.copy(sourceFile, frameworkDestination);
                System.out.println("Screenshot copy saved to: " + frameworkDestination.getAbsolutePath());
            } catch (Exception e) {
                System.err.println("Could not create copy in framework screenshots folder: " + e.getMessage());
            }

            return destinationFile.getAbsolutePath();

        } catch (IOException e) {
            System.err.println("IOException occurred while saving screenshot: " + e.getMessage());
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            System.err.println("Exception occurred while capturing screenshot: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Captures a screenshot and saves it with the folderName as the default file prefix.
     *
     * @param folderName Name of the folder (e.g., "Transaction Summary")
     * @return The absolute path of the saved screenshot
     */
    public static String captureScreenshot(String folderName) {
        return captureScreenshot(folderName, folderName);
    }

    /**
     * Captures screenshot as Base64 string for ExtentReports.
     *
     * @return Base64 encoded screenshot string, or null if driver is null
     */
    public static String getBase64Screenshot() {
        AppiumDriver driver = DriverFactory.getDriver();
        if (driver != null) {
            try {
                return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
            } catch (Exception e) {
                System.err.println("Failed to get Base64 screenshot: " + e.getMessage());
            }
        }
        return null;
    }
}
