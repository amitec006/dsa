package org.example;

public class RainWaterTrap {
    /**
     * Imagine a histogram where the bars' heights are given by the array A.
     * Each bar is of uniform width, which is 1 unit. When it rains,
     * water will accumulate in the valleys between the bars.
     *
     * Your task is to calculate the total amount of water that can be trapped in these valleys.
     *
     * Example:
     *
     * The Array A = [5, 4, 1, 4, 3, 2, 7] is visualized as below.
     * The total amount of rain water trapped in A is 11.
     * @param args
     */
    public static void main(String[] args) {
        int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
        new RainWaterTrap().trap(A);
    }

    public int trap(final int[] A) {
        int[] left_max = new int[A.length];
        int[] right_max = new int[A.length];
        int start = 0;
        int end = A.length - 1;
        while (start < A.length) {
            if (start == 0) {
                left_max[start] = A[start];
            } else {
                left_max[start] = Math.max(left_max[start - 1], A[start]);
            }
            if (end == A.length - 1) {
                right_max[end] = A[end];
            } else {
                right_max[end] = Math.max(right_max[end + 1], A[end]);
            }
            start++;
            end--;
        }
        int sum = 0;
        for (int i = 1; i < A.length-1; i++) {
            int min = Math.min(left_max[i-1], right_max[i+1]);
            if (min > A[i]) {
                sum += min - A[i];
            }
        }
        return sum;
    }
}
