package com.pe.service;

import com.pe.model.Cart;
import com.pe.model.Product;
import com.pe.promotion.Promotion;
import com.pe.util.promotionUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PromotionServiceImpl implements PromotionService {
    @Override
    public int getPrice(Cart cart) {
        int price = 0;

        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            price = price + entry.getValue() * promotionUtil.getPrice(entry.getKey().getSKU_Name());
        }
        return price;
    }

    @Override
    public int getPriceAfterPromotion(Cart cart, List<Promotion> promotions) {
        int price = getPrice(cart);
        System.out.println("ohhhh"+price);
        return priceAfterPromotion(cart, promotions, price);
    }

    int priceAfterPromotion(Cart cart, List<Promotion> promotions, int totalPrice) {
        int offerPrice = 0;
        Promotion selectedPromotion = null;

        List<Promotion> promos = new ArrayList<>();
        for (Promotion promotion : promotions) {
            if (promotion.isAvailable(cart)) {
                promos.add(promotion);
            }
        }

        if (promos.isEmpty()) {
            return totalPrice;
        }

        for (Promotion promotion : promos) {
            int promotionPrice = promotion.getPriceAfterPromotion();
            if (promotionPrice > offerPrice) {
                offerPrice = promotionPrice;
                selectedPromotion = promotion;
            }
        }


        // Adjust the items in the cart after promotions are applied
        Cart totalCart = new Cart();
        if (selectedPromotion != null) {
            totalCart = selectedPromotion.applyPromotion(cart);
        }
        // Subtract the discounted price from the cart price since promotion was applied.
        totalPrice = totalPrice - offerPrice;
        // Recursive call to apply all available promotions on cart
        // Cart contents should be properly reduced so that the recursion loop will not occur.
        return priceAfterPromotion(totalCart, promos, totalPrice);

    }
}
