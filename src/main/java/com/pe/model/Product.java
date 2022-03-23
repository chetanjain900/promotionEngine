package com.pe.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
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


}
