package scenarios;

import org.testng.annotations.Test;
import utilities.BaseScenario;

/**
 * Created by akash on 19/11/17.
 */
public class SimpleTest extends BaseScenario {
    @Test
    public void simpleTest() {
        webDriver.get("https://www.cleartrip.com");
    }
}