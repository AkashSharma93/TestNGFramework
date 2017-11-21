package modules;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Created by akash on 21/11/17.
 */
public class FlightResultsPage extends AbstractModule {

    public void bookCheapestFlight(WebDriver webDriver) {
        Assert.assertTrue(flightResultsPanel.bookFlightAtIndex(webDriver, 0), "Failed to select cheapest flight.");
    }
}
