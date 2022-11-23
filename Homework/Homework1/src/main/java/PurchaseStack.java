public class PurchaseStack {
  private Node top;

  public PurchaseStack() {
    this.top = null;
  }

  public PurchaseStack(Purchase[] purchases) {
    for (int i = 0; i < purchases.length; i++) {
      this.top.data = new Purchase();
    }
  }

  public PurchaseStack(String itemName, double quantity, double itemPrice) {
    this.top.data = new Purchase(itemName, quantity, itemPrice);
  }

  public PurchaseStack(PurchaseStack stack) {
    this.top = stack.top;
  }

  /**
   * Adds a new element to the stack.
   *
   * @param g The new purchase to add to the stack.
   */
  void push(Purchase g) {
    Node temp = new Node();
    // #TODO If is full...

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
   * Gets the length of the PurchaseStack.
   *
   * @return The amount of elements in the stack.
   */
  int getLength() {
    Node temp = this.top;
    int count = 0;

    while (temp != null) {
      count++;

      temp = temp.next;
    }

    return count;
  }

  PurchaseStack makeCopy() {
    return new PurchaseStack(this.top.data.itemName, this.top.data.quantity, this.top.data.itemPrice);
  }

  /**
   * Checks if the stack is empty.
   *
   * @return The state of the stack.
   */
  boolean isEmpty() {
    return this.top == null;
  }

  Purchase top() throws Exception {
    if (this.isEmpty())
      throw new Exception("Stack underflow");

    return this.top.data;
  }

  class Node {
    Purchase data;
    Node next;
  }
}
