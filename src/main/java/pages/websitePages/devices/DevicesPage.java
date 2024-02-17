package pages.websitePages.devices;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.common.BasePage;
import pages.websitePages.productDetails.RightSideBarSummary;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class DevicesPage extends BasePage {
    @FindBy(css = "[class*='dt_productCards']")
    private List<WebElement> listOfProducts;

    public DevicesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public RightSideBarSummary chooseFirstProductFromTheList() {
        log.info("Choosing first product from the list");
        return getFirstProductBoxFromTheList().clickOnProduct();
    }

    public ProductBoxPage getFirstProductBoxFromTheList() {
        return getListOfProductBoxes().get(0);
    }

    public List<ProductBoxPage> getListOfProductBoxes() {
        return listOfProducts.stream()
                .map(webElement -> new ProductBoxPage(webElement, driver))
                .collect(Collectors.toList());
    }
}
