package utils;

import enums.Timeouts;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

@Slf4j
public class WaitProvider {

    protected FluentWait<WebDriver> wait;

    public WaitProvider(WebDriver driver) {
        this.wait = new FluentWait<>(driver).
                pollingEvery(Duration.ofSeconds(1)).
                ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
    }

    public void waitForWebElementToBeClickable(WebElement webElement, Timeouts timeout) {
        log.info("Start waiting for WebElement to be clickable- Timeout set to {} seconds", timeout.getTimeout());
        setNewTimeout(timeout).until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitForWebElementToBeVisible(WebElement webElement, Timeouts timeout) {
        log.info("Start waiting for WebElement to be clickable- Timeout set to {} seconds", timeout.getTimeout());
        setNewTimeout(timeout).until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitForListOfWebelementsToBeMoreThan(String cssSelector, int moreThan, Timeouts timeout) {
        log.info("Start waiting for the List of Webelements to be more than {} - Timeout set to {} seconds", moreThan, timeout.getTimeout());
        setNewTimeout(timeout).until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(cssSelector), moreThan));
    }

    public void waitForPageToLoad(String website, Timeouts timeout) {
        log.info("Wait for page with url '{}' to load. Timeout set to {} seconds", website, timeout.getTimeout());
        setNewTimeout(timeout).until(ExpectedConditions.urlContains(website));
    }

    private FluentWait<WebDriver> setNewTimeout(Timeouts timeout) {
        return wait.withTimeout(timeout.getDurationOfSeconds());
    }
}
