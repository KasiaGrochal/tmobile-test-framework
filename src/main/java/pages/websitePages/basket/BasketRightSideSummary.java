package pages.websitePages.basket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class BasketRightSideSummary extends BasePage {

    public BasketRightSideSummary(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-qa='BKT_TotalupFront']")
    private WebElement toBePaidUpfrontPrice;

    @FindBy(css = "[data-qa='BKT_TotalMonthly']")
    private WebElement toBePaidMonthlyPrice;

    public String getToBePaidUpfrontPrice(){
        return waitAndGetText(toBePaidUpfrontPrice);
    }

    public String getToBePaidMonthly(){
        return waitAndGetText(toBePaidMonthlyPrice);
    }


}
