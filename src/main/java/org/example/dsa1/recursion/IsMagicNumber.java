package org.example.dsa1.recursion;

public class IsMagicNumber {
    /**
     * Given a number A, check if it is a magic number or not.
     *
     * A number is said to be a magic number if the sum of
     * its digits is calculated till a single digit recursively
     * by adding the sum of the digits after every addition.
     * If the single digit comes out to be 1, then the number is a magic number.
     *
     * Sum of digits of (83557) = 28
     *  Sum of digits of (28) = 10
     *  Sum of digits of (10) = 1.
     *  Single digit is 1, so it's a magic number. Return 1.
     */

    public static void main(String[] args) {
        int A = 83557;
        System.out.println(new IsMagicNumber().isMagic(A));
    }

    private boolean isMagic(int a) {
        if (a < 10) {
            return a == 1;
        }
        int sum = 0;
        while (a > 0) {
            sum += a % 10;
            a = a / 10;
        }
        return isMagic(sum);
    }
}
