package org.example.dsa1.sorting;

public class MergeTwoSortedArray {
    /**
     * Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.
     *
     * Note: A linear time complexity is expected and you should avoid use of any library function.
     */

    public static void main(String[] args) {
        int[] A = {4, 7, 9};
        int[] B = {2, 11, 19, 21, 24};

        int[] result = new MergeTwoSortedArray().solve(A, B);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public int[] solve(final int[] A, final int[] B) {
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
