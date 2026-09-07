package constants;

import java.io.File;

public class FrameworkConstants {

    private FrameworkConstants() {}

    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String RESOURCES_PATH = PROJECT_PATH + "/src/main/resources";
    
    public static final String CONFIG_FOLDER_PATH = RESOURCES_PATH + "/config";
    public static final String TEST_DATA_PATH = RESOURCES_PATH + "/Testdata";
    
    public static final String REPORTS_PATH = PROJECT_PATH + "/reports";
    public static final String SCREENSHOTS_PATH = PROJECT_PATH + "/screenshots";
    public static final String LOGS_PATH = PROJECT_PATH + "/logs";

    public static final int EXPLICIT_WAIT = 20;
    public static final int IMPLICIT_WAIT = 10;

    public static String getTestDataPath() {
        String systemDir = System.getProperty("testdata.dir");
        if (systemDir != null && !systemDir.trim().isEmpty()) {
            File dir = new File(systemDir.trim());
            if (dir.exists()) {
                return dir.getAbsolutePath();
            }
        }

        try {
            String customDir = config.ConfigReader.getProperty("testdata.dir");
            if (customDir != null && !customDir.trim().isEmpty()) {
                File dir = new File(customDir.trim());
                if (dir.exists()) {
                    return dir.getAbsolutePath();
                }
            }
        } catch (Exception ignored) {}

        File defaultDir = new File(TEST_DATA_PATH);
        if (!defaultDir.exists()) {
            defaultDir.mkdirs();
        }
        return defaultDir.getAbsolutePath();
    }
}
