package org.example.dsa1.basicarray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindGoodPairExistOrNot {
    /**
     * Given an array A and an integer B.
     * A pair(i, j) in the array is a good pair if i != j and
     * (A[i] + A[j] == B). Check if any good pair exist or not.
     */
    public static void main(String[] args) {
        int[] A = {1,2,3,4};
        int B = 7;
        System.out.println(new FindGoodPairExistOrNot().solve(A, B));
    }

    private int solve(int[] a, int b) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(b - a[i])) {
                return 1;
            }
            map.put(a[i], i);
        }
        return 0;
    }

    private int solve1(int[] a, int b) {
        a = Arrays.stream(a).sorted().toArray();
        for (int el :a) {
            int diff = b - el;
            if (Arrays.binarySearch(a, diff) >= 0) {
                return 1;
            }
        }
        return 0;
    }
}
