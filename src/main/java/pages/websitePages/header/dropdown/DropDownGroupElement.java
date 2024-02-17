package pages.websitePages.header.dropdown;

import lombok.Getter;

import java.util.Arrays;

public enum DropDownGroupElement {

    SMARTFONS("Smartfony"),
    SMARTWATCHES("Smartwatche i opaski"),
    LAPTOPS("Laptopy i tablety"),
    ROUTERS("Routery"),
    OTHER("Inne");

    @Getter
    private String name;

    DropDownGroupElement(String name) {
        this.name = name;
    }

    public static DropDownGroupElement getDropDownGroupElementByName(String name){
        return Arrays.
                stream(DropDownGroupElement.values()).
                filter(x-> x.getName().equals(name)).
                findFirst().
                orElseThrow();
    }
}
