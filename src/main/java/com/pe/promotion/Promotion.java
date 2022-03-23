package com.pe.promotion;

import com.pe.model.Cart;

public interface Promotion {

    // Applies the promotion to the cart and returns the rest of the cart
    Cart applyPromotion(Cart cart);



    // Returns the  price after the promotion applied
    int getPriceAfterPromotion();

    boolean isAvailable(Cart cart);
}
