package org.example.tree;

public class BalanceHeightBinaryTree {

    /**
     * Given a root of binary tree A, determine if it is height-balanced.
     *
     * A height-balanced binary tree is defined as a
     * binary tree in which the depth of the two subtrees
     * of every node never differ by more than 1.
     * @param args
     */
    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(3);

        A.left.left = new TreeNode(4);
        A.right.left = new TreeNode(5);

        A.left.left.left = new TreeNode(6);

    }

    public int isBalanced(TreeNode A) {
        return checkHeight(A) != -1 ? 1 : 0;
    }

    private int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1;  // Left subtree is not balanced

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1; // Right subtree is not balanced

        if (Math.abs(leftHeight - rightHeight) > 1) return -1; // Current node is not balanced

        return Math.max(leftHeight, rightHeight) + 1; // Return the height of the current node
    }
}
