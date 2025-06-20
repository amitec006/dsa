package org.example.dsa1.sorting;

public class BthSmallestElement {

    /**
     * Find the Bth smallest element in given array A .
     *
     * NOTE: Users should try to solve it in less than equal to B swaps.
     */

    public static void main(String[] args) {
        int[] A = {4, 7, 9, 2, 11, 19, 21, 24}; //

        System.out.println(findBthSmallest(A, 3));
    }

    public static int findBthSmallest(int[] A, int B) {
        int n = A.length;

        for (int i = 0; i < B; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (A[j] < A[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = A[i];
                A[i] = A[minIndex];
                A[minIndex] = temp;
            }
        }
        return A[B - 1];
    }
}

