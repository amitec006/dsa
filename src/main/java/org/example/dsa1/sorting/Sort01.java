package org.example.dsa1.sorting;

public class Sort01 {
    /**
     * Given an array A of 0s and 1s of length N. Sort this array.
     *
     * Note - Do not use any sorting algorithm or library's sort method.
     */

    public static void main(String[] args) {
        int[] A = {0, 1, 0, 1, 0, 1};
        int[] result = new Sort01().sort01(A);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public int[] sort01(int[] A) {
        int n = A.length;
        int low = 0;
        int high = n - 1;
        while (low < high) {
            if (A[low] == 0) {
                low++;
            } else if (A[high] == 1) {
                high--;
            } else {
                int temp = A[low];
                A[low] = A[high];
                A[high] = temp;
                low++;
                high--;
            }
        }
        return A;
    }
}
