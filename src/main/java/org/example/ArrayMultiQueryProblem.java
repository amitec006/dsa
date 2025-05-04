package org.example;

public class ArrayMultiQueryProblem {
    public static void main(String[] args) {
        int A = 5;
        int[][] B = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int[] ar = new ArrayMultiQueryProblem().solve(A, B);
        for (int i : ar) {
            System.out.print(i + " ");
        }

    }

    public int[] solve(int A, int[][] B) {
        int[] result = new int[A];
        for (int[] arr : B) {
            int start = arr[0];
            int end = arr[1];
            int amount = arr[2];
            result[start-1] += amount;
            if (end < A) {
                result[end] -= amount;
            }
        }
        for (int i = 1; i < A; i++) {
            result[i] += result[i-1];
        }

        return result;
    }
}
