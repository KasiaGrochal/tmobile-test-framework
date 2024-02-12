package stepDefinitions.testBase;

import configuration.ConfigReader;
import configuration.browser.Browser;
import configuration.browser.BrowserProvider;
import configuration.browser.DriverFactory;
import configuration.models.Config;
import configuration.models.EnvironmentProperties;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

@Data
@Slf4j
public class Hooks {

    public static Browser browser;
    private WebDriver driver;
    public static EnvironmentProperties environmentProperties;

    @BeforeAll
    public static void before_or_after_all() {
        Config config = new ConfigReader().getConfig();
        browser = BrowserProvider.getBrowser(config);
        environmentProperties = config.getEnvironmentProperties();
        log.info("Initialized environment properties");
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        driver = new DriverFactory().getDriver(browser);
        log.info("Start executing scenario: '{}'", scenario.getName());
    }


    @After
    public void tearDown(Scenario scenario) {
        hasScenarioFail(scenario);
        quitDriver();
    }

    private void hasScenarioFail(Scenario scenario){
        if (scenario.isFailed()) {
            log.error("Error while executing scenario: {}, test failed", scenario.getName());
        }
    }

    private void quitDriver(){
        if (driver != null) {
            log.info("Closing browser");
            driver.quit();
        } else {
            log.error("Driver was not set");
        }
    }
}