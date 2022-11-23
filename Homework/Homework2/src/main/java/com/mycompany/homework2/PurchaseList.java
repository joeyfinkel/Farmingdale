/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.homework2;

import java.util.Objects;

/**
 * This is the class used to create a linked list of Purchases.
 *
 * @author joeyf
 */
public class PurchaseList {

    private Node head;
    private int length;

    /**
     * Sets head to null and length to 0.
     */
    public PurchaseList() {
        this.head = null;
        this.length = 0;
    }

    /**
     * Creates a deep copy of the parameter.
     *
     * @param other The object to create a deep copy of.
     */
    public PurchaseList(PurchaseList other) {
        PurchaseList list = new PurchaseList();

        list.head.data.itemName = other.head.data.itemName;
        list.head.data.itemPrice = other.head.data.itemPrice;
        list.head.data.quantity = other.head.data.quantity;
    }

    /**
     * Gets the length of the list.
     *
     * @return The length of the list.
     */
    int getLength() {
        Node current = this.head;
        int listLength = 0;

        while (current != null) {
            current = current.next;

            listLength++;
        }

        return listLength;
    }

    /**
     * Adds data to the front.
     *
     * @param data The data to insert.
     */
    void add(Purchase data) {
        Node node = new Node();

        node.data = data;
        node.next = this.head;
        this.head = node;

        this.length++;
    }

    /**
     * Adds whatever is in list to the current instance, performing a deep copy.
     *
     * @param list The values to add onto the current instance.
     */
    void add(PurchaseList list) {
        Node current = this.head;

        while (current != null) {

            current.data.itemName = list.head.data.itemName;
            current.data.itemPrice = list.head.data.itemPrice;
            current.data.quantity = list.head.data.quantity;

            current.next = list.head.next;
        }
    }

    /**
     * Removes a node from the list by item name.
     *
     * @param itemName The item to remove.
     * @return The current instance of the list.
     */
    Purchase remove(String itemName) {
        Node current = this.head;

        // If the item to delete is at the head
        if (current != null && current.data.itemName.equals(itemName)) {
            this.head = this.head.next;
        }

        // If the item to delete is somewhere else
        while (current != null && !current.data.itemName.equals(itemName)) {
            current = this.head.next;
        }
        if (this.head != null) {
            current.next = current.next.next;
        }

        return current.data;

    }

    /**
     * Gets the most expensive item in the collection if not null.
     *
     * @return The most expensive Purchase in the collection.
     */
    Purchase mostExpensivePurchase() {
        Node current = this.head;

        if (this.getLength() == 0) {
            return null;
        } else {
            if (current.data.cost() > current.next.data.cost()) {
                return current.data;
            } else {
                current = current.next;
                return current.data;
            }

        }
    }

    /**
     * Prints out the list to the console.
     */
    void show() {
        Node node = this.head;
        String leftAlignFormat = "| %-12s | %.2f  | %.2f |%n";

        if (this.getLength() == 0) {
            System.out.println("The list is empty. There is nohing to print.");
        } else {
            System.out.println("Length of list is: " + this.getLength());
            System.out.format("+-----------------------+----------+%n");
            System.out.format("|        Current values (" + this.getLength() + ")        |%n");
            System.out.format("|----------------------------------|%n");
            System.out.format("| Name         | Price  | Quantity |%n");
            System.out.format("+----------------------------------+%n");

        }

        while (node != null) {
            for (int i = 0; i < this.length; i++) {
                System.out.format(leftAlignFormat, node.data.itemName, node.data.itemPrice, node.data.quantity);
                node = node.next;
            }

            System.out.format("+-----------------------+----------+%n");

        }

    }

    /**
     * Clears all items in the list.
     */
    void makeEmpty() {
        this.head = null;
        this.length = 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PurchaseList other = (PurchaseList) obj;
        if (this.length != other.length) {
            return false;
        }
        return Objects.equals(this.head, other.head);
    }

    /**
     * This class is used to create nodes for the linked list.
     */
    class Node {

        Purchase data;
        Node next;
    }
}
