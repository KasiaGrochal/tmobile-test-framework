package pages.websitePages.devices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import pages.common.BasePage;
import pages.websitePages.productDetails.RightSideBarSummary;
import utils.StringConvertor;

import static enums.Timeouts.SHORT;
import static enums.Timeouts.STANDARD;

public class ProductBoxPage extends BasePage {

    public ProductBoxPage(WebElement productBox, WebDriver driver) {
        super(driver);
        DefaultElementLocatorFactory devicesPage = new DefaultElementLocatorFactory(productBox);
        PageFactory.initElements(devicesPage, this);
    }

    @FindBy(css = "a")
    private WebElement productHref;

    @FindBy(css = "section>div>h2")
    private WebElement productName;

    public RightSideBarSummary clickOnProduct() {
        String partOfUrl = StringConvertor.getProductNameFromWebUrl(getProductHref());
        clickOn(productHref, SHORT);
        waitProvider.waitForPageToLoad(partOfUrl, STANDARD);
        return new RightSideBarSummary(driver);
    }

    public String getProductHref() {
        return getWebelementHref(productHref);
    }

    public String getProductName() {
        return getWebelementTitle(productName);
    }
}
