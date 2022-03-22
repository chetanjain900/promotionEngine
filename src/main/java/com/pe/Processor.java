package com.pe;

public class Processor {

    private costCalculator calc;

    private int total;


    public Processor(costCalculator calc) {
        this.total = 0;
        this.calc = calc;
    }
    public int calculateCost(int skuIdA, int skuIdB, int skuIdC, int skuIdD) {


                total = calc.calculateTotalCost(skuIdA, skuIdB, skuIdC, skuIdD);


        return total;
    }
}
