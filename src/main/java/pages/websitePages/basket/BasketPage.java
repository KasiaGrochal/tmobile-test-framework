package pages.websitePages.basket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.websitePages.HomePage;

public class BasketPage extends BasePage {

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[class='logoWrap']")
    private WebElement tMobileLogo;

    @FindBy(css = "[class*='basketHeaderText']")
    private WebElement basketHeaderText;

    public HomePage clickOnTMobileLogo(){
        waitAndClickOn(tMobileLogo);
        return new HomePage(driver);
    }

    public String getBasketHeaderText(){
        return waitAndGetText(basketHeaderText);
    }

}
