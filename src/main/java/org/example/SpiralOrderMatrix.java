package org.example;

public class SpiralOrderMatrix {
    /**
     * Given an integer A, generate a square matrix
     * filled with elements from 1 to A2 in spiral order
     * and return the generated square matrix.
     * @param args
     */
    public static void main(String[] args) {
        int[][] res = new SpiralOrderMatrix().generateMatrix(6);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] generateMatrix(int A) {
        int[][] result = new int[A][A];
        int i = 0;
        int j = 0;
        int element = 1;
        while (A > 1) {
            for (int k = 1; k < A; k++) {
                result[i][j] = element;
                element++;
                j++;
            }

            for (int k = 1; k < A; k++) {
                result[i][j] = element;
                element++;
                i++;
            }

            for (int k = 1; k < A; k++) {
                result[i][j] = element;
                element++;
                j--;
            }

            for (int k = 1; k < A; k++) {
                result[i][j] = element;
                element++;
                i--;
            }
            i++;
            j++;
            A -= 2;
        }
        if (A == 1) {
            result[i][j] = element;
        }
        return result;
    }
}
