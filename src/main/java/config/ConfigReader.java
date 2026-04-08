package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    private ConfigReader() {}

    public static void loadConfig(String env) {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config/" + env + ".properties")) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Could not load properties file for environment: " + env, e);
        }
    }

    public static String getProperty(String key) {
        if (properties == null) {
            String env = System.getProperty("env", "qa");
            loadConfig(env);
        }
        return properties.getProperty(key);
    }
}
