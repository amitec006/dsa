package org.example.dsa1.basicarray;

public class ContinuousSumQuery {
    /**
     * There are A beggars sitting in a row outside a temple.
     * Each beggar initially has an empty pot. When the devotees come to the temple,
     * they donate some amount of coins to these beggars. Each devotee gives a
     * fixed amount of coin(according to their faith and ability) to some
     * K beggars sitting next to each other.
     *
     * Given the amount P donated by each devotee to the beggars ranging
     * from L to R index, where 1 <= L <= R <= A, find out the final
     * amount of money in each beggar's pot at the end of the day, provided
     * they don't fill their pots by any other means.
     * For ith devotee B[i][0] = L, B[i][1] = R, B[i][2] = P, given by the 2D array B
     *
     *
     * A = 5
     * B = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]
     * First devotee donated 10 coins to beggars ranging from 1 to 2. Final amount in each beggars pot after first devotee: [10, 10, 0, 0, 0]
     * Second devotee donated 20 coins to beggars ranging from 2 to 3. Final amount in each beggars pot after second devotee: [10, 30, 20, 0, 0]
     * Third devotee donated 25 coins to beggars ranging from 2 to 5. Final amount in each beggars pot after third devotee: [10, 55, 45, 25, 25]
     */

    public static void main(String[] args) {
        int A = 5;
        int[][] B = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int[] result = new ContinuousSumQuery().solve(A, B);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
    
    public int[] solve(int A, int[][] B) {
        int[] result = new int[A];
        for (int[] ints : B) {
            int start = ints[0];
            int end = ints[1];
            int coins = ints[2];
            result[start - 1] += coins;
            /**
             * Each range {start, end, amount} (1-based index) means:
             *
             * Add amount to every element from index start to end (inclusive).
             *
             * To do this in O(1) time per query:
             *
             * Instead of updating each element in [start-1, end-1], we:
             *
             * Add amount at result[start-1]
             *
             * Subtract amount at result[end] (i.e., the next element after the end)
             *
             * Later, when we do the prefix sum, this "deferred subtraction" stops the running total exactly after the range.
             *
             * 🔍 Why result[end] -= amount?
             * Let’s say you want to add +10 to elements from index 1 to 3 (1-based), i.e., positions 0 to 2 in 0-based indexing.
             *
             * result[0] += 10;  // start of range
             * result[3] -= 10;  // right after end of range
             * Then during prefix sum:
             *
             * index 0 → +10
             *
             * index 1 → +10
             *
             * index 2 → +10
             *
             * index 3 → no more +10 (it’s subtracted here)
             *
             * So the effect of amount stops at end.
             */
            if (end < A) {
                result[end] -= coins;
            }
        }
        for (int i = 1; i < A; i++) {
            result[i] += result[i - 1];
        }
        return result;
    }
}
