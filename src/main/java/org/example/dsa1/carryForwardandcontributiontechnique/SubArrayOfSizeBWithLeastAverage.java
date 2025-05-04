package org.example.dsa1.carryForwardandcontributiontechnique;

public class SubArrayOfSizeBWithLeastAverage {
    /**
     * Given an array A of size N, find the subarray of size B with the least average.
     *
     * Return the index of the first element of the subarray of size B that has least average.
     * Array indexing starts from 0.
     */

    public static void main(String[] args) {
        int[] A = {3, 7, 90, 20, 10, 50, 40};
        int B = 3;
        System.out.println(new SubArrayOfSizeBWithLeastAverage().solve(A, B));
    }

    public int solve(int[] A, int B) {
        int n = A.length;
        int[] pf = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                pf[i] = A[i];
            } else {
                pf[i] = pf[i-1] + A[i];
            }
        }

        int minSum = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < n-B+1; i++) {
            int sum = pf[i+B-1] - (i == 0 ? 0 : pf[i-1]);
            if (sum < minSum) {
                minSum = sum;
                minIndex = i;
            }
        }
        return minIndex;
    }
}
