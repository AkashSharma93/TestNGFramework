package modules;

import fragments.FlightSearchPanel;
import fragments.PageHeaderPanel;
import genericshelper.GenericModule;

/**
 * Created by akash on 20/11/17.
 */
public class AbstractModule implements GenericModule {

    // These are all the page fragments.
    protected FlightSearchPanel flightSearchPanel;
    protected PageHeaderPanel pageHeaderPanel;

    public AbstractModule() {
        flightSearchPanel = new FlightSearchPanel();
        pageHeaderPanel = new PageHeaderPanel();
    }
}
