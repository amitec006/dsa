package org.example.dsa1.basicarray;

public class MaxAndMinOfArray {
    /**
     * Given an array A of size N.
     * You need to find the sum of Maximum
     * and Minimum element in the given array.
     */
    public static void main(String[] args) {
        int[] A = {-2, 1, -4, 5, 3};
        int result = new MaxAndMinOfArray().solve(A);
        System.out.println(result);
    }

    public int solve(int[] a) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int el : a) {
            max = Math.max(max, el);
            min = Math.min(min, el);
        }
        return max + min;
    }
}
