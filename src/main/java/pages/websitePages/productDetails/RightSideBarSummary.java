package pages.websitePages.productDetails;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.common.BasePage;
import pages.websitePages.basket.BasketPage;

import java.util.List;

import static enums.Timeouts.SHORT;
import static enums.Timeouts.STANDARD;

public class RightSideBarSummary extends BasePage {

    private final String TO_BE_PAID_UPFRONT_CSS_SELECTOR = "[class*='upfront-panel']>div>div>div>div";
    private final String MONTHLY_PAYMENT_CSS_SELECTOR = "[class*='styles__StyledMonthly']>div>div>div>div";
    private final String ADD_TO_BASKET_CSS_SELECTOR = "[data-qa='PRD_AddToBasket']";

    public RightSideBarSummary(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = TO_BE_PAID_UPFRONT_CSS_SELECTOR)
    private List<WebElement> toBePaidUpfront;

    @FindBy(css = MONTHLY_PAYMENT_CSS_SELECTOR)
    private List<WebElement> toBePaidMonthly;

    @FindBy(css = ADD_TO_BASKET_CSS_SELECTOR)
    private List<WebElement> addToBasketButton;

    public String getToBePaidUpfrontPrice() {
        return getText(getVisibleElementFromTheList(TO_BE_PAID_UPFRONT_CSS_SELECTOR, toBePaidUpfront, STANDARD), SHORT);
    }

    public String getToBePaidMonthly() {
        return getText(getVisibleElementFromTheList(MONTHLY_PAYMENT_CSS_SELECTOR, toBePaidMonthly, STANDARD), SHORT);
    }

    public BasketPage addToBasket() {
        clickOn(getVisibleElementFromTheList(ADD_TO_BASKET_CSS_SELECTOR, addToBasketButton, STANDARD),SHORT);
        return new BasketPage(driver);
    }


}
