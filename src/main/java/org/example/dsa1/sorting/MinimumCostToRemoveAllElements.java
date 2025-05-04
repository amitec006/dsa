package org.example.dsa1.sorting;

import java.util.Arrays;
import java.util.Collections;

public class MinimumCostToRemoveAllElements {

    /**
     * Given an integer array A of size N. You can remove any element from the array in one operation.
     * The cost of this operation is the sum of all elements in the array present before this operation.
     *
     * Find the minimum cost to remove all elements from the array.
     */

    public static void main(String[] args) {
        int[] A = {4, 6, 2};
        System.out.println(minRemovalCost(A));
    }

    public static long minRemovalCost(int[] A) {
        Arrays.sort(A); // Sort in ascending order
        long totalSum = 0, cost = 0;

        // Calculate the total sum of the array
        for (int num : A) {
            totalSum += num;
        }

        // Remove elements in reverse order (largest first)
        for (int i = A.length - 1; i >= 0; i--) {
            cost += totalSum; // Add the cost before removing
            totalSum -= A[i]; // Remove the current element
        }

        return cost;
    }

}
