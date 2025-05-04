package org.example.tree;

public class SumBinaryTreeOrNot {

    /**
     * Given a binary tree. Check whether the given tree is a Sum-binary Tree or not.
     *
     * Sum-binary Tree is a Binary Tree where the value of a every node is equal to sum of the nodes present in its left subtree and right subtree.
     *
     * An empty tree is Sum-binary Tree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.
     *
     * Return 1 if it sum-binary tree else return 0.
     *
     *
     * All leaf nodes are considered as SumTree.
     *  Value of Node 10 = 4 + 6.
     *  Value of Node 3 = 0 + 3
     *  Value of Node 26 = (10 + 4 + 6) + 6
     * @param args
     */
    public static void main(String[] args) {
        TreeNode A = new TreeNode(26);
        A.left = new TreeNode(10);
        A.right = new TreeNode(3);

        A.left.left = new TreeNode(4);
        A.left.right = new TreeNode(6);

        A.right.right = new TreeNode(4);

        System.out.println(new SumBinaryTreeOrNot().solve(A));
    }

    public int solve(TreeNode A) {
        return isSumBinaryTree(A) ? 1 : 0;
    }

    private boolean isSumBinaryTree(TreeNode A) {
        if (A == null) return true;  // Empty tree is a Sum-binary Tree
        if (A.left == null && A.right == null) return true; // Leaf node is also a SumTree

        int leftSum = getSum(A.left);
        int rightSum = getSum(A.right);

        // Check if the current node satisfies the sum property and both subtrees are Sum-binary Trees
        if (A.val == leftSum + rightSum && isSumBinaryTree(A.left) && isSumBinaryTree(A.right)) {
            return true;
        }
        return false;
    }

    private int getSum(TreeNode A) {
        if (A == null) return 0;
        return A.val + getSum(A.left) + getSum(A.right);
    }
}
