package org.example.dsa1.bitmanipulation;

public class FindNumberOfGoodDays {

    /**
     * Alex has a cat named Boomer. He decides to put his cat to the test for eternity.
     *
     * He starts on day 1 with one stash of food unit, every next day, the stash doubles.
     *
     * If Boomer is well behaved during a particular day, only then she receives food worth equal to the stash produced on that day.
     *
     * Boomer receives a net worth of A units of food. What is the number of days she received the stash?
     */
    public static void main(String[] args) {
        System.out.println(new FindNumberOfGoodDays().solve(5));
    }

    public int solve(int A) {
        int cnt = 0;
        for (int i = 0 ; i < 31; i++) {
            if (((1 << i) & A) != 0) {
                cnt++;
            }
        }
        return cnt;
    }

    /**
     * On day 1, stash = 1
     *
     * On day 2, stash = 2
     *
     * On day 3, stash = 4
     *
     * ...
     *
     * On day i, stash = 2^(i-1)
     *
     * So, the total food Boomer receives = sum of selected powers of 2
     *
     * Given total food received = A, how many days did Boomer receive the stash?
     *
     * ➡️ That means: How many 1s are in binary representation of A
     *
     * ✅ Example
     * Let’s say A = 13
     *
     * Binary: 1101
     *
     * Boomer received food on day 1, 3, and 4
     *
     * 2⁰ = 1 → day 1
     *
     * 2² = 4 → day 3
     *
     * 2³ = 8 → day 4
     *
     * ➡️ Total = 1 + 4 + 8 = 13 ✅
     * ➡️ Number of days Boomer received stash = 3
     */

    public int daysBoomerReceivedFood(int A) {
        int count = 0;
        while (A > 0) {
            if ((A & 1) == 1) {
                count++;
            }
            A >>= 1;
        }
        return count;
    }
}
