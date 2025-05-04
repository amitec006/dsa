package org.example.stack;

import java.util.Deque;
import java.util.LinkedList;

public class SumOfMaxMinSubarrays {
    public static int sumOfMaxMin(int[] A) {
        int n = A.length;
        long sum = 0;
        int mod = 1000000007;

        for (int k = 1; k <= n; k++) { // Window sizes
            Deque<Integer> minDeque = new LinkedList<>();
            Deque<Integer> maxDeque = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                // Remove out-of-bound elements for minDeque
                if (!minDeque.isEmpty() && minDeque.peekFirst() <= i - k) {
                    minDeque.pollFirst();
                }
                // Remove out-of-bound elements for maxDeque
                if (!maxDeque.isEmpty() && maxDeque.peekFirst() <= i - k) {
                    maxDeque.pollFirst();
                }

                // Maintain minDeque (increasing order)
                while (!minDeque.isEmpty() && A[minDeque.peekLast()] >= A[i]) {
                    minDeque.pollLast();
                }
                minDeque.offerLast(i);

                // Maintain maxDeque (decreasing order)
                while (!maxDeque.isEmpty() && A[maxDeque.peekLast()] <= A[i]) {
                    maxDeque.pollLast();
                }
                maxDeque.offerLast(i);

                // Start summing results when we reach window size
                if (i >= k - 1) {
                    sum = (sum + A[minDeque.peekFirst()] + A[maxDeque.peekFirst()]) % mod;
                }
            }
        }

        return (int) sum;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 2, 5, 4};
        System.out.println(sumOfMaxMin(A)); // Output: sum of all min + max values for subarrays
    }
}
