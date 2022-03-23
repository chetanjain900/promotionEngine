package com.pe.promotion;

import com.pe.model.Cart;
import com.pe.model.Product;
import com.pe.util.promotionUtil;

import java.util.HashMap;
import java.util.Map;

public class SingleSKUPromotion implements Promotion {

    private String offerItem;
    private Integer quota;
    private int totalPrice;

    public SingleSKUPromotion(String offerItem, Integer quota, int totalPrice) {
        this.offerItem = offerItem;
        this.quota = quota;
        this.totalPrice = totalPrice;
    }


    @Override
    public Cart applyPromotion(Cart cart) {
        if(cart.getItems().isEmpty())
            return cart;



        Cart totalCart = new Cart(cart.getItems());

        int cartQuantity = totalCart.getQuantity(offerItem);
        Map<Product, Integer> updatedContents = new HashMap<>();

        if(cartQuantity - quota == 0) {
            updatedContents.putAll(totalCart.removeItem(offerItem));
        }
        else {
            updatedContents.putAll(totalCart.adjustInventory(offerItem, cartQuantity - quota));
        }

        totalCart.setItems(updatedContents);
        return totalCart;
    }

    @Override
    public int getPriceAfterPromotion() {
        return (promotionUtil.getPrice(offerItem) * this.quota) - this.totalPrice;
    }

    @Override
    public boolean isAvailable(Cart cart) {
        for(Map.Entry<Product, Integer> kv: cart.getItems().entrySet()){
            if(kv.getKey().getSKU_Name().equalsIgnoreCase(offerItem) && kv.getValue() >= quota)
                return true;
        }
        return false;
    }
}
