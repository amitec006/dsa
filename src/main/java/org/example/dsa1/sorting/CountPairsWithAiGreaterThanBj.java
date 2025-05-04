package org.example.dsa1.sorting;

import java.util.Arrays;
import java.util.Collections;

public class CountPairsWithAiGreaterThanBj {
    /**
     * given two array A[m] and B[m] , calculate number of pairs i,j such that A[i] > B[j]
     * A[3] = [3,5,7]
     * B[3] = [0,2,6]
     */
    public static void main(String[] args) {
        int[] A = {3, 5, 7};
        int[] B = {0, 2, 6, 7};
        System.out.println(new CountPairsWithAiGreaterThanBj().solve(A, B));
    }

    private int solve(int[] A, int[] B) {
        Arrays.sort(A);  // Sort A
        Arrays.sort(B);  // Sort B

        int i = 0, j = 0, count = 0;
        int m = A.length;

        while (i < m && j < m) {
            if (A[i] > B[j]) {
                count += (m - i); // All elements from A[i] to A[m-1] are greater than B[j]
                j++; // Move to next element in B
            } else {
                i++; // Move to next element in A
            }
        }
        return count;
    }
}
