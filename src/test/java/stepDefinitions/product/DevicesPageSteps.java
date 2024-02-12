package stepDefinitions.product;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import models.Product;
import pages.websitePages.devices.DevicesPage;
import pages.websitePages.devices.ProductBoxPage;
import stepDefinitions.testBase.Container;
import stepDefinitions.testBase.Hooks;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Slf4j
public class DevicesPageSteps {

    private DevicesPage devicesPage;
    private Container container;

    public DevicesPageSteps(Hooks hooks, Container container) {
        this.devicesPage = new DevicesPage(hooks.getDriver());
        this.container = container;
    }

    @Then("List of products is visible")
    public void listOfProductsIsVisible() {
        boolean areProductsFromCorrectCategoryVisible =
                devicesPage.
                        getListOfProductBoxes().
                        stream().
                        allMatch(x -> x.getProductHref().contains(container.contractOptions.getPartOfTheUrl()));
        log.info("Assert that list of appropriate products is visible");
        assertThat(areProductsFromCorrectCategoryVisible, is(true));
    }

    @When("I choose first product from the list")
    public void iChooseFirstProductFromTheList() {
        ProductBoxPage productBoxPage = devicesPage.getFirstProductBoxFromTheList();
        Product product = new Product();
        product.setName(productBoxPage.getProductName());
        container.product = product;
        productBoxPage.clickOnProduct();
    }
}
