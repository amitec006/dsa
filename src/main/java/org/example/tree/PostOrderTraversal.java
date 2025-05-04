package org.example.tree;

import java.util.ArrayList;

public class PostOrderTraversal {
    public static void main(String[] args) {

    }
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        if (A == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();

        list.addAll(postorderTraversal(A.left));  // Recursive call for left subtree
        list.addAll(postorderTraversal(A.right)); // Recursive call for right subtree
        list.add(A.val);                        // Add current node value

        return list;
    }
}
