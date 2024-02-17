package utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringConvertor {

    private static final String DEVICE = "urzadzenie/";
    private static final String DEVICE_NAME_TO_CURRENT_PAGE_DIVIDOR = "?";

    public static String removePolishCurrencyFromString(String price) {
        return price.replace("zł", "").trim();
    }

    public static String getProductNameFromWebUrl(String webUrl) {
        return getStringBefore(getStringAfter(webUrl, DEVICE), DEVICE_NAME_TO_CURRENT_PAGE_DIVIDOR);
    }

    public static String getStringAfter(String mainString, String trimAfterThis) {
        return mainString.split(trimAfterThis)[1].trim();
    }

    public static String getStringBefore(String mainString, String trimBeforeThis) {
        return mainString.substring(0, mainString.indexOf(trimBeforeThis));
    }
}
