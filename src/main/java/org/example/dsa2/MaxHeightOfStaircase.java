package org.example.dsa2;

public class MaxHeightOfStaircase {
    /**
     * Given an integer A representing the number of square blocks. The height of each square block is 1. The task is to create a staircase of max-height using these blocks.
     *
     * The first stair would require only one block, and the second stair would require two blocks, and so on.
     *
     * Find and return the maximum height of the staircase.
     */

    public static void main(String[] args) {
        int A = 1000000000;
        System.out.println(new MaxHeightOfStaircase().solve(A));
    }

    public int solve(int A) {
        //return  (-1+(int)Math.sqrt(1+8.0*A))/2;
        long low = 0;
        long high = A;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long sum = mid * (mid + 1) / 2;
            if (sum == A) {
                return (int) mid;
            } else if (sum < A) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int) high;
    }

}
