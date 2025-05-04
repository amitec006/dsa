package org.example;

public class AddOneToArray {
    /**
     * Given a non-negative number represented as an array of digits,
     * add 1 to the number ( increment the number represented by the digits ).
     *
     *
     * The digits are stored such that the most significant digit is at the head of the list.
     *
     * NOTE: Certain things are intentionally left unclear in this question which you should practice
     * asking the interviewer. For example: for this problem, the following are some good questions to ask :
     *
     * Q: Can the input have 0's before the most significant digit. Or, in other words, is 0 1 2 3 a valid input?
     * A: For the purpose of this question, YES
     * Q: Can the output have 0's before the most significant digit? Or, in other words, is 0 1 2 4 a valid output?
     * A: For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
     *
     *
     * Given vector is [1, 2, 3].
     * The returned vector should be [1, 2, 4] as 123 + 1 = 124.
     * @param args
     */
    public static void main(String[] args) {
        int[] A = {0,1,9,9};
        int[] B = new AddOneToArray().plusOne(A);
        for (int i : B) {
            System.out.print(i + " ");
        }
    }

    private int[] plusOne(int[] A) {
        int carry = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            int sum = A[i] + carry;
            if (sum > 9) {
                A[i] = 0;
                carry = 1;
            } else {
                A[i] = sum;
                carry = 0;
            }
        }
        int[] res;
        if (carry == 1) {
            int[] result = new int[A.length + 1];
            result[0] = 1;
            for (int i = 1; i < result.length; i++) {
                result[i] = A[i-1];
            }
            res = result;
        } else {
            res = A;
        }

        if (res[0] == 0){
            int i = 0;
            while (i < res.length && res[i] == 0) {
                i++;
            }
            int[] result = new int[res.length - i];
            for (int j = 0; j < result.length; j++) {
                result[j] = res[i+j];
            }
            return result;
        } else {
            return res;
        }
    }
}
