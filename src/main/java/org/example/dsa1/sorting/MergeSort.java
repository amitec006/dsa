package org.example.dsa1.sorting;

public class MergeSort {
    /**
     * Given an integer array A, sort the array using Merge Sort.
     */

    public static void main(String[] args) {
        int[] A = {1, 4, 10, 2, 1, 5};
        int[] result = new MergeSort().solve(A);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public int[] solve(int[] A) {
        return mergeSort(A, 0, A.length - 1);
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
