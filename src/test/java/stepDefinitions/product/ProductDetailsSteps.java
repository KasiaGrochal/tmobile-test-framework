package stepDefinitions.product;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import pages.websitePages.productDetails.ProductDetailsPage;
import pages.websitePages.productDetails.RightSideBarSummary;
import stepDefinitions.testBase.Container;
import stepDefinitions.testBase.Hooks;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Slf4j
public class ProductDetailsSteps {


    private ProductDetailsPage productDetailsPage;
    private RightSideBarSummary rightSideBarSummary;
    private Container container;

    public ProductDetailsSteps(Hooks hooks, Container container) {
        WebDriver driver = hooks.getDriver();
        this.productDetailsPage = new ProductDetailsPage(driver);
        this.rightSideBarSummary = new RightSideBarSummary(driver);
        this.container = container;
    }

    @Then("I see product page")
    public void iSeeProductPage() {
        String expected = container.product.getName();
        String actual = productDetailsPage.getProductName();
        log.info("Assert that visible product name: '{}' is as expected: '{}'", actual, expected);
        assertThat(actual, equalTo(expected));
    }

    @When("I add product to the basket")
    public void iAddProductToTheBasket() {
        container.product.setPriceUpfront(rightSideBarSummary.getToBePaidUpfrontPrice());
        container.product.setPriceMonthly(rightSideBarSummary.getToBePaidMonthly());
        rightSideBarSummary.addToBasket();
    }
}
