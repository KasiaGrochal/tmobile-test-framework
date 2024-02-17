package pages.websitePages.header;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.common.BasePage;
import pages.websitePages.header.dropdown.HeaderDropdown;

import java.util.List;
import java.util.NoSuchElementException;

import static enums.Timeouts.SHORT;
import static enums.Timeouts.STANDARD;

@Slf4j
public class HeaderPage extends BasePage {

    private final String BASKETCOUNT_CSS_SELECTOR = "[data-ma='menu-basket']>div";
    @FindBy(css = "[class*='group menu-dropdown-item']")
    private List<WebElement> headerDropdownElements;
    @FindBy(css = BASKETCOUNT_CSS_SELECTOR)
    private List<WebElement> basket;

    public HeaderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HeaderDropdown openDropdown(HeaderElement headerElement) {
        clickOn(getHeaderElementByName(headerElement), STANDARD);
        return new HeaderDropdown(driver);
    }

    public Integer getBasketCount() {
        return Integer.parseInt(getText(getVisibleBasketCount(), SHORT));
    }


    private WebElement getHeaderElementByName(HeaderElement headerName) {
        String headerElementName = headerName.getName();
        try {
            return headerDropdownElements.
                    stream().
                    filter(x -> x.getText().equals(headerElementName)).
                    findFirst().
                    orElseThrow();
        } catch (NoSuchElementException e) {
            log.error("Header Element Name: '{}' is not visible on the website", headerElementName);
            throw new NoSuchElementException("Header Element Name: '{}' is not visible on the website");
        }
    }

    private WebElement getVisibleBasketCount() {
        return getVisibleElementFromTheList(BASKETCOUNT_CSS_SELECTOR, basket, STANDARD);
    }
}
