package com.pe;

public class costCalculator {

    public static final int SKU_A_PRICE = 50;
    public static final int PRICE_COMBO_SKUA = 130;
    public static final int SKU_B_PRICE = 30;
    public static final int PRICE_COMBO_SKUB = 45;
    public static final int SKU_C_PRICE = 20;
    public static final int SKU_D_PRICE = 15;
    public static final int PRICE_COMBO_SKUCD = 30;
    public int total = 0;

    promotionalOffer offer = new promotionalOffer();

    public int calculateTotalCost(int quantA, int quantB, int quantC, int quantD) {
        total = calculate_cost_sku_id_A(quantA, total);
        total = calculate_cost_sku_id_B(quantB, total);
        total = calculate_cost_sku_id_C_and_D(quantC, quantD, total);

        return total;
    }

    private int calculate_cost_sku_id_C_and_D(int quantC, int quantD, int total) {
                  return offer.applyPromotionForSKUId_C_and_D(quantC,quantD);

    }

    private int calculate_cost_sku_id_B(int quantB, int total) {
        if (offer.checForPromotion("B")) {
            total = offer.applyPromotionForSKUId_B(quantB);
        }

        return total;
    }

    private int calculate_cost_sku_id_A(int quantA, int total) {

        if (offer.checForPromotion("A")) {
            total = offer.applyPromotionForSKUId_A(quantA);
        }

        return total;

    }
}
