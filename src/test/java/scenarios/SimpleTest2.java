package scenarios;

import org.testng.annotations.Test;
import utilities.BaseScenario;

/**
 * Created by akash on 19/11/17.
 */
public class SimpleTest2 extends BaseScenario {
    @Test
    public void test2() {
        webDriver.get("http://google.com");
    }
}
