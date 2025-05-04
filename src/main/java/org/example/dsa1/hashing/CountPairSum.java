package org.example.dsa1.hashing;

import java.util.HashMap;
import java.util.Map;

public class CountPairSum {
    /**
     * You are given an array A of N integers and an integer B.
     * Count the number of pairs (i,j) such that A[i] + A[j] = B and i ≠ j.
     *
     * Since the answer can be very large, return the remainder after dividing the count with 109+7.
     *
     * Note - The pair (i,j) is same as the pair (j,i) and we need to count it only once.
     */
    public static void main(String[] args) {
        int[] A = {1, 2, 1, 2};
        int B = 3;
        System.out.println(new CountPairSum().solve(A, B));
    }

    public int solve(int[] A, int B) {
        Map<Long, Long> map = new HashMap<>();
        long count = 0;
        long mod = 1000000007;
        for (int j : A) {
            long diff = B - j;
            if (map.containsKey(diff)) {
                count = (count + map.get(diff)) % mod;
            }
            map.put((long) j, map.getOrDefault((long) j, 0L) + 1);
        }
        return (int) count;
    }
}
