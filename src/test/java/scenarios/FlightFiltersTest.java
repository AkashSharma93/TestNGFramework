package scenarios;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.BaseScenario;
import utilities.TestDataProvider;

import java.util.Map;

public class FlightFiltersTest extends BaseScenario {

    @Test (dataProvider = "test-data", dataProviderClass = TestDataProvider.class)
    public void checkFilters(Map<String, String> testData) {
        WebDriver webDriver = webDriverPool.get();
        given(driver).navigateToAppUrl(webDriver);
        then(flightSearchPage).searchForFlights(webDriver, testData);
        and(flightResultsPage).verifyFilters(webDriver, testData);
    }
}
