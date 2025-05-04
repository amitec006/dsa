package org.example.dsa1.carryForwardandcontributiontechnique;

public class FindNumberOfSubArrayInAWithSumLessThanB {

    /**
     * Given an array A of N non-negative numbers and a non-negative number B,
     * you need to find the number of subarrays in A with a sum less than B.
     * We may assume that there is no overflow.
     */

    public static void main(String[] args) {
        int[] A = {1, 11, 2, 3, 15};
        int B = 10;
        int result = new FindNumberOfSubArrayInAWithSumLessThanB().solve2(A, B);
        System.out.println(result);
    }

    public int solve(int[] A, int B) {
        int n = A.length;
        int count = 0;
        int sum = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
            while (sum >= B) {
                sum -= A[j];
                j++;
            }
            count += i - j + 1;
        }
        return count;
    }

    public int solve2(int[] A, int B) {
        int n = A.length;
        int count = 0;
        int sum = 0;
        int start = 0;
        int end = 0;

        while (end < n) {
            sum += A[end];
            if (sum < B) {
                count += end - start + 1;
            } else {
                while (sum >= B) {
                    sum -= A[start];
                    start++;
                }
                count += end - start + 1;
            }
            end++;
        }

        return count;
    }
}
