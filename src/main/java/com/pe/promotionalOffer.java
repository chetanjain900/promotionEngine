package com.pe;

public class promotionalOffer {

    public static final int SKU_A_PRICE = 50;
    public static final int SKU_A_PROMO_PRICE = 130;

    public static final int SKU_B_PRICE = 30;
    public static final int SKU_B_PROMO_PRICE = 45;

    public static final int SKU_C_PRICE = 20;
    public static final int SKU_D_PRICE = 15;
    public static final int SKU_C_AND_D_PROMO_PRICE = 30;

    int total=0;
    boolean checForPromotion(String SKUId) {

        if (SKUId == "A") {
            return true;

        }
        if(SKUId == "B")
        return true;

        return false;
    }




    public int applyPromotionForSKUId_A(int quantA) {

        if (quantA >= 3) {
            int quotient = quantA / 3;
            int remainder = quantA % 3;

            total = (quotient >= 0) ? total + quotient * SKU_A_PROMO_PRICE : total;

            total = (remainder >= 0) ? total + remainder * SKU_A_PRICE : total;
        } else {

            total = total + quantA * SKU_A_PRICE;
        }

        return total;
    }

    public int applyPromotionForSKUId_B(int quantB) {
        if (quantB >= 2) {
            int quotient = quantB / 2;
            int remainder = quantB % 2;

            total = (quotient >= 0) ? total + quotient * SKU_B_PROMO_PRICE : total;

            total = (remainder >= 0) ? total + remainder * SKU_B_PRICE : total;
        } else {

            total = total + quantB * SKU_B_PRICE;
        }

        return total;
    }

    public int applyPromotionForSKUId_C_and_D(int quantC, int quantD) {
        if(quantC >=1 && quantD >=1 ) {

            total = (quantC == quantD ) ? total + quantC*SKU_C_AND_D_PROMO_PRICE : total;

            total = (quantC > quantD ) ?  total + (quantD*SKU_C_AND_D_PROMO_PRICE  + (quantC - quantD )*SKU_C_PRICE) : total ;

            total = (quantD > quantC ) ?  total + (quantC*SKU_C_AND_D_PROMO_PRICE  + (quantD - quantC )*SKU_D_PRICE) : total;

        }else {
            total =total + quantC * SKU_C_PRICE;

            total =total + quantD * SKU_D_PRICE;
        }
        return total;
    }
}
