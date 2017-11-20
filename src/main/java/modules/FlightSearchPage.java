package modules;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Created by akash on 20/11/17.
 */
public class FlightSearchPage extends AbstractModule {

    public void searchForFlights(WebDriver webDriver) {
        Assert.assertTrue(flightSearchPanel.searchForFlights(webDriver), "Failed while searching for flights.");
    }
}
