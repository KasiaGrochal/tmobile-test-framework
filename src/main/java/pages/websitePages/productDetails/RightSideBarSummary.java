package pages.websitePages.productDetails;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.websitePages.basket.BasketPage;

import java.util.List;

public class RightSideBarSummary extends BasePage {
    public RightSideBarSummary(WebDriver driver) {
        super(driver);
    }

    private final String TO_BE_PAID_UPFRONT_CSS_SELECTOR = "[class*='upfront-panel']>div>div>div>div";
    private final String MONTHLY_PAYMENT_CSS_SELECTOR = "[class*='styles__StyledMonthly']>div>div>div>div";
    private final String ADD_TO_BASKET_CSS_SELECTOR = "[data-qa='PRD_AddToBasket']";

    @FindBy(css = TO_BE_PAID_UPFRONT_CSS_SELECTOR)
    private List<WebElement> toBePaidUpfront;

    @FindBy(css = MONTHLY_PAYMENT_CSS_SELECTOR)
    private List<WebElement> toBePaidMonthly;

    @FindBy(css = ADD_TO_BASKET_CSS_SELECTOR)
    private List<WebElement> addToBasketButton;

    public String getToBePaidUpfrontPrice() {
        return waitAndGetText(getVisibleElementFromTheList(TO_BE_PAID_UPFRONT_CSS_SELECTOR, toBePaidUpfront));
    }

    public String getToBePaidMonthly() {
        return waitAndGetText(getVisibleElementFromTheList(MONTHLY_PAYMENT_CSS_SELECTOR, toBePaidMonthly));
    }

    public BasketPage addToBasket() {
        waitAndClickOn(getVisibleElementFromTheList(ADD_TO_BASKET_CSS_SELECTOR, addToBasketButton));
        return new BasketPage(driver);
    }


}
