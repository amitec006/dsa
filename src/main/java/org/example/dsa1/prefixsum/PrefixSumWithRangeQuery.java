package org.example.dsa1.prefixsum;

public class PrefixSumWithRangeQuery {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[][] B = {{0, 3}, {1, 2}};

        int[] prefixSum = new int[A.length];
        prefixSum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
        }

        for (int[] ints : B) {
            int l = ints[0];
            int r = ints[1];
            int sum = prefixSum[r] - (l > 0 ? prefixSum[l - 1] : 0);
            System.out.println(sum);
        }
    }
}
