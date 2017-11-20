package utilities;

import dataaccess.PropertyReader;
import genericshelper.GenericsImpl;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

/**
 * Created by akash on 19/11/17.
 */
public class BaseScenario extends GenericsImpl {
    @BeforeSuite
    public void setupSuite() {
        ChromeDriverManager.getInstance().setup();
        InternetExplorerDriverManager.getInstance().setup();
        FirefoxDriverManager.getInstance().setup();

        PropertyReader.loadConfigProperties();
    }

    @BeforeMethod
    public void setupTest(Method method) {
        System.out.println("Starting test method - " + method.getName());
    }

    @AfterMethod
    public void teardownTest(ITestResult result, Method method) {
        System.out.println("Ending test method - " + method.getName());
        if (result.getStatus() == ITestResult.FAILURE) {
            if (result.getThrowable() != null) {
                System.out.println(result.getThrowable());
            }
        }
    }
}
