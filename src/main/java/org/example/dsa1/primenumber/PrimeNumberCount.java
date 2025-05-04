package org.example.dsa1.primenumber;

public class PrimeNumberCount {
    /**
     * You will be given an integer n.
     * You need to return the count of prime numbers less than or equal to n
     */
    public static void main(String[] args) {
        int n = 19;
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean isPrime(int n) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    count++;
                } else {
                    count += 2;
                }
                if (count > 2) {
                    return false;
                }
            }
        }
        return (count == 2);
    }

}
