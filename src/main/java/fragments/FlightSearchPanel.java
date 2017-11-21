package fragments;

import dataaccess.excelhelper.TestDataHeaders;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.WebDriverUtils;
import xpaths.FlightSearchPanelXPaths;

import java.util.Map;

/**
 * Created by akash on 20/11/17.
 */
public class FlightSearchPanel implements FlightSearchPanelXPaths {
    private int waitTime = 10;

    public boolean searchForFlights(WebDriver webDriver, Map<String, String> testData) {
        WebDriverUtils wdUtils = new WebDriverUtils(webDriver);
        Assert.assertTrue(wdUtils.waitForElement(searchFlightForm, waitTime), "Flight search form not found.");

        String fromCity = testData.get(TestDataHeaders.fromCity);
        String toCity = testData.get(TestDataHeaders.toCity);
        String fromAirport = testData.get(TestDataHeaders.fromAirport);
        String toAirport = testData.get(TestDataHeaders.toAirport);
        String airportXpathToken = "airportName";

        String fromDate = testData.get(TestDataHeaders.fromDate);
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
        int timeElapsed = 0;    // Initializing here, to print it in the end for the method.

        System.out.println("Waiting for Progress Bar to disappear. Timeout [in sec]: " + timeout);
        while (wdUtils.waitForElement(progressBar, 1)) {
            try {
                Thread.sleep(500);  // Retry after 500 ms.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long currentTime = System.currentTimeMillis();
            timeElapsed = (int) (currentTime - startTime) / 1000;
            if (timeElapsed > timeout) {
                break;
            }
        }

        System.out.println("Completed waiting for Progress Bar to disappear. Time elapsed: " + timeElapsed);
    }

    public boolean openSavedSearch(WebDriver webDriver, Map<String, String> testData) {
        WebDriverUtils wdUtils = new WebDriverUtils(webDriver);
        System.out.println("Opening Saved Search.");
        String source = testData.get(TestDataHeaders.fromCity);
        String destination = testData.get(TestDataHeaders.toCity);
        try {
            wdUtils.clickElement(savedSearch.replace("sourceToken", source)
                    .replace("destinationToken", destination));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
