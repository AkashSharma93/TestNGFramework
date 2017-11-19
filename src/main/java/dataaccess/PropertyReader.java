package dataaccess;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by akash on 20/11/17.
 */
public class PropertyReader {
    private static Properties configProperties;

    public static void loadConfigProperties() {
        if (configProperties != null) {
            return; // configProperties is loaded only once.
        }
        configProperties = new Properties();
        try {
            System.out.println("Loading config.properties");
            configProperties.load(new FileInputStream(FileHelper.getConfigFilePath()));
        } catch (IOException e) {
            System.out.println("Could not read config.properties");
            e.printStackTrace();
        }
    }

    public static String readItem(String propertyName) {
        return configProperties.getProperty(propertyName);
    }
}
