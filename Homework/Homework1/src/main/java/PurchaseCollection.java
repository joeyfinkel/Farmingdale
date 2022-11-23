/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author joeyfinkel
 */
import java.util.Arrays;

public class PurchaseCollection {
  private Purchase[] purchases = new Purchase[3];

  public PurchaseCollection() {
    purchases = new Purchase[]{
            new Purchase("Rug", 3, 78.99),
            new Purchase("Shoe", 89, 59.99),
            new Purchase("Perfume", 65, 72.79),
    };
  }

  public PurchaseCollection(Purchase[] purchases) {
    this.purchases = purchases;
  }

  public PurchaseCollection(PurchaseCollection other) {
    this.purchases = other.purchases.clone();
    System.out.println("Copy constructor called");

  }

  /**
   * Sets the value at the given index to purchase if the index is valid.
   *
   * @param idx      The index to set.
   * @param purchase The value to set at the given index.
   */
  void set(int idx, Purchase purchase) {
    if (idx > purchases.length)
      System.out.println("Index " + idx + " is greater than the length of purchase.");

    purchases[idx] = purchase;
  }

  /**
   * Gets the value at the given index if it exists.
   *
   * @param idx The index to get the value from.
   * @return The index's value or null.
   */
  Purchase get(int idx) {
    return idx < purchases.length ? purchases[idx] : null;
  }

  /**
   * Gets the size of the array.
   *
   * @return The amount of elements present in the array.
   */
  int getSize() {
    return this.purchases.length;
  }

  /**
   * Creates a deep copy of the current instance.
   *
   * @return The copy of the current instance.
   */
  PurchaseCollection makeCopy() {
    PurchaseCollection collection = new PurchaseCollection();

    collection.purchases = this.purchases.clone();

    return collection;
  }

  /**
   * Checks if this array is equal to the object param's array.
   *
   * @param obj The object to compare to.
   * @return The equality state between both objects.
   */
  @Override
  public boolean equals(Object obj) {
    PurchaseCollection collection = (PurchaseCollection) obj;

    if (obj == this) return true;
    if (!(obj instanceof PurchaseCollection)) return false;

    return Arrays.equals(this.purchases, collection.purchases);
  }

  /**
   * Resizes the Purchase array.
   *
   * @param newPurchaseCollectionSize The size of the new array.
   * @return The resized array.
   */
  void resize(int newPurchaseCollectionSize) {
    this.purchases = Arrays.copyOf(this.purchases, newPurchaseCollectionSize);

  }

  @Override
  public String toString() {
    return "PurchaseCollection{" +
            "purchases=" + Arrays.toString(purchases) +
            '}';
  }
}

