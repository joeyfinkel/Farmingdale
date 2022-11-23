package com.mycompany.homework1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author joeyfinkel
 */
public class NewMain {
  /**
   * The main function to run.
   *
   * @param args CLI args.
   */
  public static void main(String[] args) {
    // #region Stack
    PurchaseStack stack = new PurchaseStack("Phone", 94, 890.99);
    stack.push(new Purchase("Mouse", 2, 20));
    stack.push(new Purchase("Laptop", 3412, 1_200.99));
    stack.push(new Purchase("Xbox", 784, 500.99));
    stack.push(new Purchase("Computer", 784, 500.99));

    PurchaseStack deepCopyStack = new PurchaseStack(stack);

    stack.show();
    System.out.print("(Deep copy) ");
    deepCopyStack.show();

    try {
      System.out.println("Here is the the purchase at the top of the stack: " + stack.top());
    } catch (Exception e) {
      System.out.println(e);
    }

    stack.makeEmpty();
    stack.show();
    // #endregion

    System.out.println("-----------------------------------------------------------------------------------");

    // #region Queue
    PurchaseQueue queue = new PurchaseQueue();

    // To show that queue is empty.
    queue.show();

    queue.enqueue(new Purchase("Pants", 12, 34));
    queue.enqueue(new Purchase("Shirt", 12, 34));
    queue.enqueue(new Purchase("Lego", 1200, 9.89));

    System.out.println("Length of queue before: " + queue.getLength()); // 3
    System.out.println("First item: " + queue.dequeue()); // { itemName: Pants, itemPrice: 34.0, itemQuantity: 12.0 }

    queue.show();

    PurchaseQueue deepQueue = new PurchaseQueue(queue);

    deepQueue.show();

    // #endregion
  }

}
