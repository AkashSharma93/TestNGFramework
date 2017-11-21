package fragments;

import dataaccess.excelhelper.TestDataHeaders;
import org.openqa.selenium.WebDriver;
import utilities.WebDriverUtils;
import xpaths.BookingPanelXPaths;

import java.util.Map;

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

    public boolean enterEmailDetails(WebDriver webDriver, String emailID) {
        WebDriverUtils wdUtils = new WebDriverUtils(webDriver);
        System.out.println("Entering email details.");
        try {
            wdUtils.sendKeys(emailField, emailID);
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

    public boolean enterTravellerDetails(WebDriver webDriver, Map<String, String> testData) {
        WebDriverUtils wdUtils = new WebDriverUtils(webDriver);
        System.out.println("Entering traveller details.");

        String travellerName = testData.get(TestDataHeaders.travellerName);
        String nameTokens[] = travellerName.split(" ");
        String travellerTitle = nameTokens[0];
        String firstName = nameTokens[1];
        String lastName = nameTokens[2];
        String dob = testData.get(TestDataHeaders.dateOfBirth);
        String passportNumber = testData.get(TestDataHeaders.passportNumber);
        String visaType = testData.get(TestDataHeaders.visaType);
        String contactNumber = testData.get(TestDataHeaders.contactNumber);


        // Assuming I'll be adding only one traveller for now. Hence the '1' in the name.
        // TODO: Will need to handle the indexes in the future.
        try {
            wdUtils.selectFromList(getSelectXPath("AdultTitle1"), travellerTitle);
            wdUtils.sendKeys(getTextXPath("AdultFname1"), firstName);
            wdUtils.sendKeys(getTextXPath("AdultLname1"), lastName);

            String tokens[] = dob.split("/");
            wdUtils.selectFromList(getSelectXPath("AdultDobDay1"), tokens[0]);
            wdUtils.selectFromList(getSelectXPath("AdultDobMonth1"), tokens[1]);
            wdUtils.selectFromList(getSelectXPath("AdultDobYear1"), tokens[2]);

            wdUtils.sendKeys(getTextXPath("AdultPassport1"), passportNumber);
            wdUtils.selectFromList(getSelectXPath("AdultVisaType1"), visaType);
            wdUtils.sendKeys(getTextXPath("contact1"), contactNumber);
            wdUtils.clickElement(travellerContinueButton);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private String getSelectXPath(String id) {
        return selectField.replace("idToken", id);
    }

    private String getTextXPath(String name) {
        return textField.replace("nameToken", name);
    }

    public boolean verifyPaymentsSection(WebDriver webDriver) {
        WebDriverUtils wdUtils = new WebDriverUtils(webDriver);
        System.out.println("Verifying if Payments Section is open.");
        return wdUtils.waitForElement(paymentSection, 10);
    }
}
