package org.example.dsa1.carryForwardandcontributiontechnique;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClosestMinMax {
    /**
     * Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the maximum value of the array
     *
     * and at least one occurrence of the minimum value of the array.
     */

    public static void main(String[] args) {
        int[] A = {4,4,4,4,4};
        System.out.println(new ClosestMinMax().solve(A));
    }

    public int solve(int[] A) {
        int n = A.length;
        int min = A[0];
        int max = A[0];
        for (int i : A) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        if (min == max) {
            return 1;
        }
        int minIndex = -1;
        int maxIndex = -1;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (A[i] == min) {
                minIndex = i;
                if (maxIndex != -1) {
                    ans = Math.min(ans, Math.abs(maxIndex - minIndex) + 1);
                }
            } else if (A[i] == max) {
                maxIndex = i;
                if (minIndex != -1) {
                    ans = Math.min(ans, Math.abs(maxIndex - minIndex) + 1);
                }
            }
        }
        return ans;
    }
}
