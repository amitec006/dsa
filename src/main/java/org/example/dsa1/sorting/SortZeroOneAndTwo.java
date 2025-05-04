package org.example.dsa1.sorting;

public class SortZeroOneAndTwo {
    /**
     * Given an array with N objects colored red,
     * white, or blue, sort them so that objects of
     * the same color are adjacent, with the colors in the order red, white, and blue.
     *
     * We will represent the colors as,
     *
     * red -> 0
     * white -> 1
     * blue -> 2
     *
     * Note: Using the library sort function is not allowed.
     *
     */

    public static void main(String[] args) {
        int[] A = {0, 1, 2, 0, 1, 2};
        int[] result = new SortZeroOneAndTwo().sortColors(A);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public int[] sortColors(int[] A) {
        int[] count = new int[3];
        for (int i : A) {
            count[i]++;
        }

        int pos = 0;
        for (int i = 0; i < count.length; i++) {
            int k = count[i];
            while (k > 0) {
                A[pos] = i;
                k--;
                pos++;
            }
        }
        return A;
    }

    public int[] sortColors1(int[] A) {
        int n = A.length;
        int low = 0;
        int mid = 0;
        int high = n - 1;
        while (mid <= high) {
            if (A[mid] == 0) {
                swap(A, low, mid);
                low++;
                mid++;
            } else if (A[mid] == 1) {
                mid++;
            } else {
                swap(A, mid, high);
                high--;
            }
        }
        return A;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}

