package com.pe.promotion;

import com.pe.model.Cart;
import com.pe.model.Product;
import com.pe.util.promotionUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupSKUPromotion implements Promotion{

    private List<String> offerItems = new ArrayList<>();
    private int promotedPrice;
    private Map<String, Boolean> checkAvailability = new HashMap<>();

    public GroupSKUPromotion(List<String> items, int promotedPrice) {
        this.offerItems.addAll(items);
        this.promotedPrice = promotedPrice;
    }



    @Override
    public Cart applyPromotion(Cart cart) {


        Cart offeredCart = new Cart(cart.getItems());
        Map<Product, Integer> cartContents = new HashMap<>(cart.getItems());

        for(String item: offerItems){
            if(offeredCart.getQuantity(item)==1) {
                cartContents.remove(offeredCart.getEntryByItemName(item));
            }
            else {
                cartContents.putAll(offeredCart.adjustInventory(item,offeredCart.getQuantity(item)-1));
            }
        }
        offeredCart.setItems(cartContents);
        return offeredCart;
    }



    @Override
    public int getPriceAfterPromotion() {
        int itemPrice = 0;
        for(String sku: offerItems)
            itemPrice += promotionUtil.getPrice(sku);

        return itemPrice - this.promotedPrice;
    }

    @Override
    public boolean isAvailable(Cart cart) {
        offerItems.forEach(i -> checkAvailability.put(i, false));

        for (Map.Entry<Product, Integer> kv: cart.getItems().entrySet()) {
            if (offerItems.contains(kv.getKey().getSKU_Name())) {
                checkAvailability.put(kv.getKey().getSKU_Name(), true);
            }
        }

        return !checkAvailability.containsValue(false);
    }
}
