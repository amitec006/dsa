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
        System.out.println(new RainWaterTrap().trap(A));
    }

    public int trap(final int[] A) {
        int[] left_max = new int[A.length];
        int[] right_max = new int[A.length];
        int n = A.length;
        int start = 0, end = n - 1;
        while (start < n) {
            left_max[start] = (start == 0) ? A[start] : Math.max(left_max[start - 1], A[start]);
            right_max[end] = (end == n - 1) ? A[end] : Math.max(right_max[end + 1], A[end]);
            start++;
            end--;
        }

        /**
         * ignore the first and last element because they can’t trap water.
         *
         * For each bar i, the water that can be trapped above it is:
         *
         * min(left of i, right of i) - height at i, only if min > A[i].
         */
        int sum = 0;
        for (int i = 1; i < n-1; i++) {
            int min = Math.min(left_max[i-1], right_max[i+1]);
            if (min > A[i]) {
                sum += min - A[i];
            }
        }
        return sum;
    }
}
