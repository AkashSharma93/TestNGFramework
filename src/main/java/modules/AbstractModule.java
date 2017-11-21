package modules;

import fragments.BookingPanel;
import fragments.FlightResultsPanel;
import fragments.FlightSearchPanel;
import fragments.PageHeaderPanel;
import genericshelper.GenericModule;

/**
 * Created by akash on 20/11/17.
 */
public class AbstractModule implements GenericModule {

    // These are all the page fragments.
    protected FlightSearchPanel flightSearchPanel;
    protected FlightResultsPanel flightResultsPanel;
    protected PageHeaderPanel pageHeaderPanel;
    protected BookingPanel bookingPanel;

    public AbstractModule() {
        flightSearchPanel = new FlightSearchPanel();
        flightResultsPanel = new FlightResultsPanel();
        pageHeaderPanel = new PageHeaderPanel();
        bookingPanel = new BookingPanel();
    }
}
