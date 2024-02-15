package pages.common;

import enums.Timeouts;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

@Slf4j
public class WaitProvider {

    protected FluentWait<WebDriver> wait;

    public WaitProvider(WebDriver driver) {
        this.wait = new FluentWait<>(driver).
                pollingEvery(Duration.ofSeconds(1));
    }


    protected void waitForWebElementToBeClickable(WebElement webElement, Timeouts timeout) {
        log.info("Start waiting for WebElement to be clickable- Timeout set to {} seconds", timeout.getTimeout());
        setNewTimeout(timeout);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected void waitForWebElementToBeVisible(WebElement webElement, Timeouts timeout) {
        log.info("Start waiting for WebElement to be clickable- Timeout set to {} seconds", timeout.getTimeout());
        setNewTimeout(timeout);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void waitForListOfWebelementsToBeMoreThan(String cssSelector, int moreThan, Timeouts timeout) {
        log.info("Start waiting for the List of Webelements to be more than {} - Timeout set to {} seconds", moreThan, timeout.getTimeout());
        setNewTimeout(timeout);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(cssSelector), moreThan));
    }

    public void waitForPageToLoad(String website, Timeouts timeout) {
        log.info("Wait for page with url '{}' to load. Timeout set to {} seconds", website, timeout.getTimeout());
        setNewTimeout(timeout);
        wait.until(ExpectedConditions.urlContains(website));
    }

    private void setNewTimeout(Timeouts timeout) {
        wait.withTimeout(timeout.getDurationOfSeconds());
    }
}
