package org.example.dsa2;

public class PainterPartitionProblem {
    /**
     * Given 2 integers A and B and an array of integers C of size N. Element C[i] represents the length of ith board.
     * You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of the board.
     *
     * Calculate and return the minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of the board.
     * NOTE:
     * 1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
     * 2. A painter will only paint contiguous boards. This means a configuration where painter 1 paints boards 1 and 3 but not 2 is invalid.
     *
     * Return the ans % 10000003.
     *
     * Input Format
     *
     * The first argument given is the integer A.
     * The second argument given is the integer B.
     * The third argument given is the integer array C.
     *
     *
     *
     * Output Format
     *
     * Return minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of board % 10000003.
     */

    public static void main(String[] args) {
        int A = 10;
        int B = 1;
        int[] C = {1, 8, 11, 3};

        System.out.println(new PainterPartitionProblem().paint(A, B, C));
    }

    public int paint(int A, int B, int[] C) {
        int len = C.length;
        int low = C[0];
        int high = C[0];
        for (int i = 1; i < len; i++) {
            low = Math.max(low, C[i]);
            high += C[i];
        }
        if (A >= len) {
            return (int) ((long) low * B % 10000003);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            int painters = 1;
            int sum = 0;
            for (int j : C) {
                sum += j;
                if (sum > mid) {
                    painters++;
                    sum = j;
                }
            }
            if (painters <= A) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return (int) ((long) low * B % 10000003);
    }
}
