package org.example.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeBinaryTree {
/**
 * Given the root node of a Binary Tree denoted by A. You have to Serialize the given Binary Tree in the described format.
 *
 * Serialize means encode it into a integer array denoting the Level Order Traversal of the given Binary Tree.
 *
 * NOTE:
 *
 * In the array, the NULL/None child is denoted by -1.
 * For more clarification check the Example Input.
 */

    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(3);

        A.left.left = new TreeNode(4);
        A.right.left = new TreeNode(5);

        A.left.left.left = new TreeNode(6);

        System.out.println(new SerializeBinaryTree().solve(A));

    }


    public ArrayList<Integer> solve(TreeNode A) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                list.add(-1);
            } else {
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return list;
    }


}
