/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.homework2;

/**
 * The driver class of the program.
 *
 * @author joeyf
 */
public class Homework2 {

    /**
     * THe main method to run everything.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {

        PurchaseList purchaseList = new PurchaseList();
        PurchaseList purchaseList2 = new PurchaseList();

        purchaseList.add(new Purchase());
        purchaseList.add(new Purchase("Phone", 12, 900));
        purchaseList.add(new Purchase("Computer", 12, 9000));
        purchaseList.add(new Purchase("Water Bottle", 1000, 200));
        purchaseList.show();
        System.out.printf("The most expensive item in the collection is the " + purchaseList.mostExpensivePurchase().getItemName() + " which costs $%.2f\n\n", purchaseList.mostExpensivePurchase().cost());

        purchaseList.remove("Phone");
        System.out.println("This is after removing from the list:");
        purchaseList.show();

        purchaseList.makeEmpty();
        purchaseList.show();

        purchaseList2.add(purchaseList);
        purchaseList2.show();
    }
}
