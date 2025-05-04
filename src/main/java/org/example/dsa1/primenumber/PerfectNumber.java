package org.example.dsa1.primenumber;

public class PerfectNumber {
    /**
     * You are given an integer A. You have to tell whether it is a perfect number or not.
     *
     * Perfect number is a positive integer which is equal to the sum of its proper positive divisors.
     *
     * A proper divisor of a natural number is the divisor that is strictly less than the number.
     */
    public static void main(String[] args) {
        int n = 6;
        System.out.println(isPerfect(n));
    }

    private static boolean isPerfect(int n) {
        int sum = 1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    sum += i;
                } else {
                    sum += i + n / i;
                }
            }
        }
        return (sum == n);
    }
}
