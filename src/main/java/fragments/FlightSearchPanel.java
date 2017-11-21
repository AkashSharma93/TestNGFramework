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
        int timeout = 60;   // seconds
        long startTime = System.currentTimeMillis();

        System.out.println("Waiting for Progress Bar to disappear. Timeout [in sec]: " + timeout);
        while (wdUtils.waitForElement(progressBar, 1)) {
            try {
                Thread.sleep(500);  // Retry after 500 ms.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long currentTime = System.currentTimeMillis();
            int timeElapsed = (int) (currentTime - startTime) / 1000;
            if (timeElapsed > timeout) {
                break;
            }
        }

        System.out.println("Completed waiting for Progress Bar to disappear. Time elapsed: " + timeWaited);
    }
}
