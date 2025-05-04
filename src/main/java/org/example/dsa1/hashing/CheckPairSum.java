package org.example.dsa1.hashing;

import java.util.HashSet;
import java.util.Set;

public class CheckPairSum {
    /**
     * Given an Array of integers B, and a target sum A.
     * Check if there exists a pair (i,j) such that Bi + Bj = A and i!=j.
     *
     * Return an integer value 1 if there exists such pair, else return 0.
     */

    public static void main(String[] args) {
        int A = 8;
        int[] B = {3, 5, 1, 2, 1, 2};
        System.out.println(new CheckPairSum().solve(A, B));
    }

    public int solve(int A, int[] B) {
        Set<Integer> set = new HashSet<>();
        set.add(B[0]);
        for (int i = 1; i < B.length; i++) {
            if (set.contains(A - B[i])) {
                return 1;
            }
            set.add(B[i]);
        }
        return 0;
    }
}

