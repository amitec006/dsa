package org.example.tree;

public class CheckIsValidBST {

    /**
     * You are given a binary tree represented by root A. You need to check if it is a Binary Search Tree or not.
     *
     *
     * Assume a BST is defined as follows:
     *
     * 1) The left subtree of a node contains only nodes with keys less than the node's key.
     *
     * 2) The right subtree of a node contains only nodes with keys greater than the node's key.
     *
     * 3) Both the left and right subtrees must also be binary search trees.
     * @param args
     */

    public static void main(String[] args) {
        TreeNode A = new TreeNode(5);
        A.left = new TreeNode(3);
        A.right = new TreeNode(7);

        A.left.left = new TreeNode(2);
        A.left.right = new TreeNode(4);
        A.right.left = new TreeNode(6);
        A.right.right = new TreeNode(8);

        System.out.println(new CheckIsValidBST().isValidBST(A));
    }

    public int isValidBST(TreeNode A) {
        return isValid(A, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public int isValid(TreeNode A, int min, int max) {
        if (A == null) {
            return 1;
        }
        if (A.val <= min || A.val >= max) {
            return 0;
        }
        return isValid(A.left, min, A.val) * isValid(A.right, A.val, max);
    }
}
