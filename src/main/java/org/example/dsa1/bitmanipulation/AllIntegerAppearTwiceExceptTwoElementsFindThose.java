package org.example.dsa1.bitmanipulation;

public class AllIntegerAppearTwiceExceptTwoElementsFindThose {
    /**
     Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
     Find the two integers that appear only once.

     Note: Return the two numbers in ascending order.
     */

    public static void main(String[] args) {
        int[] A = {3857,21351,23083,3857,19441,2102,15569,11685,2102,21351,161,11685,161,6305,6305,19441,15569,8245};

        AllIntegerAppearTwiceExceptTwoElementsFindThose obj = new AllIntegerAppearTwiceExceptTwoElementsFindThose();
        int[] result = obj.solve(A);
        for (int el : result) {
            System.out.print(el + " ");
        }
    }

    public int[] solve(int[] A) {
        int res = 0;
        for (int j : A) {
            res = res ^ j;
        }
        int pos = 0;
        int i= 0;
        while (true) {
            int r = res & (1 << i);
            if (r != 0) {
                pos = i;
                break;
            }
            i++;
        }

        int jthSetBit = 0;
        int jthUnsetBit = 0;

        for (int j : A) {
            if ((j & (1 << pos)) != 0) {
                jthSetBit = jthSetBit ^ j;
            } else {
                jthUnsetBit = jthUnsetBit ^ j;
            }

        }
        if (jthSetBit < jthUnsetBit) {
            return new int[]{jthSetBit, jthUnsetBit};
        } else {
            return new int[]{jthUnsetBit, jthSetBit};
        }
    }

    /**
     * XOR all elements in the array
     *
     * The result will be X ^ Y (where X and Y are the two unique numbers), because duplicates cancel out.
     *
     * Find the rightmost set bit (any set bit) in X ^ Y
     *
     * This bit must differ between X and Y → use it to separate numbers into two groups
     *
     * Divide the array into 2 groups:
     *
     * Group 1: Numbers with that bit set
     *
     * Group 2: Numbers with that bit not set
     *
     * XOR each group separately
     *
     * Duplicates cancel out → you'll be left with X in one group and Y in the other
     * @param A
     * @return
     */

    public int[] singleNumber(final int[] A) {
        int xor = 0;

        // Step 1: XOR all elements → gives X ^ Y
        for (int num : A) {
            xor ^= num;
        }

        // Step 2: Find rightmost set bit (mask)
        int mask = xor & -xor;

        int x = 0, y = 0;

        // Step 3: Divide numbers into two groups based on the mask bit
        for (int num : A) {
            if ((num & mask) == 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }

        // Step 4: Return in sorted order
        return x < y ? new int[]{x, y} : new int[]{y, x};
    }

}
