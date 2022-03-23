package com.pe.service;

import com.pe.model.Cart;
import com.pe.promotion.Promotion;

import java.util.List;

public interface PromotionService {

    int getPrice(Cart cart);

    int getPriceAfterPromotion(Cart cart, List<Promotion> promotions);
}
