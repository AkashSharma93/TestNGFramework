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
    String progressBar = "//div[@class='updatingModal whiteWash' and contains(@style, 'display: block')]/following-sibling::div[@class='loaderContainer' and not(contains(@style, 'display: none'))]";
    String savedSearch = "//strong[text()='sourceToken → destinationToken']";
    String roundTripButton = "//input[@type='radio' and @id='RoundTrip']";
}
