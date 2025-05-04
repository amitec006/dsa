package org.example.dsa1.carryForwardandcontributiontechnique;

public class GoodSubArrayExist {
    /**
     * Given an array of integers A, a subarray of an array is said to be good if it fulfills any one of the criteria:
     * 1. Length of the subarray is be even, and the sum of all the elements of the subarray must be less than B.
     * 2. Length of the subarray is be odd, and the sum of all the elements of the subarray must be greater than B.
     * Your task is to find the count of good subarrays in A.
     */

    public static void main(String[] args) {
        int[] A = {13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9};
        int B = 65;

        int ans = new GoodSubArrayExist().solve(A,B);
        System.out.println(ans);
    }

    public int solve2(int[] A, int B) {
        int n = A.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += A[j];
                if ((j - i + 1) % 2 == 0 && sum < B) {
                    count++;
                } else if ((j - i + 1) % 2 != 0 && sum > B) {
                    count++;
                }
            }
        }
        return count;
    }

    public int solve(int[] A, int B) {
        int n = A.length;
        int count = 0;

        // Iterate over all possible starting points
        for (int i = 0; i < n; i++) {
            int sum = 0;

            // Extend the subarray from i to j
            for (int j = i; j < n; j++) {
                sum += A[j]; // Add current element to sum
                int length = j - i + 1; // Current subarray length

                // Check conditions
                if ((length % 2 == 0 && sum < B) || (length % 2 == 1 && sum > B)) {
                    count++;
                }
            }
        }
        return count;
    }
}
