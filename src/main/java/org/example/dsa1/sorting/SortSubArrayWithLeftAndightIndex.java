package org.example.dsa1.sorting;

public class SortSubArrayWithLeftAndightIndex {
    /**
     * You are given an array A of integers of length N and two indices, B and C.
     *
     * Your task is to sort the subarray [B, C] within the given array. The rest of the array should remain unchanged.
     */

    public static void main(String[] args) {
        int[] A = {59, 11, 8, 91, 49, 44, 8};
        int B = 4;
        int C = 6;

        int[] result = new SortSubArrayWithLeftAndightIndex().sortSubarray(A, B, C);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public int[] sortSubarray(int[] A, int B, int C) {
        int[] subArray = new int[C - B + 1];
        int k = 0;
        for (int i = B; i <= C; i++) {
            subArray[k++] = A[i];
        }
        subArray = mergeSort(subArray, 0, subArray.length - 1);
        k = 0;
        for (int i = B; i <= C; i++) {
            A[i] = subArray[k++];
        }
        return A;
    }

    private int[] mergeSort(int[] A, int l, int r) {
        if (l == r) {
            return new int[]{A[l]};
        }
        int m = (l + r) / 2;
        int[] la = mergeSort(A, l, m);
        int[] ra = mergeSort(A, m + 1, r);
        return merge(la, ra);
    }

    public int[] merge(final int[] A, final int[] B) {
        int n = A.length;
        int m = B.length;
        int[] result = new int[n + m];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n && j < m) {
            if (A[i] < B[j]) {
                result[k++] = A[i++];
            } else {
                result[k++] = B[j++];
            }
        }
        while (i < n) {
            result[k++] = A[i++];
        }
        while (j < m) {
            result[k++] = B[j++];
        }
        return result;
    }
}
