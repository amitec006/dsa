package org.example.dsa1.recursion;

public class MaxOfAnArray {
    /**
     * Given an array A of size N, write a recursive
     * function that returns the maximum element of the array.
     */
    public static void main(String[] args) {
        int[] A = {12, 10, 3, 4, 5};
        System.out.println(new MaxOfAnArray().getMax(A));
    }

    public int getMax(int[] A) {
        return solve(A, A[0], 0);
    }

    private int solve(int[] A, int max, int i) {
        if (i == A.length) {
            return max;
        }
        if (A[i] > max) {
            max = A[i];
        }
        return solve(A, max, i+1);
    }
}
