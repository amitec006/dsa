package org.example.dsa1.recursion;

public class FirstIndexUsingRecursion {
    /**
     * You are given an array A of size N. Write a recursive
     * function that returns the first index at which an integer B is found in the array.
     *
     * NOTE: If B is not found anywhere in the array then return -1.
     */

    public static void main(String[] args) {
        int[] A = {-3, 5, 6, 2};
        int B = 4;
        System.out.println(new FirstIndexUsingRecursion().FirstIndex(A, B));
    }
    public int FirstIndex(int[] A, int B) {
        return solve(A, B, 0);
    }

    private int solve(int[] A, int B, int i) {
        if (i >= A.length) {
            return -1;
        }
        if (A[i] == B) {
            return i;
        }
        return solve(A, B, i+1);
    }
}
