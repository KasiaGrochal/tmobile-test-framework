package utils;

public class StringConvertor {

    public static String removePolishCurrencyFromString(String price){
        return price.replace("zł", "").trim();
    }
}
