package org.example.dsa1.matrix;

public class PrintAntiDiagonal {
    public static void main(String[] args) {
        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result = new PrintAntiDiagonal().diagonal(A);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] diagonal(int[][] A) {
        int n = A.length;
        int[][] result = new int[2 * n - 1][n];

        // Traverse starting from the top row
        for (int col = 0; col < n; col++) {
            int i = 0, j = col, index = 0;
            while (i < n && j >= 0) {
                result[col][index++] = A[i][j];
                i++;
                j--;
            }
        }

        // Traverse starting from the last column (excluding first row)
        for (int row = 1; row < n; row++) {
            int i = row, j = n - 1, index = 0;
            while (i < n && j >= 0) {
                result[n - 1 + row][index++] = A[i][j];
                i++;
                j--;
            }
        }

        return result;
    }
}
