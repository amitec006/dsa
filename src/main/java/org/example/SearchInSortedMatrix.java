package org.example;

public class SearchInSortedMatrix {
    /**
     * Given a matrix of integers A of size N x M and an integer B.
     *
     * In the given matrix every row and column is sorted in non-decreasing order.
     * Find and return the position of B in the matrix in the given form:
     * If A[i][j] = B then return (i * 1009 + j)
     * If B is not present return -1.
     *
     * Note 1: Rows are numbered from top to bottom and columns are numbered from left to right.
     * Note 2: If there are multiple B in A then return the smallest value of i*1009 +j such that A[i][j]=B.
     * Note 3: Expected time complexity is linear
     * Note 4: Use 1-based indexing
     * @param args
     */
    public static void main(String[] args) {
        int[][] A = {{3,3,3},{3,3,3},{3,3,3}};
        int B = 3;
        System.out.println(searchMatrix(A, B));
    }

    private static int searchMatrix(int[][] a, int b) {
        int i = 0;
        int j = a[0].length - 1;
        while (i < a.length && j >= 0) {
            if (a[i][j] == b) {
                int k = j;
                while (k >=0 && a[i][k] == b) {
                    k--;
                }
                return ((i+1) * 1009 + (k+2));
            } else if (a[i][j] > b) {
                j--;
            } else {
                i++;
            }
        }
        return -1;
    }
}
