package org.example.dsa1.hashing;

import java.util.HashMap;
import java.util.Map;

public class CountSubArrayCountWhichSumIsZero {

    /**
     * Given an array A of N integers.
     *
     * Find the count of the subarrays in the array which sums to zero.
     * Since the answer can be very large,
     * return the remainder on dividing the result with 109+7
     *
     * Since we are looking subarrays with sum = 0. Let’s try to create a pSum[] and let’s have some observation.
     *
     * pSum[i] = Sum of all elements from index 0 to index i.
     *
     * A[] = [4, 8, 3, 6, -5, -4, 7, -2, 1, -6, 2]
     *
     * pSum[] = [4, 12, 15, 21, 16, 12, 19, 17, 18, 12, 14]
     *
     * Here, sum of elements from index 0 to 1 is 12, and from index 0 to 5 is also 12. That means sum of elements from index 2 to 5 is zero.
     *
     * 12 is again present at index 9 and since it has appeared 2 times before it.
     *
     * That means there are two more subarrays with sum = 0, subarray from index 2 to 9 and subarray from index 6 to 9.
     *
     * So, we should keep a track of the number of times an element has appeared in pSum[]. For this, we can use hashmap/dictionary.
     *
     * If an element has appeared x number of times in pSum[] and it is again appearing for (x+1)th time, the answer must be incremented by x.
     */

    public static void main(String[] args) {
        int[] A = {1, -1, -2, 2};
        System.out.println(new CountSubArrayCountWhichSumIsZero().solve(A)); // 3
    }

    public int solve(int[] A) {
        int count = 0;
        int sum = 0;
        int mod = 1000000007;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int j : A) {
            sum += j;
            if (map.containsKey(sum)) {
                count = (count + map.get(sum)) % mod;
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }
        return count;
    }
}