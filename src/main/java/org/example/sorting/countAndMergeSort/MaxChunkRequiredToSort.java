package org.example.sorting.countAndMergeSort;

public class MaxChunkRequiredToSort {
    public static void main(String[] args) {
        int[] A = {2, 0, 1, 3};
        System.out.println(new MaxChunkRequiredToSort().maxChunksToSorted(A));
    }

    public int maxChunksToSorted(int[] A) {
        int maxSoFar = 0, count = 0;
        /**
         * A chunk can be finalized at index i
         * if all values from the start of the chunk up to i are ≤ i
         * — which is guaranteed when the maximum value seen so far is i.
         */
        for (int i = 0; i < A.length; i++) {
            maxSoFar = Math.max(maxSoFar, A[i]);
            if (maxSoFar == i) {
                count++;
            }
        }

        return count;
    }
}
