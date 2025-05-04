package org.example.dsa1.bitmanipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class SumOfAllSubArray {
    public static void main(String[] args) {
        /*
        You are given an array of integers A of size N.

        The value of a subarray is defined as BITWISE OR of all elements in it.

        Return the sum of value of all subarrays of A % 109 + 7.
         */
        int[]  A = {347148,221001,394957,729925,276769,40726,552988,29952,184491,146773,418965,307,219145,183037,178111,81123,109199,683929,422034,346291,11434,7327,340473,316152,364005,359269,170935,105784,224044,22563,48561,165781,9329,357681,169473,175031,605611,374501,6607,329965,76068,836137,103041,486817,195549,107317,34399,56907,37477,189690,36796,376663,39721,177563,174179,183646,217729,408031,429122,631665,282941,526797,262186,306571,63613,57501,70685,226381,1338,9360,130360,20300,400906,87823,180349,108813,18181,119185,1,102611,63591,12889,311185,383896,8701,76077,75481,386017,153553,304913,383455,105948,142885,1,12610,137005,119185,16948,66171,123683};
        //int[] A = {1, 2, 3, 4, 5};
        System.out.println(new SumOfAllSubArray().solve(A));
    }


    /**
     *
     * Counting Subarrays Including A[i]
     *  Counting Start Positions
     *  A[i] can be part of any subarray that starts at or before i.
     *
     *  The possible start indices for these subarrays are:
     *  0, 1, 2, ..., i
     *
     *This means there are i+1 ways to choose a starting index for a subarray that includes A[i].
     *
     * Counting End Positions
     * A[i] can be part of any subarray that ends at or after i.
     * The possible end indices for these subarrays are:
     *              i, i+1, i+2, ..., n-1
     *
     * This means there are n-i ways to choose an end index for a subarray that includes A[i].
     *
     * Total Number of Subarrays Including A[i]
     *
     * To get the total number of subarrays that contain A[i], we multiply the number of ways to start and the number of ways to end:
     *
     * (i+1)×(N−i)
     *
     * This gives the count of subarrays in which A[i] appears.
     */

    public static long totalSubarraySum(int[] A) {
        int N = A.length;
        long totalSum = 0;

        for (int i = 0; i < N; i++) {
            long contribution = (long) A[i] * (i + 1) * (N - i);
            totalSum += contribution;
        }

        return totalSum;
    }

    public int solve(int[] arr) {
        int mod = 1000000007;
        int n = arr.length;
        long sum = 0;

        for (int bit = 0; bit < 32; bit++) {
            long count = 0;
            long total = 0;
            for (int i = 0; i < n; i++) {
                if ((arr[i] & (1 << bit)) != 0) {
                    count = i + 1;
                }
                total += count;
            }
            sum = (sum + total * (1 << bit)) % mod;
        }

        return (int) sum;
    }
}
