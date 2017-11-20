package genericshelper;

import modules.DriverModule;
import modules.FlightSearchPage;

/**
 * Created by akash on 20/11/17.
 */
public abstract class GenericsImpl {

    // Modules
    protected DriverModule driver;
    protected FlightSearchPage flightSearchPage;

    public GenericsImpl() {
        flightSearchPage = new FlightSearchPage();
        driver = new DriverModule();
    }

    /**
     *  These methods allow us to write tests in a more readable way.
     *  You need to have all your modules implement GenericModule.
     */
    protected <T extends GenericModule> T given(T module) {
        return module;
    }

    protected <T extends GenericModule> T when(T module) {
        return module;
    }

    protected <T extends GenericModule> T and(T module) {
        return module;
    }

    protected <T extends GenericModule> T then(T module) {
        return module;
    }
}
