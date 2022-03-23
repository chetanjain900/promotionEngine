package com.pe.util;

import com.pe.promotion.GroupSKUPromotion;
import com.pe.promotion.Promotion;
import com.pe.promotion.SingleSKUPromotion;

import java.util.*;

public class promotionUtil {

    private static Map<String, Integer> products = new HashMap<>();

    static {
        products.put("A", 50);
        products.put("B", 30);
        products.put("C", 20);
        products.put("D", 15);
    }

    public static int getPrice(String productName) {
        return products.get(productName);
    }

    public static List<Promotion> addPromotions() {
        List<Promotion> promotions = new ArrayList<>();
        GroupSKUPromotion groupSKUPromotion = new GroupSKUPromotion(Arrays.asList("C", "D"), 30);
        SingleSKUPromotion SingleSKUPromotionA = new SingleSKUPromotion("A", 3, 130);
        SingleSKUPromotion SingleSKUPromotionB = new SingleSKUPromotion("B",2, 45);
        promotions.add(groupSKUPromotion);
        promotions.add(SingleSKUPromotionA);
        promotions.add(SingleSKUPromotionB);
        return promotions;
    }
}
