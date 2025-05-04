package org.example.dsa1.math;

public class LargestCoPrimeDivisor {
    /**
     * You are given two positive numbers A and B .
     * You need to find the maximum valued integer X such that:
     *
     * X divides A i.e. A % X = 0
     * X and B are co-prime i.e. gcd(X, B) = 1
     */
    public static void main(String[] args) {
        System.out.println(new LargestCoPrimeDivisor().cpFact(5, 10)); // 5
    }

    public int cpFact(int A, int B) {
        while (gcd(A, B) != 1) {
            A = A / gcd(A, B);
        }
        return A;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
