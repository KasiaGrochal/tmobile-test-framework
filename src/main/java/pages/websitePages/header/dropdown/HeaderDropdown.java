package pages.websitePages.header.dropdown;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.common.BasePage;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Slf4j
public class HeaderDropdown extends BasePage {

    public HeaderDropdown(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[class*='group-[.more-columns]']")
    private List<WebElement> headerDropDownGroups;

    public DropDownGroup chooseDropdownGroup(DropDownGroupElement dropDownGroupElement) {
        String dropDownGroupElementName = dropDownGroupElement.getName();
        log.info("Choosing dropdown group-category: {}", dropDownGroupElementName);
        try {
            return getVisibleDropdownGroups().
                    stream().
                    filter(x -> x.getGroupName().equals(dropDownGroupElementName)).
                    findFirst().
                    orElseThrow();
        } catch (NoSuchElementException e) {
            log.error("Dropdown Group Element: '{}' is not visible on the website", dropDownGroupElementName);
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public List<DropDownGroup> getVisibleDropdownGroups() {
        return headerDropDownGroups.
                stream().
                map(webElement -> new DropDownGroup(webElement, driver)).
                collect(Collectors.toList());
    }
}
