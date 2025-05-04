package org.example.dsa1.math;

public class DivisorGame {
    /**
     * Scooby has 3 three integers A, B, and C.
     *
     * Scooby calls a positive integer special
     * if it is divisible by B and it is divisible by C.
     * You need to tell the number of special integers less than or equal to A.
     */
    public static void main(String[] args) {
        int A = 6;
        int B = 1;
        int C = 4;

        System.out.println(new DivisorGame().solve(A, B, C)); // 2

    }

    public int solve(int A, int B, int C) {
        return (A/ lcm(B,C));
    }

    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
