package xpaths;

/**
 * Created by akash on 20/11/17.
 */
public interface FlightSearchPanelXPaths {
    String searchFlightForm = "//form[@id='SearchForm']";
    String fromField = searchFlightForm + "//input[@id='FromTag']";
    String toField = searchFlightForm + "//input[@id='ToTag']";
    String fieldSuggestion = "//ul[@class='autoComplete']//a[text()='airportName']";
    String datePicker = "//td[@data-handler='selectDay' and @data-month='monthToken' and @data-year='yearToken']/a[text()='dayToken']";
    String searchButton = "//input[@id='SearchBtn' and @value='Search flights']";
}
