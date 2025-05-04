package org.example.tree;

import java.util.ArrayList;

public class InorderTraversal {
    //LNR

    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(3);

        A.left.left = new TreeNode(4);
        A.right.left = new TreeNode(5);

        A.left.left.left = new TreeNode(6);

        System.out.println(new InorderTraversal().inorderTraversal(A));
    }

    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        if (A == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();

        list.addAll(inorderTraversal(A.left));  // Recursive call for left subtree
        list.add(A.val);                        // Add current node value
        list.addAll(inorderTraversal(A.right)); // Recursive call for right subtree

        return list;
    }
}
