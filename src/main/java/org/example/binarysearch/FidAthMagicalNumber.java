package org.example.binarysearch;

public class FidAthMagicalNumber {
    /**
     * You are given three positive integers, A, B, and C.
     *
     * Any positive integer is magical if divisible by either B or C.
     *
     * Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
     */

    public static void main(String[] args) {
        /**
         * int A = 807414236;
         *        int B = 3788;
         *        int C = 38141;
         */
       int A = 807414236;
       int B = 3788;
       int C = 38141;

        System.out.println(new FidAthMagicalNumber().solve(A,B,C));
    }


    private static final int MOD = 1_000_000_007;

    public int solve(int A, int B, int C) {
        long low = 1, high = (long) A * Math.min(B, C);
        long lcm = lcm(B, C);

        while (low < high) {
            long mid = low + (high - low) / 2;
            if (countMagical(mid, B, C, lcm) < A) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return (int) (low % MOD);
    }

    private long countMagical(long num, int B, int C, long lcm) {
        return (num / B) + (num / C) - (num / lcm);
    }

    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
