package org.example.dsa1.hashing;

import java.util.HashMap;
import java.util.Map;

public class CountPairDifference {
    /**
     * You are given an array A of N integers and an integer B.
     * Count the number of pairs (i,j) such that A[i] - A[j] = B and i ≠ j.
     *
     * Since the answer can be very large, return the remainder after dividing the count with 109+7.
     */
    public static void main(String[] args) {
        int[] A = {3, 5, 1, 2, 2, 6, 9};
        int B = 4;
        System.out.println(new CountPairDifference().solve(A, B)); // 2
    }

    public int solve(int[] A, int B) {
        int count = 0;
        int mod = 1000000007;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            if (map.containsKey(i + B)) {
                count += map.get(i + B);
                count %= mod;
            }
            if (map.containsKey(i - B)) {
                count += map.get(i - B);
                count %= mod;
            }
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return count % mod;
    }

    public int countPairsWithDiff(int[] A, int B) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int count = 0;

        // Count frequencies
        for (int num : A) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Count valid pairs
        for (int num : A) {
            int target = num - B;
            if (freqMap.containsKey(target)) {
                count += freqMap.get(target);
            }
        }

        return count;
    }

}

