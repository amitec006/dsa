package org.example.dsa1.bitmanipulation;

public class EveryElementsAppearThriceExceptOneFindThatNumber {
    /**
     * Given an array of integers, every element appears thrice except for one, which occurs once.
     *
     * Find that element that does not appear thrice.
     *
     * NOTE: Your algorithm should have a linear runtime complexity.
     *
     * Could you implement it without using extra memory?
     */
    public static void main(String[] args) {
       int[] A = {890,992,172,479,973,901,417,215,901,283,788,102,726,609,379,587,630,283,10,707,203,417,382,601,713,290,489,374,203,680,108,463,290,290,382,886,584,406,809,601,176,11,554,801,166,303,308,319,172,619,400,885,203,463,303,303,885,308,460,283,406,64,584,973,572,194,383,630,395,901,992,973,938,609,938,382,169,707,680,965,726,726,890,383,172,102,10,308,10,102,587,809,460,379,713,890,463,108,108,811,176,169,313,886,400,319,22,885,572,64,120,619,313,3,460,713,811,965,479,3,247,886,120,707,120,176,374,609,395,811,406,809,801,554,3,194,11,587,169,215,313,319,554,379,788,194,630,601,965,417,788,479,64,22,22,489,166,938,66,801,374,66,619,489,215,584,383,66,680,395,400,166,572,11,992};
         System.out.println(new EveryElementsAppearThriceExceptOneFindThatNumber().singleNumber(A));

    }

    /**
     * For each bit position (0 to 31):
     *
     * Count how many numbers in the array have that bit set (1)
     *
     * If the total count at that bit position is not a multiple of 3, then the unique number has that bit set
     *
     * Set that bit in the result
     *
     * This works because numbers appearing 3 times will cancel out, and only the unique number’s bits will remain.
     * @param A
     * @return
     */

    public int singleNumber(final int[] A) {
        int result = 0;
        for (int i = 0;i < 32; i++) {
            int count = 0;
            int mask = 1 << i;
            for (int k : A) {
                if ((k & mask) != 0) {
                    count++;
                }
            }
            if (count % 3 != 0) {
                result = result | 1 << i;
            }
        }
        return result;
    }

    public int singleNumber2(final int[] A) {
        int ones = 0, twos = 0;
        int common_bit_mask;
        for (int i = 0; i < A.length; i++) {
            twos = twos | (ones & A[i]);
            ones = ones ^ A[i];
            common_bit_mask = ~(ones & twos);
            ones &= common_bit_mask;
            twos &= common_bit_mask;
        }
        return ones;
    }
}
