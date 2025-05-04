package org.example.dsa1.sorting;

public class InversionCountInAnArray {
    /**
     * Given an array of integers A. If i < j and A[i] > A[j],
     * then the pair (i, j) is called an inversion of A.
     * Find the total number of inversions of A modulo (109 + 7).
     *
     * A = [3, 4, 1, 2]
     * The pair (0, 2) is an inversion as 0 < 2 and A[0] > A[2]
     * The pair (0, 3) is an inversion as 0 < 3 and A[0] > A[3]
     * The pair (1, 2) is an inversion as 1 < 2 and A[1] > A[2]
     * The pair (1, 3) is an inversion as 1 < 3 and A[1] > A[3]
     *
     * Inversion Count for an array indicates that how far (or close)
     * the array is from being sorted. If the array is already sorted,
     * then the inversion count is 0, but if the array is sorted in reverse order,
     * the inversion count is the maximum.
     */

    public static void main(String[] args) {
        int[] A = {3, 4, 1, 2};
        System.out.println(new InversionCountInAnArray().solve(A));
    }

    public int solve(int[] A) {
        return countInv(A, 0, A.length - 1);
    }

    // This function merges two sorted subarrays
    // arr[l...m] and arr[m+1 .. r] and also counts
    // inversions in the whole subarray arr[l..r]
    private long countAndMerge(int[] arr, int l, int m, int r) {
        // Counts in two subarrays
        int n1 = m - l + 1, n2 = r - m;

        // Set up two arrays for left and right halves
        int[] left = new int[n1];
        int[] right = new int[n2];
        for (int i = 0; i < n1; i++)
            left[i] = arr[i + l];
        for (int j = 0; j < n2; j++)
            right[j] = arr[m + 1 + j];

        // Initialize inversion count (or result)
        // and merge two halves
        long res = 0;
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {

            // No increment in inversion count
            // if left[] has a smaller or equal element
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                res += (n1 - i);
            }
        }

        // Merge remaining elements
        while (i < n1)
            arr[k++] = left[i++];
        while (j < n2)
            arr[k++] = right[j++];

        return res;
    }

    // Function to count inversions in the array
    private int countInv(int[] arr, int l, int r) {
        long res = 0;
        if (l < r) {
            int m = (r + l) / 2;

            // Recursively count inversions
            // in the left and right halves
            res += countInv(arr, l, m);
            res += countInv(arr, m + 1, r);

            // Count inversions such that greater
            // element is in the left half and
            // smaller in the right half
            res += countAndMerge(arr, l, m, r);
            res = res % 1000000007;
        }
        return (int)res%1000000007;
    }
}
