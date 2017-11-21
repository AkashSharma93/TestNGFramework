package fragments;

import org.openqa.selenium.WebDriver;
import utilities.WebDriverUtils;
import xpaths.PageHeaderPanelXPaths;

/**
 * Created by akash on 21/11/17.
 */
public class PageHeaderPanel implements PageHeaderPanelXPaths {
    private int waitTime = 10;

    public boolean isLogoDisplayed(WebDriver webDriver) {
        WebDriverUtils wdUtils = new WebDriverUtils(webDriver);
        return wdUtils.waitForElement(logo, waitTime);
    }

    public boolean openHomePage(WebDriver webDriver) {
        WebDriverUtils wdUtils = new WebDriverUtils(webDriver);
        try {
            wdUtils.clickElement(logo);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
