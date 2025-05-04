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
}
