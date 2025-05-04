package org.example.dsa1.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DistinctNumberInWindow {
    /**
     * You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.
     *
     * Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.
     *
     * NOTE: if B > N, return an empty array.
     *
     *
     */

    public static void main(String[] args) {
        int[] A = {1, 2, 1, 3, 4, 3};
        int B = 3;
        int [] res = new DistinctNumberInWindow().dNums(A, B);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public int[] dNums(int[] A, int B) {
        int[] res = new int[A.length - B + 1];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < B; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        for (int i = B; i <= A.length; i++) {
            res[i - B] = map.size();
            if (map.get(A[i - B]) == 1) {
                map.remove(A[i - B]);
            } else {
                map.put(A[i - B], map.get(A[i - B]) - 1);
            }
            if (i < A.length) {
                map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            }
        }
        return res;
    }

    public int[] dNums1(int[] A, int B) {
        int[] res = new int[A.length - B + 1];
        Set<Integer> set = new HashSet<>();
        for (int j = 0; j < B; j++) {
            set.add(A[j]);
        }
        res[0] = set.size();
        for (int i = B+1; i <= A.length; i++) {
            int right = i - 1;
            int left = i - B;
            set.remove(A[left-1]);
            while (left <= right) {
                set.add(A[left]);
                left++;
            }
            res[i - B] = set.size();
        }
        return res;
    }
}
