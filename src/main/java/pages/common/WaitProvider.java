package pages.common;

import enums.Timeouts;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static enums.Timeouts.SHORT;

@Slf4j
public class WaitProvider {

    protected WebDriverWait wait;
    private Duration duration;

    public WaitProvider(WebDriver driver) {
        this.wait = new WebDriverWait(driver, SHORT.getTimeout());
    }


    protected void waitForWebElementToBeClickable(WebElement webElement, Timeouts timeout) {
        duration = timeout.getTimeout();
        log.info("Start waiting for WebElement to be clickable- Timeout set to {} seconds", duration);
        wait.withTimeout(duration);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected void waitForWebElementToBeVisible(WebElement webElement, Timeouts timeout) {
        duration = timeout.getTimeout();
        log.info("Start waiting for WebElement to be clickable- Timeout set to {} seconds", duration);
        wait.
                withTimeout(duration).
                until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void waitForListOfWebelementsToBeMoreThan(String cssSelector, int moreThan, Timeouts timeout) {
        duration = timeout.getTimeout();
        log.info("Start waiting for the List of Webelements to be more than {} - Timeout set to {} seconds", moreThan, duration);
        wait.
                withTimeout(timeout.getTimeout()).
                until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(cssSelector), moreThan));
    }

    public void waitForPageToLoad(String website, Timeouts timeout) {
        duration = timeout.getTimeout();
        log.info("Wait for page with url '{}' to load. Timeout set to {} seconds", website, duration);
        wait.
                withTimeout(duration).
                until(ExpectedConditions.urlContains(website));
    }
}
