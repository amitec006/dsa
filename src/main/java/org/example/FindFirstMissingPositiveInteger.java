package org.example;

public class FindFirstMissingPositiveInteger {
    /**
     * Given an unsorted integer array, A of size N. Find the first missing positive integer.
     *
     * Note: Your algorithm should run in O(n) time and use constant space.
     * @param args
     */
    public static void main(String[] args) {
        int[] A = {3, 4, -1, 1};
        System.out.println(new FindFirstMissingPositiveInteger().firstMissingPositive(A));
    }

    public int firstMissingPositive(int[] A) {
        int n = A.length;
        //Mark all the negative numbers and numbers greater than n as n+1
        for (int i = 0; i < n; i++) {
            if (A[i] <= 0 || A[i] > n) {
                A[i] = n + 2;
            }
        }
        //Mark the numbers present in the array as negative
        for (int i = 0; i < n; i++) {
            int index = Math.abs(A[i])-1;
            if (index < n && A[index] > 0) {
                A[index] = -A[index];
            }
        }
        // Step 2: Find the first missing positive integer
        for (int i = 0; i < n; i++) {
            if (A[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
