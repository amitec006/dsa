package org.example;

public class MinimumNubOfSwapReqToBringAllElementLessThanOrEqualToKTogether {
    /**
     * Given an array of integers A and an integer B, find and return the minimum number of swaps required to bring all the numbers less than or equal to B together.
     *
     * Note: It is possible to swap any two elements, not necessarily consecutive.
     * @param args
     */

    public static void main(String[] args) {
        int[] arr1 = { 100, 17, 5, 11 };
        int k = 20;
        System.out.println(new MinimumNubOfSwapReqToBringAllElementLessThanOrEqualToKTogether().solve(arr1, k));
    }

    public int solve(int[] A, int B) {
        int n = A.length;
        int count = 0;

        // Step 1: Count how many numbers are <= B
        for (int j : A) {
            if (j <= B) {
                count++;
            }
        }

        // If no elements are ≤ B, no swaps needed
        if (count == 0) return 0;

        // Step 2: Find initial "bad" count in the first window
        int bad = 0;
        for (int i = 0; i < count; i++) {
            if (A[i] > B) {
                bad++;
            }
        }

        // Step 3: Sliding Window to minimize bad count
        int ans = bad;
        for (int i = 0; i < n - count; i++) {
            // Remove leftmost element from the window
            if (A[i] > B) {
                bad--;
            }
            // Add the next element into the window
            if (A[i + count] > B) {
                bad++;
            }
            ans = Math.min(ans, bad);
        }

        return ans;
    }

}
