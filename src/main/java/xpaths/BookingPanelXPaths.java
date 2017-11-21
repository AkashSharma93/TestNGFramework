package xpaths;

/**
 * Created by akash on 21/11/17.
 */
public interface BookingPanelXPaths {

    // Itinerary section.
    String insuranceCheckbox        =   "//input[@type='checkbox' and @name='insuranceConfirm']";
    String continueBookingButton    =   "//input[@id='itineraryBtn' and @value='Continue booking']";

    // Email section.
    String emailField               =   "//input[@type='email']";
    String emailContinueButton      =   "//input[@class='booking hotelButton' and @value='Continue']";

    // Traveller section.
    String textField                =   "//input[@name='nameToken']";
    String selectField              =   "//select[@id='idToken']";
    String travellerContinueButton  =   "//input[@id='travellerBtn' and @value='Continue']";

    // Payment Section.
    String paymentSection           =   "//div[@id='paymentOpen' and not(contains(@style, 'display: none'))]";
}
