package pages.websitePages.header.dropdown;

import lombok.Getter;

import java.util.Arrays;

import static pages.websitePages.header.dropdown.DropDownGroupElement.SMARTWATCHES;
@Getter
public enum ContractOptions {

    WITH_CONTRACT("Z abonamentem", SMARTWATCHES, "watch"),
    FOR_KIDS("Dla dzieci", SMARTWATCHES, "watch"),
    FOR_ELDERLY("Dla seniora", SMARTWATCHES, "watch"),
    NO_CONTRACT("Bez abonamentu", SMARTWATCHES, "watch");

    private String name;

    private String partOfTheUrl;

    private DropDownGroupElement dropDownGroupElement;


    ContractOptions(String name, DropDownGroupElement dropDownGroupElement, String partOfTheUrl) {
        this.name = name;
        this.dropDownGroupElement = dropDownGroupElement;
        this.partOfTheUrl = partOfTheUrl;
    }

    public static ContractOptions getContractOptionByName(String name){
        return Arrays.
                stream(ContractOptions.values()).
                filter(x-> x.getName().equals(name)).
                findFirst().
                orElseThrow();
    }
}
