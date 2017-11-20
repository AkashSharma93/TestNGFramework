package dataaccess;

import java.io.File;

/**
 * Created by akash on 20/11/17.
 */
public class FileHelper {
    private static final String resourcesDirName = "resources";
    private static final String configFileName = "config.properties";
    private static final String testDataFileName = "testData.xlsx";

    /**
     *  Returning a single directory name here might seem weird.
     *  But it helps to have multiple getPath methods which build on top of each other.
     *  This ensure we don't build random paths anywhere in the framework.
     *  Ex.: getTestDataPath() -> getResourcePath() + File.separator + "testData";
     */
    public static String getResourcesPath() {
        return resourcesDirName;
    }

    public static String getConfigFilePath() {
        return getResourcesPath() + File.separator + configFileName;
    }

    public static String getTestDataFilePath() {
        return getResourcesPath() + File.separator + testDataFileName;
    }
}
