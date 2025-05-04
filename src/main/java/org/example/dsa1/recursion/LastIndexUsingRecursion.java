package org.example.dsa1.recursion;

public class LastIndexUsingRecursion {
    /**
     * You are given an array A of size N.
     * Write a recursive function that returns the last index at which an integer B is found in the array.
     *
     * NOTE: If B is not found anywhere in the array then return -1.
     */
    public static void main(String[] args) {
        int[] A = {6, 5, 6, 2};
        int B = 6;
        System.out.println(new LastIndexUsingRecursion().LastIndex(A,B));
    }

    public int LastIndex(int[] A, int B) {
        return solve(A, B, A.length-1);
    }

    private int solve(int[] A, int B, int i) {
        if (i <= -1) {
            return -1;
        }
        if (A[i] == B) {
            return i;
        }
        return solve(A, B, i-1);
    }
}
