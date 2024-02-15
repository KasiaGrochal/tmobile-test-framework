package pages.websitePages.header.dropdown;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import pages.common.BasePage;

import java.util.List;

import static enums.Timeouts.STANDARD;

public class DropDownGroup extends BasePage {
    @FindBy(css = "[class*='text']")
    private WebElement groupName;

    @FindBy(css = "ul>li>a")
    private List<WebElement> contractOptionsList;

    public DropDownGroup(WebElement dropdownGroup, WebDriver driver) {
        super(driver);
        DefaultElementLocatorFactory headerDropdown = new DefaultElementLocatorFactory(dropdownGroup);
        PageFactory.initElements(headerDropdown, this);
    }

    public DropDownGroup chooseContractOption(ContractOptions contractOptions) {
        clickOn(getContractOptionFromList(contractOptions), STANDARD);
        waitProvider.waitForPageToLoad(contractOptions.getPartOfTheUrl(), STANDARD);
        return this;
    }

    public String getGroupName() {
        return getText(groupName, STANDARD);
    }


    private WebElement getContractOptionFromList(ContractOptions contractOptions) {
        return contractOptionsList.stream().
                filter(webElement -> webElement.getText().equals(contractOptions.getName())).
                findFirst().
                orElseThrow();
    }


}

