package org.example;

public class MaximumContiguousSubArray {
    /**
     * Find the maximum sum of contiguous non-empty subarray within an array A of length N.
     * @param args
     */
    public static void main(String[] args) {
        int[] A = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaximumContiguousSubArray().maxSubArray(A));
    }

    // Kadane's Algorithm
    public int maxSubArray(int[] A) {
        int max_so_far = A[0];
        int current_max = A[0];

        for (int i = 1; i < A.length; i++) {
            current_max = Math.max(A[i], current_max + A[i]);
            max_so_far = Math.max(max_so_far, current_max);
        }
        return max_so_far;
    }
}
