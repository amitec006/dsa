package org.example.dsa1.sliding.window;

public class MaximumSubArraySumOfLengthK {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;
        System.out.println(maxSubarraySum(arr, k));
    }
    public static int maxSubarraySum(int[] arr, int k) {
        if (arr.length < k) {
            throw new IllegalArgumentException("Array length must be at least k");
        }

        int maxSum = 0, windowSum = 0;

        // Compute the sum of the first k elements
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;

        // Slide the window
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];  // Add next element, remove first element of previous window
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

}
