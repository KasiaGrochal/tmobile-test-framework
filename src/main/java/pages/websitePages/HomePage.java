package pages.websitePages;

import configuration.models.EnvironmentProperties;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import pages.common.BasePage;

@Slf4j
public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public CookiePage openHomePage(EnvironmentProperties environmentProperties){
        String webUrl = environmentProperties.getWebUrl();
        log.info("Opening website at: {}", webUrl);
        driver.get(webUrl);
        return new CookiePage(driver);
    }

    public String getHomePageUrl(){
        return getCurrentWebUrl();
    }

    public String getHomePageTitle(){
        return getCurrentPageTitle();
    }
}
