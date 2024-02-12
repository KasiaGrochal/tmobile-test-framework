package pages.websitePages.header.dropdown;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import pages.BasePage;

import java.util.List;

public class DropDownGroup extends BasePage {
    public DropDownGroup(WebElement dropdownGroup, WebDriver driver) {
        super(driver);
        DefaultElementLocatorFactory headerDropdown = new DefaultElementLocatorFactory(dropdownGroup);
        PageFactory.initElements(headerDropdown, this);
    }

    @FindBy(css = "[class*='text']")
    private WebElement groupName;

    @FindBy(css = "ul>li>a")
    private List<WebElement> contractOptionsList;

    public DropDownGroup chooseContractOption(ContractOptions contractOptions) {
        waitAndClickOn(getContractOptionFromList(contractOptions));
        waitForPageToLoad(contractOptions.getPartOfTheUrl());
        return this;
    }

    public String getGroupName() {
        return waitAndGetText(groupName);
    }


    private WebElement getContractOptionFromList(ContractOptions contractOptions) {
        return contractOptionsList.stream().
                filter(webElement -> webElement.getText().equals(contractOptions.getName())).
                findFirst().
                orElseThrow();
    }


}

