package org.example.dsa1.bitmanipulation;

public class StrangeEquality {
    /**
     * Given an integer A.
     * Two numbers, X and Y, are defined as follows:
     *
     * X is the greatest number smaller than A such that the XOR sum of X and A is the same as the sum of X and A.
     * Y is the smallest number greater than A, such that the XOR sum of Y and A is the same as the sum of Y and A.
     * Find and return the XOR of X and Y.
     * @param args
     */
    public static void main(String[] args) {
        int A = 5;
        System.out.println(new StrangeEquality().solve(A));
    }

    public int solve(int A) {
        int bits = countBits(A);
        int x = toggle(A);
        int y = 1 << bits;

        return x ^ y;
    }

    private int countBits(int number)
    {

        // log function in base 2
        // take only integer part
        return (int)(Math.log(number) /
                Math.log(2) + 1);
    }

    private int toggle(int n) {

        // temporary variable to
        // use XOR with one of a n
        int temp = 1;

        // Run loop until the only
        // set bit in temp crosses
        // MST of n.
        while (temp <= n) {

            // Toggle bit of n
            // corresponding to
            // current set bit in
            // temp.
            n = n ^ temp;

            // Move set bit to next
            // higher position.
            temp = temp << 1;
        }
        return n;
    }
}
