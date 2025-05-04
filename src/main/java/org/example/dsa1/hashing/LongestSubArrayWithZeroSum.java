package org.example.dsa1.hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithZeroSum {
    /**
     * Given an array A of N integers.
     * Find the length of the longest subarray in the array which sums to zero.
     *
     * If there is no subarray which sums to zero then return 0.
     */

    public static void main(String[] args) {
        int[] A = {1, -2, 1,0,-2, 2};
        System.out.println(new LongestSubArrayWithZeroSum().solve(A));
    }

    public int solve(int[] A) {
        int n = A.length;
        Map<Long, Integer> map = new HashMap<>();
        long sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
            if (sum == 0) {
                maxLen = i + 1;
            } else {
                if (map.containsKey(sum)) {
                    maxLen = Math.max(maxLen, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
        }
        return maxLen;
    }
}
