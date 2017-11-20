package modules;

import dataaccess.PropertyReader;
import genericshelper.GenericModule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by akash on 20/11/17.
 */
public class DriverModule implements GenericModule {
    public WebDriver createDriverInstance() {
        String browserType = PropertyReader.readItem("browser");
        if (browserType.equalsIgnoreCase("chrome")) {
            return new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("ie11")) {
            return new InternetExplorerDriver();
        } else {    // Default - Firefox
            return new FirefoxDriver();
        }
    }

    public void navigateToAppUrl(WebDriver webDriver) {
        String url = PropertyReader.readItem("url");
        webDriver.navigate().to(url);
    }

    public void quitDriver(WebDriver webDriver) {
        webDriver.quit();
    }
}
