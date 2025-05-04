package org.example.dsa1.bitmanipulation;

public class FindTwoMissingNumber {
    /**
     * Given an array A of length N where all the elements are distinct and are in the range [1, N+2].
     *
     * Two numbers from the range [1, N+2] are missing from the array A. Find the two missing numbers.
     */
    public static void main(String[] args) {
        int[] A = {1, 3, 5, 6};
        int[] result = new FindTwoMissingNumber().solve(A);
        for (int el : result) {
            System.out.print(el + " ");
        }
    }
    public int[] solve(int[] A) {
        int n = A.length;
        int xor = 0;
        for (int i = 1; i <= n + 2; i++) {
            xor ^= i;
        }
        for (int i = 0; i < n; i++) {
            xor ^= A[i];
        }
        int set_bit = xor & ~(xor - 1);
        int x = 0, y = 0;
        for (int i = 1; i <= n + 2; i++) {
            if ((i & set_bit) > 0) {
                x ^= i;
            } else {
                y ^= i;
            }
        }
        for (int i = 0; i < n; i++) {
            if ((A[i] & set_bit) > 0) {
                x ^= A[i];
            } else {
                y ^= A[i];
            }
        }
        if (x > y) {
            return new int[]{y, x};
        } else {
            return new int[]{x, y};
        }
    }
}
