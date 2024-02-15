package pages.websitePages.basket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.common.BasePage;
import pages.websitePages.HomePage;

import static enums.Timeouts.SHORT;
import static enums.Timeouts.STANDARD;

public class BasketPage extends BasePage {

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[class='logoWrap']")
    private WebElement tMobileLogo;

    @FindBy(css = "[class*='basketHeaderText']")
    private WebElement basketHeaderText;

    public HomePage clickOnTMobileLogo(){
        clickOn(tMobileLogo, SHORT);
        return new HomePage(driver);
    }

    public String getBasketHeaderText(){
        return getText(basketHeaderText, STANDARD);
    }

}
