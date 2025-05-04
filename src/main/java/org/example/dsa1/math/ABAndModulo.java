package org.example.dsa1.math;

public class ABAndModulo {
    /**
     * Given two integers A and B,
     * find the greatest possible positive integer M, such that A % M = B % M.
     *
     */

    public static void main(String[] args) {
        int A = 5;
        int B = 10;
        System.out.println(new ABAndModulo().solve(A, B)); // 2
    }

    public int solve(int A, int B) {
        if (A == B) {
            return A;
        }
        return Math.abs(A - B);
    }
}
