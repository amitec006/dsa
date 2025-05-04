package org.example.dsa1.hashing;

import java.util.HashMap;
import java.util.Map;

public class FirstRepeatingElement {
    /**
     * Given an integer array A of size N, find the first repeating element in it.
     *
     * We need to find the element that occurs more than once and whose index of the first occurrence is the smallest.
     *
     * If there is no repeating element, return -1.
     */

    public static void main(String[] args) {
        int[] A = {10, 5, 3, 4, 3, 5, 6};
        System.out.println(new FirstRepeatingElement().solve(A)); // 5
    }

    public int solve(int[] A) {
        int minIndex = Integer.MAX_VALUE;
        int res = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                if (map.get(A[i]) < minIndex) {
                    minIndex = map.get(A[i]);
                    res = A[i];
                }
            } else {
                map.put(A[i], i);
            }
        }
        return res;
    }
}
