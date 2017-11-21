package fragments;

import org.openqa.selenium.WebDriver;
import utilities.WebDriverUtils;
import xpaths.FlightResultsPanelXPath;

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
}
