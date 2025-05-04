package org.example.dsa1.math;

public class DeleteOneToGetMaxGCD {
    /**
     * Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.
     *
     * Find the maximum value of GCD.
     */

    public static void main(String[] args) {
        int[] A = {12, 15, 18};
        System.out.println(new DeleteOneToGetMaxGCD().solve(A)); // 6
    }

    public int solve(int[] A) {
        int n = A.length;
        int[] prefixGCD = new int[n];
        int[] suffixGCD = new int[n];

        prefixGCD[0] = A[0];
        for (int i = 1; i < n; i++) {
            prefixGCD[i] = gcd(prefixGCD[i - 1], A[i]);
        }

        suffixGCD[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixGCD[i] = gcd(suffixGCD[i + 1], A[i]);
        }

        int maxGCD = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                maxGCD = Math.max(maxGCD, suffixGCD[i + 1]);
            } else if (i == n - 1) {
                maxGCD = Math.max(maxGCD, prefixGCD[i - 1]);
            } else {
                maxGCD = Math.max(maxGCD, gcd(prefixGCD[i - 1], suffixGCD[i + 1]));
            }
        }

        return maxGCD;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
