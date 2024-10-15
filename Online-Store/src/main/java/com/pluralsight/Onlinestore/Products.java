package com.pluralsight.Onlinestore;

public class Products {
    private String department;
    private String sku;
    private String name;
    private Double price;

    public Products(String department, String sku, String name, Double price) {
        this.department = department;
        this.sku = sku;
        this.name = name;
        this.price = price;
    }

    public String getDepartment() {
        return department;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}
