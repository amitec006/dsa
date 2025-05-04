package org.example.dsa1.bitmanipulation;

public class FromGivenArrayFineElementWithFrequencyOne {

    public static void main(String[] args) {
        int[] A = {1, 2, 2, 3, 1};
        System.out.println(new FromGivenArrayFineElementWithFrequencyOne().singleNumber(A));
    }

    public int singleNumber(final int[] A) {
        int num = A[0];
        for (int i = 1; i < A.length; i++) {
            num = num ^ A[i];
        }
        return num;
    }
}
