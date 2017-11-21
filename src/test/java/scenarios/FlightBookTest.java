package scenarios;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.BaseScenario;

/**
 * Created by akash on 20/11/17.
 */
public class FlightBookTest extends BaseScenario {

    @Test
    public void bookFlight() {
        WebDriver webDriver = webDriverPool.get();
        and(driver).navigateToAppUrl(webDriver);
        then(flightSearchPage).searchForFlights(webDriver);
        and(flightResultsPage).bookCheapestFlight(webDriver);
    }
}
