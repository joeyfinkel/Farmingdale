/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author joeyfinkel
 */
public class NewMain {

    static String printEquality(Object p1, Object p2) {
    return "Object 1 is " + ((p1.equals(p2)) ? "the same as object 2." : "different from object 2");

  }

  public static void main(String[] args) {
    Purchase purchaseDefault = new Purchase();
    Purchase purchaseWithParams1 = new Purchase("Water Bottle", 10, 19.99);
    Purchase purchaseCopy = new Purchase(purchaseWithParams1);

    System.out.println("(Before change) " + purchaseDefault.toString());
    purchaseDefault.setItemName("Laptop");
    purchaseDefault.setItemPrice(445.89);
    purchaseDefault.setQuantity(3);
    System.out.println("\n");
    System.out.println("(After change) " + purchaseDefault.toString());
    System.out.println("\n");

    System.out.println(purchaseWithParams1.makeCopy());
    // When the objects are not equal
    System.out.println(printEquality(purchaseDefault, purchaseWithParams1));
    // When the objects are equal
    System.out.println(printEquality(purchaseWithParams1, purchaseCopy));
    // The cost of an item
    System.out.printf("The cost of the " + purchaseWithParams1.getItemName() + " is %.2f" , purchaseWithParams1.cost());
    System.out.println("\n\n\n\n");

    PurchaseCollection collection = new PurchaseCollection();
    PurchaseCollection collectionArr = new PurchaseCollection(new Purchase[]{new Purchase("Phone", 67, 90.99)});
    PurchaseCollection collectionCopy = new PurchaseCollection(collection);
    PurchaseCollection collectionCopy2 = collectionArr.makeCopy();

    System.out.println(collectionCopy);
    System.out.println(collectionArr);
    System.out.println("The size of the array is: " + collectionCopy.getSize());
    collectionCopy.resize(5);
    collectionCopy.set(4, new Purchase("Computer", 2, 999));
    System.out.println(collectionCopy.get(4));
    System.out.println(printEquality(collectionArr, collectionCopy2));
  }
    
}
