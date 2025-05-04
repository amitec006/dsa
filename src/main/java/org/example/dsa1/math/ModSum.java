package org.example.dsa1.math;

public class ModSum {
    /**
     * Calculate the frequency of all the elements from 1 to 1000.
     * For all values i from 1 to 1000 calculate sumi as sum of i % A[j] , where 1 <= j <= n
     * Sum of all such ((sumi) * (frequency of i)) would be the final answer.
     *
     * Given an array of integers A,
     * calculate the sum of A [ i ] % A [ j ] for all possible i, j pairs.
     * Return sum % (10^9 + 7) as an output.
     *
     * 1 <= length of the array A <= 105
     *
     * 1 <= A[i] <= 10^3
     */

    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        System.out.println(new ModSum().solve(A)); // 5
    }

    public int solve(int[] A) {
        int mod = 1000000007;
        long sum = 0;
        int[] freq = new int[1001];
        for (int i : A) {
            freq[i]++;
        }

        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j <= 1000; j++) {
                sum = (sum + (i % j) * freq[i] * freq[j]) % mod;
            }
        }
        return (int) sum;
    }
}
