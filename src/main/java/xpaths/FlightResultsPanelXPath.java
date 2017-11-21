package xpaths;

/**
 * Created by akash on 21/11/17.
 */
public interface FlightResultsPanelXPath {
    String bookFlightButton         =   "//button[@class='booking' and normalize-space(text())='Book']";
    String resultsCount             =   "//p[@class='hCount' and contains(@style, 'display: block')]//strong[@class='resultsCount']";
    String firstNearbyAirportFilter =   "(//nav[@class='nearbyairportsDest']//input[@type='checkbox'])[1]";
}
