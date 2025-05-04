package org.example.dsa1.basicarray;

public class FindSecondLargest {
    /**
     * You are given an integer array A.
     * You have to find the second largest
     * element/value in the array or report that no such element exists.
     */
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        int result = new FindSecondLargest().solve(A);
        System.out.println(result);
    }

    private int solve(int[] a) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int el : a) {
            if (el > max) {
                secondMax = max;
                max = el;
            } else if (el > secondMax && el != max) {
                secondMax = el;
            }
        }
        return secondMax == Integer.MIN_VALUE ? -1 : secondMax;
    }


}
