package org.example.tree;

public class EqualTreePartition {
    /**
     * Given a binary tree A. Check whether it is possible to partition the tree
     * to two trees which have equal sum of values after
     * removing exactly one edge on the original tree.
     * @param args
     */
    public static void main(String[] args) {
        TreeNode A = new TreeNode(6);
        A.left = new TreeNode(9);
        A.right = new TreeNode(4);

        A.right.left = new TreeNode(8);
        A.right.left.right = new TreeNode(3);

        System.out.println(new EqualTreePartition().solve(A));
    }

    public int solve(TreeNode A) {
        if (A == null) return 0;

        int totalSum = computeTotalSum(A);
        if (totalSum % 2 != 0) return 0; // Partition is impossible

        return (checkPartition(A, totalSum / 2, new int[]{0}) == (totalSum/2))?1:0;
    }

    private int computeTotalSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + computeTotalSum(node.left) + computeTotalSum(node.right);
    }

    private int checkPartition(TreeNode node, int target, int[] found) {
        if (node == null) return 0;

        int leftSum = checkPartition(node.left, target, found);
        int rightSum = checkPartition(node.right, target, found);
        int subtreeSum = node.val + leftSum + rightSum;

        // If we find a valid partition, mark found[0] to prevent multiple checks
        if (subtreeSum == target) {
            found[0] = 1;
        }

        return found[0] == 1 ? target : subtreeSum; // Stop further recursion if partition found
    }
}
