package org.example.dsa1.bitmanipulation;

public class FindNthMagicNumber {
    public static void main(String[] args) {
        int  A = 10;
        System.out.println(new FindNthMagicNumber().solve(A));
    }

    public int solve(int A) {
        double ans = 0;
        int i = 1;
        while ( A > 0) {
            int rem = A % 2;
            A = A / 2;
            ans = (rem * (Math.pow(5, i))) + ans;
            i++;
        }
        return (int) ans;
    }


    /**
     * To find the A-th magic number:
     *
     * Convert A to binary (e.g., A = 3 → binary = 11)
     *
     * For each bit from right to left:
     *
     * If bit is 1, include 5^i in the sum, where i is the bit position (starting from 1)
     *
     * 🔢 Magic Number Sequence Example
     * Let's list a few values of A and their magic numbers:
     *
     * A	Binary	Magic Number Calculation	Result
     * 1	1	5¹	5
     * 2	10	5²	25
     * 3	11	5² + 5¹	25 + 5 = 30
     * 4	100	5³	125
     * 5	101	5³ + 5¹	125 + 5 = 130
     */

    public int solve2(int A) {
        int power = 1;
        int ans = 0;

        while (A > 0) {
            if ((A & 1) == 1) { // if the rightmost bit is 1
                ans += (int) Math.pow(5, power); // add 5^power
            }
            power++;
            A = A >> 1; // right shift A
        }

        return ans;
    }
}
