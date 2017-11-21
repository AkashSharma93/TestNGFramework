package modules;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Created by akash on 21/11/17.
 */
public class FlightBookingPage extends AbstractModule {

    public void enterItineraryDetails(WebDriver webDriver) {
        Assert.assertTrue(bookingPanel.confirmInsurance(webDriver), "Failed to confirm insurance.");
        Assert.assertTrue(bookingPanel.insuranceContinueBooking(webDriver), "Failed to continue booking in insurance section.");
    }

    public void enterEmailDetails(WebDriver webDriver) {
        Assert.assertTrue(bookingPanel.enterEmailDetails(webDriver), "Failed to enter email address.");
        Assert.assertTrue(bookingPanel.continueFromEmailSection(webDriver), "Failed to continue in email section.");
    }

    public void enterTravellerDetails(WebDriver webDriver) {
        Assert.assertTrue(bookingPanel.enterTravellerDetails(webDriver), "Failed to enter traveller details.");
    }
}
