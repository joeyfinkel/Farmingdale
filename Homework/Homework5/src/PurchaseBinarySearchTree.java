public class PurchaseBinarySearchTree {
  private Node root;

  public PurchaseBinarySearchTree() {
    this.root = null;
  }

  /**
   * Alphabetically compares the item name from the {@code tree} to the
   * {@code item} being added.
   *
   * @param tree The tree to add the {@code item} to.
   * @param item The item to add onto the {@code tree}.
   * @return The tree.
   */
  private Node compareItemNames(Node tree, Purchase item) {
    int compare = item.itemName.compareToIgnoreCase(tree.data.itemName);

    if (compare < 0) {
      // item.itemName comes before tree.data.itemName
      tree.left = add(tree.left, item);
    } else if (compare > 0) {
      // item.itemName comes after tree.data.itemName
      tree.right = add(tree.right, item);
    }

    // item.itemName and tree.data.itemName are equal
    return tree;
  }

  private String compareItemNames(Node tree, String target) {
    int compare = target.compareToIgnoreCase(tree.data.itemName);

    if (compare < 0) {
      // target comes before tree.data.itemName
      return "before";
    } else if (compare > 0) {
      // target comes after tree.data.itemName
      return "after";
    } else {
      // target and tree.data.itemName are equal
      return "equal";
    }
  }

  /**
   * Helper method for adding on the {@code item} to the {@code tree}.
   *
   * @param tree The tree to add the {@code item} to.
   * @param item The item to add onto the {@code tree}.
   * @return The {@code tree} if it's not null, otherwise it'll return a new empty
   *         tree.
   */
  private Node add(Node tree, Purchase item) {
    if (tree == null)
      return new Node(item);

    return compareItemNames(tree, item);
  }

  /**
   * Adds a new {@link Purchase} to the tree.
   *
   * @param item The purchase to add.
   */
  public void add(Purchase item) {
    this.root = add(root, item);
  }

  /**
   * Traverses the tree inorder.
   *
   * @param tree The tree to traverse.
   */
  private void inorder(Node tree) {
    if (tree != null) {
      inorder(tree.left);
      System.out.print(tree.data + ", ");
      inorder(tree.right);
    }
  }

  /**
   * Prints the tree's contents in order.
   */
  public void inorder() {
    if (this.root != null) {
      System.out.println("Inorder traversal:");
      this.inorder(this.root);
    } else {
      System.out.println("The tree is empty");
    }
  }

  /**
   * Traverses the tree postorder.
   *
   * @param tree The tree to traverse.
   */
  private void postorder(Node tree) {
    if (tree != null) {
      postorder(tree.left);
      postorder(tree.right);
      System.out.print(tree.data + ", ");
    }
  }

  /**
   * Prints out the tree in post-order.
   */
  public void postorder() {
    if (this.root != null) {
      System.out.println("\nPostorder traversal:");
      this.postorder(this.root);
    } else {
      System.out.println("The tree is empty");
    }
  }

  /**
   * Traverses the tree pre-order.
   *
   * @param tree The tree to traverse.
   */
  private void preorder(Node tree) {
    if (tree != null) {
      System.out.print(tree.data + ", ");
      preorder(tree.left);
      preorder(tree.right);
    }
  }

  /**
   * Prints out the tree in preorder.
   */
  public void preorder() {
    if (this.root != null) {
      System.out.println("\nPreorder traversal:");
      this.preorder(this.root);
    } else {
      System.out.println("The tree is empty");
    }
  }

  /**
   * Clears the tree's contents.
   */
  public void clear() {
    this.root = null;
  }

  /**
   * Helper method to get the length of the tree recursively.
   *
   * @param tree The tree to get the length of.
   * @return The length of the tree.
   */
  private int getLength(Node tree) {
    if (tree == null)
      return 0;

    return getLength(tree.left) + getLength(tree.right) + 1;
  }

  /**
   * Gets the length of the tree.
   *
   * @return The length of the tree.
   */
  public int getLength() {
    return getLength(this.root);
  }

  private Purchase getPurchase(Node tree, String target) {
    String compared = this.compareItemNames(tree, target);

    if (compared.equals("before"))
      return getPurchase(tree.left, target);
    else if (compared.equals("after"))
      return getPurchase(tree.right, target);
    else
      return tree.data;
  }

  public Purchase getPurchase(String itemName) {

    if (this.root == null)
      return new Purchase();
    else
      return getPurchase(this.root, itemName);
  }

  private double totalCostUsingRecursion(Node tree) {
    if (tree == null) {
      return 0;
    } else {
      double total = 0;

      total += tree.data.cost();
      total += totalCostUsingRecursion(tree.left);
      total += totalCostUsingRecursion(tree.right);

      return total;
    }

  }

  /**
   * Tallies up the cost of each purchase.
   * @return The total cost of all purchases in the tree.
   */
  public double totalCostUsingRecursion() {
    return this.totalCostUsingRecursion(this.root);
  }

  class Node {
    Purchase data;
    Node left;
    Node right;

    /**
     * @param data
     */
    public Node(Purchase data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }
}
