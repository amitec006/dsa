package org.example.dsa1.hashing;

import java.util.HashMap;
import java.util.Map;

public class FrequencyOfElementQuery {
    /**
     * Given an array A. You have some integers given in the array B.
     * For the i-th number, find the frequency of B[i] in the array A and return a list containing all the frequencies.
     *
     */

    public static void main(String[] args) {
        int[] A = {2, 5, 9, 2, 8};
        int[] B = {3, 2};
        int[] res = new FrequencyOfElementQuery().solve(A, B);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public int[] solve(int[] A, int[] B) {
        int[] res = new int[B.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i = 0; i < B.length; i++) {
            res[i] = map.getOrDefault(B[i], 0);
        }
        return res;
    }
}
