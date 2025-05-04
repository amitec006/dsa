package org.example.dsa1.sorting;

public class CountSort {
    /**
     * Given an array A.
     * Sort this array using Count Sort Algorithm and return the sorted array.
     */

    public static void main(String[] args) {
        int[] A = {1, 4, 1, 2, 7, 5, 2};
        int[] result = new CountSort().solve(A);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public int[] solve(int[] A) {
        int min = A[0];
        int max = A[0];
        for (int i : A) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        int[] count = new int[max - min + 1];
        for (int i : A) {
            count[i-min]++;
        }
        int pos = 0;
        for (int i = 0; i < count.length; i++) {
            int k = count[i];
            while (k > 0) {
                A[pos] = i + min;
                k--;
                pos++;
            }
        }
        return A;
    }
}
