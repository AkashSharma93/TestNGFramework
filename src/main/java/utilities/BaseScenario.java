package utilities;

import dataaccess.PropertyReader;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

/**
 * Created by akash on 19/11/17.
 */
public class BaseScenario {
    protected WebDriver webDriver;

    @BeforeSuite
    public void setupSuite() {
        ChromeDriverManager.getInstance().setup();
        PropertyReader.loadConfigProperties();
    }

    @BeforeMethod
    public void setupTest() {
        webDriver = new ChromeDriver();
    }

    @AfterMethod
    public void teardownTest() {
        webDriver.quit();
    }
}
