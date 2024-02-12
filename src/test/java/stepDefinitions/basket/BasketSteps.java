package stepDefinitions.basket;

import configuration.models.EnvironmentProperties;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import pages.websitePages.basket.BasketPage;
import pages.websitePages.basket.BasketRightSideSummary;
import stepDefinitions.testBase.Container;
import stepDefinitions.testBase.Hooks;
import utils.StringConvertor;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Slf4j
public class BasketSteps {

    private BasketPage basketPage;
    private BasketRightSideSummary basketRightSideSummary;
    private Container container;
    private EnvironmentProperties environmentProperties;

    public BasketSteps(Hooks hooks, Container container) {
        WebDriver driver = hooks.getDriver();
        this.basketPage = new BasketPage(driver);
        this.basketRightSideSummary = new BasketRightSideSummary(driver);
        this.container = container;
        this.environmentProperties = Hooks.environmentProperties;
    }

    @Then("I see basket page")
    public void iSeeBasketPage() {
        String expected = environmentProperties.getBasketHeaderText();
        String actual = basketPage.getBasketHeaderText();
        log.info("Assert that visible basket header text: '{}' is as expected: '{}'", actual, expected);
        assertThat(actual, equalTo(expected));
    }

    @And("Visible prices are the same as seen previously")
    public void visiblePricesAreTheSameAsSeenPreviously() {
        String expectedPriceUpfront = StringConvertor.removePolishCurrencyFromString(container.product.getPriceUpfront());
        String expectedPriceMonthly = StringConvertor.removePolishCurrencyFromString(container.product.getPriceMonthly());
        String actualPriceUpfront = basketRightSideSummary.getToBePaidUpfrontPrice();
        String actualPriceMonthly = basketRightSideSummary.getToBePaidMonthly();
        log.info("Assert that visible price to be paid upfront: '{}' is as expected: '{}'", actualPriceUpfront, expectedPriceUpfront);
        assertThat(actualPriceUpfront, equalTo(expectedPriceUpfront));
        log.info("Assert that visible price to be paid monthly: '{}' is as expected: '{}'", actualPriceMonthly, expectedPriceMonthly);
        assertThat(actualPriceMonthly, equalTo(expectedPriceMonthly));
    }

    @When("I go to home page")
    public void iGoToHomePage() {
        basketPage.clickOnTMobileLogo();
    }
}
