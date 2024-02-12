package pages.websitePages.header;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.websitePages.header.dropdown.HeaderDropdown;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
public class HeaderPage extends BasePage {

    public HeaderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private final String BASKETCOUNT_CSS_SELECTOR = "[data-ma='menu-basket']>div";

    @FindBy(css = "[class*='group menu-dropdown-item']")
    private List<WebElement> headerDropdownElements;

    @FindBy(css = BASKETCOUNT_CSS_SELECTOR)
    private List<WebElement> basket;

    public HeaderDropdown openDropdown(HeaderElement headerElement){
        waitAndClickOn(getHeaderElementByName(headerElement));
        return new HeaderDropdown(driver);
    }

    public Integer getBasketCount(){
        return Integer.parseInt(waitAndGetText(getVisibleBasketCount()));
    }


    private WebElement getHeaderElementByName(HeaderElement headerName) {
        String headerElementName = headerName.getName();
        for (WebElement headerElement : headerDropdownElements) {
            if (headerElement.getText().equals(headerElementName)) {
                return headerElement;
            }
        }
        log.error("Header Element Name: '{}' is not visible on the website", headerElementName);
        throw new NoSuchElementException();
    }

    private WebElement getVisibleBasketCount(){
        return getVisibleElementFromTheList(BASKETCOUNT_CSS_SELECTOR,basket);
    }
}
