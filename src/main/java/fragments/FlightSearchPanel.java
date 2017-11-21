package fragments;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.WebDriverUtils;
import xpaths.FlightSearchPanelXPaths;

/**
 * Created by akash on 20/11/17.
 */
public class FlightSearchPanel implements FlightSearchPanelXPaths {
    private int waitTime = 10;

    public boolean searchForFlights(WebDriver webDriver) {
        WebDriverUtils wdUtils = new WebDriverUtils(webDriver);
        Assert.assertTrue(wdUtils.waitForElement(searchFlightForm, waitTime), "Flight search form not found.");

        String fromCity = "Bangalore";
        String toCity = "Tokyo";
        String fromAirport = "Bangalore, IN - Kempegowda International Airport (BLR)";
        String toAirport = "Tokyo, JP - Narita (NRT)";
        String airportXpathToken = "airportName";

        String fromDate = "30/11/2017";
        try {
            wdUtils.sendKeys(fromField, fromCity);
            wdUtils.clickElement(fieldSuggestion.replace(airportXpathToken, fromAirport));

            wdUtils.sendKeys(toField, toCity);
            wdUtils.clickElement(fieldSuggestion.replace(airportXpathToken, toAirport));

            String[] tokens = fromDate.split("/");
            String day = tokens[0];
            String month = (Integer.parseInt(tokens[1]) - 1) + "";
            String year = tokens[2];

            wdUtils.clickElement(datePicker
                    .replace("dayToken", day)
                    .replace("monthToken", month)
                    .replace("yearToken", year));

            wdUtils.clickElement(searchButton);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void waitForProgressBarToDisappear(WebDriver webDriver) {
        WebDriverUtils wdUtils = new WebDriverUtils(webDriver);
        int timeout = 30;  // Wait for progress bar for upto 1 min. [waitForElement tries twice. So, 30 * 2 = 60 sec.]
        int timeWaited = 0;

        System.out.println("Waiting for Progress Bar to disappear. Timeout [in sec]: " + timeout * 2);
        while (wdUtils.waitForElement(progressBar, 1)) {
            timeWaited++;
            if (timeWaited > timeout) break;
        }

        System.out.println("Completed waiting for Progress Bar to disappear. Time elapsed: " + timeWaited);
    }
}
