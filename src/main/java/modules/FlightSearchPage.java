package modules;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Map;

/**
 * Created by akash on 20/11/17.
 */
public class FlightSearchPage extends AbstractModule {

    public void searchForFlights(WebDriver webDriver, Map<String, String> testData) {
        Assert.assertTrue(flightSearchPanel.searchForFlights(webDriver, testData), "Failed while searching for flights.");
        flightSearchPanel.waitForProgressBarToDisappear(webDriver);
    }

    public void openHomePage(WebDriver webDriver) {
        Assert.assertTrue(pageHeaderPanel.openHomePage(webDriver), "Failed while opening home page.");
    }

    public void clickSavedSearch(WebDriver webDriver, Map<String, String> testData) {
        Assert.assertTrue(flightSearchPanel.openSavedSearch(webDriver, testData), "Failed to open saved search.");
    }
}
