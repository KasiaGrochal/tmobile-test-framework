package pages.websitePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.common.BasePage;

import static enums.Timeouts.STANDARD;

public class CookiePage extends BasePage {
    public CookiePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[id*='agree']")
    private WebElement acceptCookiesButton;

    public HomePage acceptHomePageCookies(){
        clickOn(acceptCookiesButton, STANDARD);
        return new HomePage(driver);
    }
}
