package org.example.dsa1.sorting;

public class MaxChunksToMakeSorted {
    /**
     * Given an array of integers A of size N
     * that is a permutation of [0, 1, 2, ..., (N-1)],
     * if we split the array into some number of "chunks" (partitions),
     * and individually sort each chunk.
     * After concatenating them in order of splitting, the result equals the sorted array.
     *
     * What is the most number of chunks we could have made?
     */

    public static void main(String[] args) {
        int[] A = {1, 0, 2, 3, 4};
        System.out.println(new MaxChunksToMakeSorted().solve(A));
    }

    public int solve(int[] A) {
        int n = A.length;
        int max = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, A[i]);
            if (max == i) {
                count++;
            }
        }
        return count;
    }
}

