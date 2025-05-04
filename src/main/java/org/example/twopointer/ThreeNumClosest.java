package org.example.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeNumClosest {
    /**
     *Given an array A of N integers,
     * find three integers in A such that the sum is closest to a given number B.
     * Return the sum of those three integers.
     *
     * Assume that there will only be one solution.
     */

    public static void main(String[] args) {
        int[] A = {-1, 2, 1, -4};
        ArrayList<Integer> list = new ArrayList<>(A.length);
        for (int i = 0; i < A.length; i++) {
            list.add(A[i]);
        }
        int B = 1;

        System.out.println(new ThreeNumClosest().threeSumClosest(list, B));
    }

    public int threeSumClosest(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int n = A.size();
        int closestSum = A.get(0) + A.get(1) + A.get(2); // Initialize with first three elements

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;

            while (left < right) {
                int sum = A.get(i) + A.get(left) + A.get(right);

                // If this sum is closer to B, update closestSum
                if (Math.abs(B - sum) < Math.abs(B - closestSum)) {
                    closestSum = sum;
                }

                // Move pointers
                if (sum < B) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closestSum;
    }
}
