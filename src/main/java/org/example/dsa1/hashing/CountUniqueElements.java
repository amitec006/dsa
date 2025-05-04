package org.example.dsa1.hashing;

import java.util.HashMap;
import java.util.Map;

public class CountUniqueElements {
    /**
     * You are given an array A of N integers. Return the count of elements with frequncy 1 in the given array.
     */
    public static void main(String[] args) {
        int[] A = {3, 3, 3, 9, 0, 1, 0};
        System.out.println(new CountUniqueElements().solve(A)); // 3
    }

    public int solve(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int count = 0;
        for (int i : map.keySet()) {
            if (map.get(i) == 1) {
                count++;
            }
        }
        return count;
    }

}
