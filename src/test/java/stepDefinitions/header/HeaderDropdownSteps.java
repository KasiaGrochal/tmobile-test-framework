package stepDefinitions.header;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import pages.websitePages.header.dropdown.HeaderDropdown;
import pages.websitePages.header.HeaderElement;
import pages.websitePages.header.dropdown.ContractOptions;
import stepDefinitions.testBase.Container;
import stepDefinitions.testBase.Hooks;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static pages.websitePages.header.dropdown.ContractOptions.getContractOptionByName;
import static pages.websitePages.header.dropdown.DropDownGroupElement.getDropDownGroupElementByName;

@Slf4j
public class HeaderDropdownSteps {

    private HeaderDropdown headerDropdown;
    private HeaderElement headerElement;
    private Container container;

    public HeaderDropdownSteps(Hooks hooks, Container container) {
        this.headerDropdown = new HeaderDropdown(hooks.getDriver());
        this.container = container;
    }

    @Then("Header dropdown list is visible")
    public void headerDropdownListIsVisible() {
        log.info("Assert that the header dropdown list is visible");
        assertThat(headerDropdown.getVisibleDropdownGroups(), not(equalTo(0)));
    }

    @When("I choose {string} from {string} column")
    public void iChooseFromColumn(String contractOption, String column) {
        ContractOptions contractOptions = getContractOptionByName(contractOption);
        headerDropdown.
                chooseDropdownGroup(getDropDownGroupElementByName(column)).
                chooseContractOption(contractOptions);
        container.contractOptions = contractOptions;
    }
}
