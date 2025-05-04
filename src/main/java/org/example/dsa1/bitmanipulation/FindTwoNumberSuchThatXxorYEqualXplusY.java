package org.example.dsa1.bitmanipulation;

public class FindTwoNumberSuchThatXxorYEqualXplusY {
    /**
     * Given an integer A.
     * Two numbers, X and Y, are defined as follows:
     *
     * X is the greatest number smaller than A such that the XOR sum of X and A is the same as the sum of X and A.
     * Y is the smallest number greater than A, such that the XOR sum of Y and A is the same as the sum of Y and A.
     * Find and return the XOR of X and Y.
     *
     * NOTE 1: XOR of X and Y is defined as X ^ Y where '^' is the BITWISE XOR operator.
     */

    public static void main(String[] args) {
        int A = 5;
        System.out.println(new FindTwoNumberSuchThatXxorYEqualXplusY().solve(A));
    }

    public int solve(int A) {
        int max = 1;
        int i = 1;
        while (max < A) {
            max = max<<i;
        }
        int count = 0;
        for (int j = 0; j < 31; j++) {
             int res = A & (1<<j);
             if (res != 0) {
                 count = j;
             }
        }
        int y = 1 << (count+1);

        return max ^ 1;
    }
}
