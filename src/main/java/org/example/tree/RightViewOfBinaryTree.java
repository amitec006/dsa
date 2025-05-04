package org.example.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewOfBinaryTree {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(3);

        A.left.left = new TreeNode(4);
        A.right.left = new TreeNode(5);

        A.left.left.left = new TreeNode(6);


    }

    public ArrayList<Integer> rightView(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        if (A == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int lastVal = 0; // To store the rightmost value

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                lastVal = node.val; // Keep updating to get the last node in this level

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(lastVal);
        }

        return result;
    }
}
