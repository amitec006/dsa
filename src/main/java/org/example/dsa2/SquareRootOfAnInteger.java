package org.example.dsa2;

public class SquareRootOfAnInteger {
    /**
     * Given an integer A. Compute and return the square root of A.
     * If A is not a perfect square, return floor(sqrt(A)).
     *
     * NOTE:
     *    The value of A*A can cross the range of Integer.
     *    Do not use the sqrt function from the standard library.
     *    Users are expected to solve this in O(log(A)) time.
     */

    public static void main(String[] args) {
        int A = 2147483647;
        System.out.println(new SquareRootOfAnInteger().sqrt(A));
    }

    public int sqrt(int A) {
        long low = 1;
        long high = A;
        long result = 0;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long square = mid * mid;
            if (square == A) {
                return (int)mid;
            } else if (square < A) {
                low = mid + 1;
                result = mid;
            } else {
                high = mid - 1;
            }
        }
        return (int)result;
    }
}
