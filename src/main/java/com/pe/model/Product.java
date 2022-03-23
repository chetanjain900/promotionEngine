package com.pe.model;

public class Product {
    private String SKU_Name;
    private int price;

    public Product(String SKU_Name) {
        this.SKU_Name = SKU_Name;
    }

    public Product(String name, int price) {
        this.SKU_Name = SKU_Name;
        this.price = price;
    }

    public String getSKU_Name() {
        return SKU_Name;
    }

    public void setSKU_Name(String SKU_Name) {
        this.SKU_Name = SKU_Name;
    }



    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "SKU_Name='" + SKU_Name + '\'' +
                ", price=" + price +
                '}';
    }
}
