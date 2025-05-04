package org.example.sorting.quicksort;


import java.util.Arrays;

public class BClosestPointToOrigin {

    public static void main(String[] args) {
        int[][] A = {{1, 3},{-2, 2}};
        int B = 1;

        int[][] result = new BClosestPointToOrigin().solve(A, B);

        for (int[] i : result) {
            System.out.print(i[0] + " " + i[1] + " ");
        }
    }

    public int[][] solve(int[][] A, int B) {
        int[][] result = new int[B][2];
        Arrays.sort(A, (a, b)->{
            int d1 = a[0] * a[0] + a[1] * a[1];
            int d2 = b[0] * b[0] + b[1] * b[1];
            return d1 - d2;
        });
        for (int i = 0; i < B; i++) {
            result[i][0] = A[i][0];
            result[i][1] = A[i][1];
        }
        return result;
    }
}
