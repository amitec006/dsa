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

    /**
     * Given an unsorted array of integers, find the smallest missing positive number using:
     *
     * O(n) time
     *
     * O(1) extra space (modify the array in-place)
     *
     * 🧠 Key Idea
     * We want each positive number x (in range 1 to N, where N is the length of the array) to be at index x - 1.
     *
     * Why?
     * Because:
     *
     * If all positive integers from 1 to N are present, then they will occupy indices 0 to N-1.
     *
     * The first number that doesn't appear at its correct position tells us the smallest missing positive.
     *
     * 🔁 Step-by-Step Algorithm
     * Step 1: Rearrange elements
     * Loop through the array:
     *
     * For each number A[i], while it is in the range 1 to N, and it's not already at its correct position (A[i] != A[A[i] - 1]), swap it with the number at its target position.
     *
     * This moves every valid positive number to its correct place.
     *
     * Step 2: Scan for the missing number
     * After the rearrangement, scan the array:
     *
     * If at index i, A[i] != i + 1, then return i + 1 as the missing number.
     *
     * If all numbers are in correct place (A[i] == i + 1), then the missing number is N + 1.
     */

    public int firstMissingPositive2(int[] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            while (A[i] > 0 && A[i] <= n && A[A[i] - 1] != A[i]) {
                // swap A[i] with A[A[i] - 1]
                int temp = A[i];
                A[i] = A[temp - 1];
                A[temp - 1] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
