package fragments;

import org.openqa.selenium.WebDriver;
import utilities.WebDriverUtils;
import xpaths.BookingPanelXPaths;

/**
 * Created by akash on 21/11/17.
 */
public class BookingPanel implements BookingPanelXPaths {

    /**
     *  In these methods, it's sometimes better to have a single action per method, which would allow you to
     *  play around with different combinations in the 'page' abstraction layer.
     *  Also, this allows us to time each action, and can be used for benchmarking.
     *
     *  TODO: Most of these methods could be made generic with the use of lambda. Will do it if I get time in the end.
     */
    public boolean confirmInsurance(WebDriver webDriver) {
        WebDriverUtils wdUtils = new WebDriverUtils(webDriver);
        System.out.println("Confirming Insurance for flight travel.");
        try {
            wdUtils.clickElement(insuranceCheckbox);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insuranceContinueBooking(WebDriver webDriver) {
        WebDriverUtils wdUtils = new WebDriverUtils(webDriver);
        System.out.println("Continuing from Insurance section to next section.");
        try {
            wdUtils.clickElement(continueBookingButton);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean enterEmailDetails(WebDriver webDriver) {
        WebDriverUtils wdUtils = new WebDriverUtils(webDriver);
        System.out.println("Entering email details.");
        try {
            wdUtils.sendKeys(emailField, "testUser@gmail.com");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean continueFromEmailSection(WebDriver webDriver) {
        WebDriverUtils wdUtils = new WebDriverUtils(webDriver);
        System.out.println("Continuing from Email section to next section.");
        try {
            wdUtils.clickElement(emailContinueButton);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean enterTravellerDetails(WebDriver webDriver) {
        WebDriverUtils wdUtils = new WebDriverUtils(webDriver);
        System.out.println("Entering traveller details.");
        try {

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
