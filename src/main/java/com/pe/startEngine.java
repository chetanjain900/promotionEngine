package com.pe;

import java.util.Scanner;

public class startEngine {



    public static void main(String[] args) {
        costCalculator calc=new costCalculator();
        Processor process =new Processor(calc);

        Scanner sc = new Scanner(System.in);


        System.out.println("Enter quantity value of SKU Id A");
        int skuIdA = sc.nextInt();

        System.out.println("Enter quantity value of SKU Id B");

        int skuIdB = sc.nextInt();

        System.out.println("Enter quantity value of SKU Id C");

        int skuIdC = sc.nextInt();

        System.out.println("Enter quantity value of SKU Id D");

        int skuIdD = sc.nextInt();

        int total = process.calculateCost(skuIdA, skuIdB, skuIdC, skuIdD);

        System.out.println("Output cost is :"+total);

    }
}
