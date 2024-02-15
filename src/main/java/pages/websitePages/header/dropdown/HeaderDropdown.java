package pages.websitePages.header.dropdown;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.common.BasePage;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

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
        for (DropDownGroup visibleElement : getVisibleDropdownGroups()) {
            if (visibleElement.getGroupName().equals(dropDownGroupElementName)) {
                log.info("Choosing dropdown group-category: {}", dropDownGroupElementName);
                return visibleElement;
            }
        }
        log.error("Dropdown Group Element: '{}' is not visible on the website", dropDownGroupElementName);
        throw new NoSuchElementException();
    }


    public List<DropDownGroup> getVisibleDropdownGroups() {
        List<DropDownGroup> listOfDropDownGroups = new ArrayList<>();
        for (WebElement group : headerDropDownGroups) {
            if (group.isDisplayed()) {
                listOfDropDownGroups.add(new DropDownGroup(group, driver));
            }
        }
        return listOfDropDownGroups;
    }
}
