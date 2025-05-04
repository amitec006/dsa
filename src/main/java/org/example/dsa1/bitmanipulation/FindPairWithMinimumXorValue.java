package org.example.dsa1.bitmanipulation;

import java.util.Arrays;

public class FindPairWithMinimumXorValue {
    /**
     * Given an integer array A of N integers,
     * find the pair of integers in the array which have minimum XOR value.
     * Report the minimum XOR value.
     */

    public static void main(String[] args) {
        int[] A = {0, 2, 5, 7};
        System.out.println(new FindPairWithMinimumXorValue().findMinXor(A));

    }

    public int findMinXor(int[] A) {
        Arrays.parallelSort(A);
        int minXor = Integer.MAX_VALUE;
        int val = 0;
        for (int i = 0; i < A.length - 1; i++) {
            val = A[i] ^ A[i + 1];
            minXor = Math.min(minXor, val);
        }
        return minXor;
    }
}
