package org.example.dsa1.primenumber;

public class CountFactor {
    /**
     * Given an integer A, you need to find the count of it's factors.
     *
     * Factor of a number is the number which divides it perfectly leaving no remainder.
     *
     * Example : 1, 2, 3, 6 are factors of 6
     */
    public static void main(String[] args) {
        int A = 6;
        System.out.println(new CountFactor().solve(A));
    }

    public int solve(int A) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(A); i++) {
            if (A % i == 0) {
                if (i == A/i) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }
}
