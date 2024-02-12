package stepDefinitions;

import configuration.models.EnvironmentProperties;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import pages.websitePages.HomePage;
import stepDefinitions.testBase.Hooks;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Slf4j
public class HomePageSteps {
    private HomePage homePage;
    private EnvironmentProperties environmentProperties;

    public HomePageSteps(Hooks hooks) {
        this.homePage = new HomePage(hooks.getDriver());
        this.environmentProperties = Hooks.environmentProperties;
    }

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        homePage.openHomePage(environmentProperties).acceptHomePageCookies();
    }

    @Then("I see home page view")
    public void iSeeHomePageView() {
        assertThat(homePage.getHomePageTitle(), equalTo(environmentProperties.getHomePageTitle()));
        assertThat(homePage.getHomePageUrl(), equalTo(environmentProperties.getWebUrl()));
    }
}
