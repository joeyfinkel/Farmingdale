package com.mycompany.homework1;

/**
 * Class to create a stack of {@link Purchase}s.
 */
public class PurchaseStack {
  private Node<Purchase> top;

  /**
   * Sets the {@code top} to null.
   */
  public PurchaseStack() {
    this.top = null;
  }

  /**
   * Adds a {@link Purchase} to the stack.
   *
   * @param itemName  The name of the item.
   * @param quantity  The item's quantity.
   * @param itemPrice The item's price.
   */
  public PurchaseStack(String itemName, double quantity, double itemPrice) {
    this.top = new Node<Purchase>();
    this.top.data = new Purchase(itemName, quantity, itemPrice);
  }

  /**
   * Creates a deep copy of {@code stack}.
   *
   * @param stack The object to create a deep copt of.
   */
  public PurchaseStack(PurchaseStack stack) {
    this.top = stack.top;
  }

  /**
   * Adds a new element to the stack.
   *
   * @param g The new purchase to add to the stack.
   */
  void push(Purchase g) {
    Node<Purchase> temp = new Node<Purchase>();

    temp.data = g;
    temp.next = this.top;
    this.top = temp;
  }

  /**
   * Removes the top element from the PurchaseStack.
   *
   * @throws Exception If the stack is empty.
   */
  void pop() throws Exception {
    // Checks for stack underflow
    if (this.isEmpty())
      throw new Exception("Stack underflow");

    // Updates the pointer so it points to the next node.
    this.top = this.top.next;
  }

  /**
   * Shows the contents of the stack.
   */
  void show() {
    if (!this.isEmpty()) {
      Node<Purchase> temp = this.top;

      System.out.println("Here is the stack of " + this.getLength() + " purchases:\n[");

      while (temp != null) {
        System.out.println("  " + temp.data);

        temp = temp.next;
      }

      System.out.println("]");
    } else {
      System.out.println("The stack is empty");
    }
  }

  /**
   * Clears the stack of all values.
   */
  void makeEmpty() {
    this.top = null;
  }

  /**
   * Gets the length of the PurchaseStack.
   *
   * @return The amount of elements in the stack.
   */
  int getLength() {
    Node<Purchase> temp = this.top;
    int count = 0;

    while (temp != null) {
      count++;

      temp = temp.next;
    }

    return count;
  }

  /**
   * Creates a deep copy of the current instance.
   *
   * @return The newly deep copied object.
   */
  PurchaseStack makeCopy() {
    PurchaseStack stack = null;

    if (!this.isEmpty()) {
      Node<Purchase> temp = this.top;

      while (temp != null) {
        Purchase data = temp.data;
        stack = new PurchaseStack(data.itemName, data.quantity, data.itemPrice);
        temp = temp.next;
      }
    }

    return stack;
  }

  /**
   * Checks if the stack is empty.
   *
   * @return The state of the stack.
   */
  boolean isEmpty() {
    return this.top == null;
  }

  /**
   * Gets the top item of the stack.
   *
   * @return The top item of the stack.
   * @throws Exception If the stack is empty.
   */
  Purchase top() throws Exception {
    if (this.isEmpty())
      throw new Exception("Stack underflow");

    return this.top.data;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    // TODO Implement...
    return super.clone();
  }



}
