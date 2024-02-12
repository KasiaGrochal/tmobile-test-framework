package pages;

import enums.Timeouts;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import static enums.Timeouts.*;

@Slf4j
public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    protected void waitAndClickOn(WebElement webElement) {
        waitForWebElementToBeClickable(webElement, SHORT);
        log.info("Click on webelement '{}'", webElement);
        webElement.click();
    }

    protected String waitAndGetText(WebElement webElement) {
        waitForWebElementToBeVisible(webElement, SHORT);
        String text = webElement.getText();
        log.info("Retrieved text from webelement '{}'", text);
        return text;
    }

    protected String getCurrentWebUrl() {
        String currentUrl = driver.getCurrentUrl();
        log.info("Retrieving current url'{}'", currentUrl);
        return currentUrl;
    }

    protected String getWebelementHref(WebElement webElement) {
        waitForWebElementToBeVisible(webElement, SHORT);
        String href = webElement.getAttribute("href");
        log.info("Retrieving href from webelemebt'{}'", href);
        return href;
    }

    protected String getWebelementTitle(WebElement webElement) {
        waitForWebElementToBeVisible(webElement, SHORT);
        String title = webElement.getAttribute("title");
        log.info("Retrieving title from webelemebt'{}'", title);
        return title;
    }

    protected String getCurrentPageTitle() {
        String currentPageTitle = driver.getTitle();
        log.info("Retrieving current url'{}'", currentPageTitle);
        return currentPageTitle;
    }

    protected WebElement getVisibleElementFromTheList(String cssSelector, List<WebElement> listOfWebelements) {
        waitForListOfWebelementsToBeMoreThan(cssSelector, 0, STANDARD);
        for (WebElement element : listOfWebelements) {
            if (element.isDisplayed()) {
                return element;
            }
        }
        throw new NoSuchElementException();
    }

    protected void waitForWebElementToBeClickable(WebElement webElement, Timeouts timeout) {
        log.info("Start waiting for WebElement to be clickable- Timeout set to {} seconds", timeout.getTimeout());
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected void waitForWebElementToBeVisible(WebElement webElement, Timeouts timeout) {
        log.info("Start waiting for WebElement to be clickable- Timeout set to {} seconds", timeout.getTimeout());
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void waitForListOfWebelementsToBeMoreThan(String cssSelector, int moreThan, Timeouts timeout) {
        log.info("Start waiting for the List of Webelements to be more than {} - Timeout set to {} seconds", moreThan, timeout.getTimeout());
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(cssSelector), moreThan));
    }

    protected void waitForPageToLoad(String website) {
        log.info("Wait for page with url '{}' to load", website);
        new WebDriverWait(driver, Duration.ofSeconds(LONG.getTimeout()))
                .until(ExpectedConditions.urlContains(website));
    }

}
