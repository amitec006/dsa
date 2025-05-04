package org.example.binarysearch;

public class MximumHeightOfStaircase {
    /**
     * Given an integer A representing the number of square blocks. The height of each square block is 1. The task is to create a staircase of max-height using these blocks.
     *
     * The first stair would require only one block, and the second stair would require two blocks, and so on.
     *
     * Find and return the maximum height of the staircase.
     *
     *
     *
     */

    public static void main(String[] args) {
        int A = 20;
        System.out.println(new MximumHeightOfStaircase().solve(A));
    }

    public int solve(int A) {
        int low = 0, high = A, ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long sum = (long) mid * (mid + 1) / 2; // Sum of first 'mid' natural numbers

            if (sum <= A) {
                ans = mid; // Valid height
                low = mid + 1; // Try for a larger height
            } else {
                high = mid - 1; // Reduce height
            }
        }
        return ans;
    }
}
