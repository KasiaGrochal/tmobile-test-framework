package pages.websitePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class CookiePage extends BasePage {
    public CookiePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[id*='agree']")
    private WebElement acceptCookiesButton;

    public HomePage acceptHomePageCookies(){
        waitAndClickOn(acceptCookiesButton);
        return new HomePage(driver);
    }
}
