package org.example.dsa1.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindCommonElementsAmongTwoArray {
    /**
     * Given two integer arrays, A and B of size N and M, respectively. Your task is to find all the common elements in both the array.
     *
     * NOTE:
     *
     * Each element in the result should appear as many times as it appears in both arrays.
     * The result can be in any order.
     */
    public static void main(String[] args) {
        int[] A = {2, 1, 4, 10, 10};
        int[] B = {3, 6, 2, 10, 10};
        int[] res = new FindCommonElementsAmongTwoArray().solve(A, B);
        for (int i : res) {
            System.out.print(i + " ");
        }

    }

    public int[] solve(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return findCommonElements(B, map);
    }

    private int[] findCommonElements(int[] b, Map<Integer, Integer> map) {
        List<Integer> list = new ArrayList<>();
        for (int i : b) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) - 1);
                list.add(i);
                if (map.get(i) == 0) {
                    map.remove(i);
                }
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
