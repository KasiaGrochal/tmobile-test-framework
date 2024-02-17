package pages.websitePages.header;

import lombok.Getter;

import java.util.Arrays;

public enum HeaderElement {
    DEVICES("Urządzenia"),
    OFFER("Oferta"),
    INTERNET("Internet"),
    TV("Telewizja"),
    INFORMATION("Informacje");

    @Getter
    private String name;


    HeaderElement(String name) {
        this.name = name;
    }

    public static HeaderElement getHeaderElementByName(String name){
        return Arrays.
                stream(HeaderElement.values()).
                filter(x-> x.getName().equals(name)).
                findFirst().
                orElseThrow();
    }
}
