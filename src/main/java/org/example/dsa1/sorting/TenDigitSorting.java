package org.example.dsa1.sorting;

import java.util.Arrays;

public class TenDigitSorting {
    /**
     * Given an array A of N integers. Sort the array in increasing
     * order of the value at the tens place digit of every number.
     *
     * If a number has no tens digit, we can assume value to be 0.
     * If 2 numbers have same tens digit, in that case number with max value will come first
     * Solution should be based on comparator.
     */

    public static void main(String[] args) {
        int[] A = {15, 11, 7, 19};
        int[] result = new TenDigitSorting().solve(A);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public int[] solve(int[] A) {
        Integer[] array = new Integer[A.length];
        for (int i = 0; i < A.length; i++) {
            array[i] = A[i];
        }
        Arrays.sort(array, (a, b) -> {
            int tensA = getTensDigit(a);
            int tensB = getTensDigit(b);
            if (tensA == tensB) {
                return b - a;
            }
            return tensA - tensB;
        });
        for (int i = 0; i < A.length; i++) {
            A[i] = array[i];
        }
        return A;
    }

    private int getTensDigit(Integer a) {
        return (a / 10) % 10;
    }

}
