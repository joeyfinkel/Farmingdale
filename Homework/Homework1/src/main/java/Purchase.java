/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author joeyfinkel
 */
/**
 *
 */
public class Purchase {
  String itemName;
  double quantity;
  double itemPrice;

  /**
   * Initialize Purchase with default values.
   */
  public Purchase() {
    this.itemName = "";
    this.quantity = 0;
    this.itemPrice = 0;
  }

  /**
   * Creates a copy of the current instance of Purchase.
   *
   * @param purchase The Purchase object to create a copy of.
   */
  public Purchase(Purchase purchase) {
    this(purchase.itemName, purchase.quantity, purchase.itemPrice);
  }

  /**
   * Initialize Purchase with set values.
   *
   * @param itemName  The name of the item.
   * @param quantity  The quantity of the item.
   * @param itemPrice The price of the item.
   */
  public Purchase(String itemName, double quantity, double itemPrice) {
    this.itemName = itemName;
    this.quantity = quantity;
    this.itemPrice = itemPrice;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public double getQuantity() {
    return quantity;
  }

  public void setQuantity(double quantity) {
    this.quantity = quantity;
  }

  public double getItemPrice() {
    return itemPrice;
  }

  public void setItemPrice(double itemPrice) {
    this.itemPrice = itemPrice;
  }

  /**
   * Multiplies itemPrice and quantity.
   *
   * @return The qauntity of itemPrice and quantity.
   */
  public double cost() {
    return itemPrice * quantity;
  }

  /**
   * Creates a deep copy of Purchase class.
   *
   * @return The deep copy object.
   */
  public Purchase makeCopy() {
    Purchase purchase = new Purchase();

    purchase.itemName = this.itemName;
    purchase.itemPrice = this.itemPrice;
    purchase.quantity = this.quantity;

    return purchase;
  }

  /**
   * Checks if a Purchase object is equal to another Purchase object.
   * @param obj The object to check equality from.
   * @return The state of equality between both objects.
   */
  @Override
  public boolean equals(Object obj) {
    Purchase purchase = (Purchase) obj;

    if (obj == this) return true;
    if (!(obj instanceof Purchase)) return false;

    return this.itemName.equals(purchase.itemName)
            && Double.compare(this.itemPrice, purchase.itemPrice) == 0
            && Double.compare(this.quantity, purchase.quantity) == 0;
  }

  /***
   * The toString override to print out information about a Purchase instance.
   * @return A string with information about a Purchase object.
   */
  @Override
  public String toString() {
    return """
           Here is information about your object: 
           Item name: """ + this.getItemName() + "\n" +
            "Item price: " + this.getItemPrice() + "\n" +
            "Item quantity " + this.getQuantity();
  }
}

