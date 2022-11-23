public class App {
    public static void main(String[] args) throws Exception {
        PurchaseBinarySearchTree bst = new PurchaseBinarySearchTree();

        // #region Adding New Purchases
        bst.add(new Purchase("Mouse", 44.9, 34));
        bst.add(new Purchase("Computer", 44.9, 34));
        bst.add(new Purchase("Phone", 44.9, 34));
        // #endregion

        // #region Traversing the tree
        bst.inorder();
        bst.postorder();
        bst.preorder();
        //#endregion

        System.out.printf("\nThe total cost of purchases is: %.2f" , bst.totalCostUsingRecursion());

        System.out.println("\nThe length of the tree is: " + bst.getLength());
        bst.clear();
        bst.inorder();
        System.out.println("\nThe length of the tree is: " + bst.getLength());
    }
}
