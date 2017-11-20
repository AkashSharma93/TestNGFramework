package modules;

import fragments.FlightSearchPanel;
import genericshelper.GenericModule;

/**
 * Created by akash on 20/11/17.
 */
public class AbstractModule implements GenericModule {

    // These are all the page fragments.
    protected FlightSearchPanel flightSearchPanel;

    public AbstractModule() {
        flightSearchPanel = new FlightSearchPanel();
    }
}
