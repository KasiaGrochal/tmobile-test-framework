package stepDefinitions.header;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import pages.websitePages.header.HeaderPage;
import pages.websitePages.header.HeaderElement;
import stepDefinitions.testBase.Container;
import stepDefinitions.testBase.Hooks;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Slf4j
public class HeaderPageSteps {

    private HeaderPage headerPage;
    private HeaderElement headerElement;
    private Container container;

    public HeaderPageSteps(Hooks hooks, Container container) {
        this.headerPage = new HeaderPage(hooks.getDriver());
        this.container = container;
    }


    @When("I choose {string} from header")
    public void iChooseFromHeader(String headerValue) {
        headerElement = HeaderElement.getHeaderElementByName(headerValue);
        headerPage.openDropdown(headerElement);
    }

    @And("I see basket with quantity <{int}> visible")
    public void iSeeBasketWithQuantityVisible(int quantity) {
        int actual = headerPage.getBasketCount();
        log.info("Assert that visible basket count: '{}' is as expected: '{}'", actual, quantity);
        assertThat(actual, equalTo(quantity));
    }
}
