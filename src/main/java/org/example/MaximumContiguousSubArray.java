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

    public int maxSubArray(final int[] A) {
        int n = A.length;
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int i = 0; i <= n - 1; i++) {
            currSum += A[i];

            if (currSum > maxSum) {
                maxSum = currSum;
            }

            if (currSum < 0) {
                currSum = 0;
            }
        }

        return maxSum;
    }
}
