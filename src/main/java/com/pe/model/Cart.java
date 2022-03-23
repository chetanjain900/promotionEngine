package com.pe.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Cart {

    private Map<Product, Integer> items;




    public Cart(Map<Product, Integer> items) {
        this.items = items;
    }

    public Integer getQuantity(String itemName){
        for (Map.Entry<Product, Integer> kv: this.items.entrySet()) {
            if (kv.getKey().getSKU_Name().equalsIgnoreCase(itemName)) {
                return kv.getValue();
            }
        }
        return 0;
    }

    public Product getEntryByItemName(String item) {
        for (Map.Entry<Product, Integer> kv: items.entrySet()) {
            if (kv.getKey().getSKU_Name().equalsIgnoreCase(item)) {
                return kv.getKey();
            }
        }
        return null;
    }

    public Map<Product, Integer> adjustInventory(String itemName, Integer quantity) {
        Product productOut = null;
        Map<Product, Integer> temp = new HashMap<>();
        temp.putAll(this.items);

        for (Map.Entry<Product, Integer> kv: temp.entrySet()) {
            if (kv.getKey().getSKU_Name().equalsIgnoreCase(itemName)) {
                productOut = kv.getKey();
            }
        }
        if (null != productOut) {
            temp.put(productOut, quantity);
        }
        return temp;
    }

    public Map<Product, Integer> removeItem(String itemToRemove) {
        Product productToRemove = null;
        Map<Product, Integer> temp = new HashMap<>();
        temp.putAll(this.items);

        for (Map.Entry<Product, Integer> kv: temp.entrySet()) {
            if (kv.getKey().getSKU_Name().equalsIgnoreCase(itemToRemove)) {
                productToRemove = kv.getKey();
            }
        }
        if (itemToRemove != null) {
            temp.remove(productToRemove);
        }
        return temp;
    }
}
