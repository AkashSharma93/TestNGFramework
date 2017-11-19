package scenarios;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by akash on 19/11/17.
 */
public class SimpleTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void simpleTest() throws InterruptedException {
        driver.get("http://google.com");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
