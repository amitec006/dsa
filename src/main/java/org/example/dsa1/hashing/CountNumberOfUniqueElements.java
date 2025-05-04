package org.example.dsa1.hashing;

import java.util.HashSet;
import java.util.Set;

public class CountNumberOfUniqueElements {
    /**
     * Given an array A of N integers, return the number of unique elements in the array.
     */

    public static void main(String[] args) {
        int[] A = {3, 3, 3, 9, 0, 1, 0};
        System.out.println(new CountNumberOfUniqueElements().solve(A)); // 6
    }

    public int solve(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i : A) {
            set.add(i);
        }
        return set.size();
    }
}
