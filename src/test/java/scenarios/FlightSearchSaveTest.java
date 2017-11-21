package scenarios;

import dataaccess.excelhelper.TestDataHeaders;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.BaseScenario;
import utilities.TestDataProvider;

import java.util.Map;

public class FlightSearchSaveTest extends BaseScenario{

    @Test(dataProvider = "test-data", dataProviderClass = TestDataProvider.class)
    public void checkSavedSearch(Map<String, String> testData) {
        WebDriver webDriver = webDriverPool.get();
        given(driver).navigateToAppUrl(webDriver);
        then(flightSearchPage).searchForFlights(webDriver, testData);
        and(flightSearchPage).openHomePage(webDriver);
        and(flightSearchPage).clickSavedSearch(webDriver, testData);

        and(flightResultsPage).bookCheapestFlight(webDriver);
        when(flightBookingPage).enterItineraryDetails(webDriver);
        then(flightBookingPage).enterEmailDetails(webDriver, testData.get(TestDataHeaders.emailID));
        and(flightBookingPage).enterTravellerDetails(webDriver, testData);
        and(flightBookingPage).verifyPaymentsSection(webDriver);
    }
}
