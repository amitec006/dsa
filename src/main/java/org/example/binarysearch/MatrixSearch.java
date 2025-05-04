package org.example.binarysearch;

public class MatrixSearch {
    /**
     * Given a matrix of integers A of size N x M and an integer B. Write an efficient algorithm that searches for integer B in matrix A.
     *
     * This matrix A has the following properties:
     *
     * Integers in each row are sorted from left to right.
     * The first integer of each row is greater than or equal to the last integer of the previous row.
     * Return 1 if B is present in A, else return 0.
     *
     * NOTE: Rows are numbered from top to bottom, and columns are from left to right.
     */

    public static void main(String[] args) {
        int[][] A = {
                        {1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 50}
                    };
        int B = 3;
        System.out.println(new MatrixSearch().searchMatrix(A, B));

    }

    public int searchMatrix(int[][] A, int B) {
        int row = A.length;
        int col = A[0].length;
        int low = 0;
        int high = row * col - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midElement = A[mid / col][mid % col];
            if (midElement == B) {
                return 1;
            } else if (midElement < B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }
}
