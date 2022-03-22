package com.pe;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class costCalculatorTest {

    costCalculator testCalculator=new costCalculator();
    @Test
    public void testCalculation1() {
        int result = testCalculator.calculateTotalCost(5,5,1,0);

        assertThat(result).isEqualTo(370);
    }

    @Test
    public void testCalculation2() {
        int result = testCalculator.calculateTotalCost(5,6,5,4);

        assertThat(result).isEqualTo(505);
    }

    @Test
    public void testCalculation3() {
        int result = testCalculator.calculateTotalCost(3,5,1,1);

        assertThat(result).isEqualTo(280);
    }

}
