package models;

import lombok.Data;

@Data
public class Product {
    private String name;
    private String href;
    private String priceUpfront;
    private String priceMonthly;
}
