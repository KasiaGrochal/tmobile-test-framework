package pages.common;

import enums.Timeouts;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.NoSuchElementException;

import static enums.Timeouts.SHORT;

@Slf4j
public class BasePage {

    protected WebDriver driver;
    protected WaitProvider waitProvider;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        waitProvider = new WaitProvider(driver);
        PageFactory.initElements(driver, this);
    }

    protected void clickOn(WebElement webElement, Timeouts timeout) {
        waitProvider.waitForWebElementToBeClickable(webElement, timeout);
        log.info("Click on webelement '{}'", webElement);
        webElement.click();
    }

    protected String getText(WebElement webElement, Timeouts timeout) {
        waitProvider.waitForWebElementToBeVisible(webElement, timeout);
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
        waitProvider.waitForWebElementToBeVisible(webElement, SHORT);
        String href = webElement.getAttribute("href");
        log.info("Retrieving href from webelemebt'{}'", href);
        return href;
    }

    protected String getWebelementTitle(WebElement webElement) {
        waitProvider.waitForWebElementToBeVisible(webElement, SHORT);
        String title = webElement.getAttribute("title");
        log.info("Retrieving title from webelemebt'{}'", title);
        return title;
    }

    protected String getCurrentPageTitle() {
        String currentPageTitle = driver.getTitle();
        log.info("Retrieving current url'{}'", currentPageTitle);
        return currentPageTitle;
    }

    protected WebElement getVisibleElementFromTheList(String cssSelector, List<WebElement> listOfWebelements, Timeouts timeout) {
        waitProvider.waitForListOfWebelementsToBeMoreThan(cssSelector, 0, timeout);
        for (WebElement element : listOfWebelements) {
            if (element.isDisplayed()) {
                return element;
            }
        }
        throw new NoSuchElementException();
    }

}
