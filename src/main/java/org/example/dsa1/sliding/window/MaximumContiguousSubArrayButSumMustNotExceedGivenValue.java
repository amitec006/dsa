package org.example.dsa1.sliding.window;

public class MaximumContiguousSubArrayButSumMustNotExceedGivenValue {
    /**
     * You are given an integer array C of size A.
     * Now you need to find a subarray (contiguous elements) so that the sum of contiguous elements is maximum.
     * But the sum must not exceed B.
     */

    public static void main(String[] args) {
        int A = 5;
        int B = 12;
        int[] C = new int[]{2, 1, 3, 4, 5};

        System.out.println(new MaximumContiguousSubArrayButSumMustNotExceedGivenValue().maxSubarray(B, C));
    }

    public int maxSubarray(int B, int[] C) {
        int maxSum = 0;
        int sum = 0;
        int start = 0;

        for (int end = 0; end < C.length; end++) {
            sum += C[end];

            while (sum > B && start <= end) {
                sum -= C[start];
                start++;
            }

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }


}
