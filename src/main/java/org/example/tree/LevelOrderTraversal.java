package org.example.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(3);

        A.left.left = new TreeNode(4);
        A.right.left = new TreeNode(5);

        A.left.left.left = new TreeNode(6);

        System.out.println(new LevelOrderTraversal().solve(A));
    }

    public ArrayList<ArrayList<Integer>> solve(TreeNode A) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int n = queue.size();
            ArrayList<Integer> l = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                System.out.println(node.val);
                l.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(l);
        }
        return list;
    }
}
