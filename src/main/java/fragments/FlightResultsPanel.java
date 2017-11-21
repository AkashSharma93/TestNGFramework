package fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WebDriverUtils;
import xpaths.FlightResultsPanelXPath;

import java.util.Map;

/**
 * Created by akash on 21/11/17.
 */
public class FlightResultsPanel implements FlightResultsPanelXPath {

    public boolean bookFlightAtIndex(WebDriver webDriver, int index) {
        WebDriverUtils wdUtils = new WebDriverUtils(webDriver);
        System.out.println("Booking flight at index: " + index);
        try {
            wdUtils.clickElement(bookFlightButton);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     *  This is a very BASIC verification of filters.
     *  It just checks if the count of the results changes after hitting a filter.
     */
    public boolean verifyFilters(WebDriver webDriver, Map<String, String> testData) {
        WebDriverUtils wdUtils = new WebDriverUtils(webDriver);
        System.out.println("Verifying filters.");
        if (wdUtils.waitForElement(resultsCount, 10)) {
            String countBeforeFilter = webDriver.findElement(By.xpath(resultsCount)).getText();
            try {
                wdUtils.clickElement(firstNearbyAirportFilter);
                String countAfterFilter = webDriver.findElement(By.xpath(resultsCount)).getText();
                if (countBeforeFilter.equalsIgnoreCase(countAfterFilter)) { // Major assumption at this point that count WILL change after applying filter.
                    System.out.println("There is no change in count even after applying filter.");
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else {
            System.out.println("Result count not found.");
            return false;
        }
        return true;
    }
}
