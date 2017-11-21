package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by akash on 19/11/17.
 */
public class WebDriverUtils {
    private WebDriver webDriver;
    private int timeout = 10;  // Default timeout until repeated tries.

    public WebDriverUtils(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    private boolean invokeAgainInCaseOfFailure(Runnable action) throws Exception {
        return invokeAgainInCaseOfFailure(action, 0);
    }

    private boolean invokeAgainInCaseOfFailure(Runnable action, int recursionLevel) throws Exception {
        try {
            action.run();
        } catch (Exception e) {
            if (recursionLevel > 0) {   // Fail
                throw e;
            } else {    // Try again
                return invokeAgainInCaseOfFailure(action, recursionLevel + 1);
            }
        }
        return true;
    }

    public void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(webDriver, 20, 500);
        wait.until((WebDriver webDriver) -> {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
            return javascriptExecutor.executeScript("return document.readyState").equals("complete");
        });

    }

    public ExpectedCondition<WebElement> isElementVisible(String xpath) {
        waitForPageLoad();

        return (WebDriver webDriver) -> {
            WebElement webElement = webDriver.findElement(By.xpath(xpath));
            if (webElement != null && webElement.isEnabled() && webElement.isDisplayed()) {
                return webElement;
            }
            return null;
        };
    }

    public boolean waitForElement(String xpath, int waitTime) {
        System.out.println(String.format("Waiting for - xpath: %s  Wait-time: %d", xpath, waitTime));
        try {
            return invokeAgainInCaseOfFailure(getWaitForElementAction(xpath, waitTime));
        } catch (Exception e) {
            // Masking this exception, as waitForElement can be used for negative scenarios too.
        }
        return false;
    }

    // Returning a runnable, as I may want to use this action outside the scope of invokeAgain method.
    private Runnable getWaitForElementAction(String xpath, int waitTime) {
        return () -> {
            Wait<WebDriver> wait = new WebDriverWait(webDriver, waitTime);
            wait.until(isElementVisible(xpath));
        };
    }

    public boolean clickElement(String xpath) throws Exception {
        System.out.println(String.format("Clicking - xpath: %s", xpath));
        return invokeAgainInCaseOfFailure(getClickElementAction(xpath, timeout));
    }

    private Runnable getClickElementAction(String xpath, int waitTime) throws Exception {
        return () -> {
            getWaitForElementAction(xpath, waitTime).run(); // Not trying again, as it will be handled as part of clickElement.
            WebElement webElement = webDriver.findElement(By.xpath(xpath));
            webElement.click();
        };
    }

    public boolean sendKeys(String xpath, String text) throws Exception {
        System.out.println(String.format("Sending keys - xpath: %s  Text: %s", xpath, text));
        return invokeAgainInCaseOfFailure(getSendKeysAction(xpath, text, timeout));
    }

    private Runnable getSendKeysAction(String xpath, String text, int waitTime) {
        return () -> {
            getWaitForElementAction(xpath, waitTime).run();
            WebElement webElement = webDriver.findElement(By.xpath(xpath));
            webElement.clear();
            webElement.sendKeys(text);
        };
    }

    public boolean selectFromList(String xpath, String option) throws Exception {
        System.out.println(String.format("Selecting - xpath: %s Option: %s", xpath, option));
        if (!waitForElement(xpath, timeout)) {
            return false;
        }
        WebElement selectField = webDriver.findElement(By.xpath(xpath));
        Select select = new Select(selectField);
        select.selectByVisibleText(option);
        return true;
    }
}
