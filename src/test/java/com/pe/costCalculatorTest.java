package com.pe;

import com.pe.model.Cart;
import com.pe.model.Product;
import com.pe.promotion.Promotion;
import com.pe.service.PromotionService;
import com.pe.service.PromotionServiceImpl;
import com.pe.util.promotionUtil;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import java.io.SyncFailedException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class costCalculatorTest {
    private static PromotionService promotionService;
    private static List<Promotion> promotions;
    private static Cart cart;
    private static Product productA;
    private static Product productB;
    private static Product productC;
    private static Product productD;

    @BeforeAll
    public static void setup() {
        promotionService = new PromotionServiceImpl();
        promotions = promotionUtil.addPromotions();

    }


    costCalculator testCalculator=new costCalculator();
    @Test
    public void testCalculation1() {
        int result = testCalculator.calculateTotalCost(1,1,1,0);

        assertThat(result).isEqualTo(100);
    }

    @Test
    public void testCalculation2() {
        int result = testCalculator.calculateTotalCost(5,5,1,0);

        assertThat(result).isEqualTo(370);
    }

    @Test
    public void testCalculation3() {
        int result = testCalculator.calculateTotalCost(3,5,1,1);

        assertThat(result).isEqualTo(280);
    }

    @Test
    public void testCartWithNoAvailablePromotion() {
        Map<Product, Integer> items = new HashMap<>();
        items.put(new Product("A"), 1);
        items.put(new Product("B"), 1);
        items.put(new Product("C"), 1);

        Cart cart =new Cart();
        PromotionServiceImpl promotionService = new PromotionServiceImpl();
        List<Promotion> promotions = promotionUtil.addPromotions();

        cart.setItems(items);
        System.out.println(cart.getItems());



        int totalPrice = promotionService.getPriceAfterPromotion(cart, promotions);
        System.out.println(totalPrice);
        assertThat(totalPrice).isEqualTo(100);

    }

    @Test
    public void testCartWithPromotion() {
        Map<Product, Integer> items = new HashMap<>();
        items.put(new Product("A"), 5);
        items.put(new Product("B"), 5);
        items.put(new Product("C"), 1);

        Cart cart =new Cart();
        PromotionServiceImpl promotionService = new PromotionServiceImpl();
        List<Promotion> promotions = promotionUtil.addPromotions();

        cart.setItems(items);
        System.out.println(cart.getItems());



        int totalPrice = promotionService.getPriceAfterPromotion(cart, promotions);
        System.out.println(totalPrice);
        assertThat(totalPrice).isEqualTo(370);

    }

    @Test
    public void testCartWithGroupPromotion() {
        Map<Product, Integer> items = new HashMap<>();
        items.put(new Product("A"), 3);
        items.put(new Product("B"), 5);
        items.put(new Product("C"), 1);
        items.put(new Product("D"), 1);

        Cart cart =new Cart();
        PromotionServiceImpl promotionService = new PromotionServiceImpl();
        List<Promotion> promotions = promotionUtil.addPromotions();

        cart.setItems(items);
        System.out.println(cart.getItems());



        int totalPrice = promotionService.getPriceAfterPromotion(cart, promotions);
        System.out.println(totalPrice);
        assertThat(totalPrice).isEqualTo(280);

    }

}
