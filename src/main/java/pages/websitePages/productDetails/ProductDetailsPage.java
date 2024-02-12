package pages.websitePages.productDetails;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class ProductDetailsPage extends BasePage {

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-qa='PRD_ProductName']")
    private WebElement productName;

    public String getProductName(){
        return waitAndGetText(productName);
    }
}
