package org.example.twopointer;

import java.util.ArrayList;
import java.util.HashSet;

public class PairsCountWithDiffOfB {
    /**
     * Given an one-dimensional integer array A of size N and an integer B.
     *
     * Count all distinct pairs with difference equal to B.
     *
     * Here a pair is defined as an integer pair (x, y),
     * where x and y are both numbers in the array and their absolute difference is B.
     */

    public static void main(String[] args) {
        int[] A = {8, 12, 16, 4, 0, 20};
        int B = 4;
    }

    public int solve(ArrayList<Integer> A, int B) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<String> uniquePairs = new HashSet<>();

        for (int num : A) {
            if (set.contains(num + B)) {
                uniquePairs.add(Math.min(num, num + B) + "," + Math.max(num, num + B));
            }
            if (set.contains(num - B)) {
                uniquePairs.add(Math.min(num, num - B) + "," + Math.max(num, num - B));
            }
            set.add(num);
        }

        return uniquePairs.size();
    }

    public static int countPairsWithDifference(int[] A, int B) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<String> uniquePairs = new HashSet<>();

        for (int num : A) {
            if (set.contains(num + B)) {
                uniquePairs.add(Math.min(num, num + B) + "," + Math.max(num, num + B));
            }
            if (set.contains(num - B)) {
                uniquePairs.add(Math.min(num, num - B) + "," + Math.max(num, num - B));
            }
            set.add(num);
        }

        return uniquePairs.size();
    }
}
