package org.example.dsa2;

public class MatrixMedian {
    /**
     * Given a matrix of integers A of size N x M in which each row is sorted.
     *
     *
     * Find and return the overall median of matrix A.
     *
     * NOTE: No extra memory is allowed.
     *
     * NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.
     */

    public static void main(String[] args) {
        int[][] A = {{1, 3, 5},{2, 6, 9},{3, 6, 9}};
        System.out.println(new MatrixMedian().findMedian(A));
    }

    public int findMedian(int[][] A) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        int n = A.length;
        int m = A[0].length;
        for (int i = 0; i < n; i++) {
            low = Math.min(low, A[i][0]);
            high = Math.max(high, A[i][m - 1]);
        }
        int desired = (n * m + 1) / 2;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            for (int i = 0; i < n; i++) {
                count += countSmaller(A[i], mid);
            }
            if (count < desired) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int countSmaller(int[] ints, int mid) {
        int low = 0;
        int high = ints.length - 1;
        while (low <= high) {
            int m = low + (high - low) / 2;
            if (ints[m] <= mid) {
                low = m + 1;
            } else {
                high = m - 1;
            }
        }
        return low;
    }
}
