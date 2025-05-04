package org.example.dsa2;

import java.util.HashMap;
import java.util.Map;

public class AddOrNot {
    /**
     * Given an array of integers A of size N and an integer B.
     *
     * In a single operation, any one element of the array can be increased by 1.
     * You are allowed to do at most B such operations.
     *
     * Find the number with the maximum number of occurrences
     * and return an array C of size 2, where C[0] is the number of
     * occurrences, and C[1] is the number with maximum occurrence.
     * If there are several such numbers, your task is to find the minimum one.
     *
     * Return an array C of size 2, where C[0] is number of occurence and C[1] is the number with maximum occurence.
     * Explanation:
     * Apply operations on A[2] and A[4]
     *  A = [3, 2, 2, 2, 2]
     *  Maximum occurence =  4
     *  Minimum value of element with maximum occurence = 2
     */
    public static void main(String[] args) {
        int[] A = {3, 1, 2, 2, 1};
        int B = 3;

        int[] result = new AddOrNot().solve(A, B);
        System.out.println(result[0] + " " + result[1]);

    }

    public int[] solve(int[] A, int B) {
        Map<Integer,Long> map = new HashMap<>();
        long max = 0;
        for (int j : A) {
            map.put(j, map.getOrDefault( j, 0L) + 1);
            max = Math.max(max, map.get(j));
        }
        int min = Integer.MAX_VALUE;
        for (int j : A) {
            if (map.get(j) == max) {
                min = Math.min(min, j);
            }
        }
        return new int[]{(int)max, min};
    }
}
