package org.example;

public class MaximumSumOfKCornnerElementsInAnArray {
    public static void main(String[] args) {
        int currentSum = 0;
        int maxSum = 0;
        int k = 3;
        int []arr = {8, 4, 4, 8, 12, 3, 2, 9};
        for (int i = 0; i < k; i++) {
            currentSum += arr[i];
        }
        maxSum = currentSum;
        int j = arr.length - 1;
        for (int l = k-1; l > 0; l--) {
            currentSum = currentSum + arr[j] - arr[l];
            maxSum = Math.max(maxSum, currentSum);
            j--;
        }
        System.out.println(maxSum);
    }
}
