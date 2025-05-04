package org.example.tree;

public class HasPathSumEqualToGivenSum {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(5);
        A.left = new TreeNode(4);
        A.right = new TreeNode(8);

        A.left.left = new TreeNode(11);

        A.left.left.left = new TreeNode(7);
        A.left.left.right = new TreeNode(2);

        A.right.left = new TreeNode(13);
        A.right.right = new TreeNode(4);

        A.right.right.right = new TreeNode(1);
        System.out.println(new HasPathSumEqualToGivenSum().hasPathSum(A, 22));
    }

    public int hasPathSum(TreeNode A, int B) {
        if (A == null) {
            return 0;
        }

        // If it's a leaf node, check if the remaining sum equals the node value
        if (A.left == null && A.right == null && B == A.val) {
            return 1;
        }

        // Recursively check left and right subtrees with reduced sum
        int left = hasPathSum(A.left, B - A.val);
        int right = hasPathSum(A.right, B - A.val);

        return (left == 1 || right == 1) ? 1 : 0;
    }
}
