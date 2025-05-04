package org.example.dsa1.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArrayWithGivenSum {
    /**
     * Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
     *
     * If the answer does not exist return an array with a single integer "-1".
     *
     * First sub-array means the sub-array for which starting index in minimum.
     *
     * Return the first continuous sub-array which adds to B
     * and if the answer does not exist return an array with a single integer "-1".
     */

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int B = 100;
        int[] result = new SubArrayWithGivenSum().solve(A, B);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public int[] solve(int[] A, int B) {
        int n = A.length;
        long sum = 0;
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (A[i] == B) {
                return new int[]{A[i]};
            }
            sum += A[i];
            if (sum == B) {
                return Arrays.copyOfRange(A, 0, i + 1);
                //return new int[]{A[0], A[i]};
            }
            if (map.containsKey(sum - B)) {
                return Arrays.copyOfRange(A, map.get(sum - B) + 1, i + 1);
                //return new int[]{A[map.get(sum - B) + 1], A[i]};
            }
            map.put(sum, i);
        }
        return new int[]{-1};
    }

    public static ArrayList<Integer> findSubarray(int[] A, int B) {
        int left = 0, right = 0, sum = 0;
        int n = A.length;

        ArrayList<Integer> result = new ArrayList<>();

        while (right < n) {
            sum += A[right]; // Expand window

            // Shrink window if sum exceeds B
            while (sum > B && left <= right) {
                sum -= A[left];
                left++;
            }

            // Check if sum equals B
            if (sum == B) {
                for (int i = left; i <= right; i++) {
                    result.add(A[i]);
                }
                return result;
            }

            right++; // Move to the next element
        }

        // If no subarray is found
        result.add(-1);
        return result;
    }

}
