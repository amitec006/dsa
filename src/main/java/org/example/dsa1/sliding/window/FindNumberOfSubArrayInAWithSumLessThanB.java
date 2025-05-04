package org.example.dsa1.sliding.window;

import java.util.HashMap;


public class FindNumberOfSubArrayInAWithSumLessThanB {
    public static void main(String[] args) {
        int[] A = {1, 11, 2, 3, 6};
        int B = 11;
        int result = new FindNumberOfSubArrayInAWithSumLessThanB().solve2(A, B);
        System.out.println(result);
    }

    private int solve(int[] a, int b) {
        int sum = 0;
        int count = 0;
        int left = 0;

        for (int right = 0; right < a.length; right++) {
            sum += a[right];

            while (sum >= b) {
                sum -= a[left];
                left++;
            }

            count += right - left + 1;
        }
        return count;
    }


    // hashmap based approach will not work here, hashmap will work for exact match sum
    private int solve2(int[] A, int B) {
        int n = A.length;
        int sum = 0;
        int count = 0;
        int left = 0;

        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();

        for (int right = 0; right < n; right++) {
            sum += A[right]; // Expand window by adding A[right]

            // Move left pointer forward using HashMap logic instead of while loop
            if (prefixSumMap.containsKey(sum - B)) {
                left = Math.max(left, prefixSumMap.get(sum - B) + 1);
            }

            // Count valid subarrays ending at `right`
            count += (right - left + 1);

            // Store prefix sum in HashMap
            prefixSumMap.put(sum, right);
        }

        return count;
    }
}
