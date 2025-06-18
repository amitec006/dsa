package org.example.dsa1.sliding.window;

public class SumOfAllSubArray {

    /**
     * You are given an integer array A of length N.
     * You have to find the sum of all subarray sums of A.
     */

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        System.out.println(new SumOfAllSubArray().subarraySum(A));
    }

    /**
     * For each element A[i], the number of subarrays that include it is:
     *
     * (i + 1) * (N - i)
     * (i + 1) → number of choices for the start of the subarray (can start anywhere from index 0 to i).
     *
     * (N - i) → number of choices for the end of the subarray (can end anywhere from i to N - 1).
     *
     * Hence, the total contribution of A[i] to all subarray sums is:
     *
     * A[i] * (i + 1) * (N - i)
     * This is summed over all i from 0 to N - 1.
     *
     *
     * For any index i:
     *
     * You can choose a starting index from 0 to i (inclusive), giving you (i + 1) options.
     *
     * You can choose an ending index from i to N - 1 (inclusive), giving (N - i) options.
     *
     * Total subarrays that include A[i] =
     * ➡️ (i + 1) * (N - i)
     */
    public long subarraySum(int[] A) {
        int N = A.length;
        long totalSum = 0;

        for (int i = 0; i < N; i++) {
            long contribution = (long) A[i] * (i + 1) * (N - i);
            totalSum += contribution;
        }

        return totalSum;
    }
}
