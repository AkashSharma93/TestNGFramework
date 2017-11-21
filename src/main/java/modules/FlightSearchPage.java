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
}
