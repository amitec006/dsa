package org.example.dsa1.bitmanipulation;

public class HelpFromSam {
    public static void main(String[] args) {
        System.out.println(new HelpFromSam().solve(8549));
    }

    /**
     * Alex and Sam are good friends. Alex is doing a lot of programming these days. He has set a target score of A for himself.
     * Initially, Alex's score was zero. Alex can double his score by doing a question, or Alex can seek help from Sam for doing questions that will contribute 1 to Alex's score. Alex wants his score to be precisely A. Also, he does not want to take much help from Sam.
     *
     * Find and return the minimum number of times Alex needs to take help from Sam to achieve a score of A.
     * @param A
     * @return
     */
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
     * Alex wants to reach score A:
     *
     * He can double his score (score *= 2) — free
     *
     * He can ask Sam to add 1 to his score — costs help
     *
     * Goal:
     *
     * Reach exactly A
     *
     * Use minimum help from Sam (i.e., minimize number of +1 operations)
     *
     * This is equivalent to:
     *
     * Starting from A and working backward to 0
     *
     * Reversing operations:
     *
     * If A is even → previous step must have been a doubling ⇒ divide by 2
     *
     * If A is odd → previous step must have been a +1 from Sam ⇒ subtract 1 (increment help count)
     *
     * This is similar to counting the number of 1's in binary representation of A.
     *
     * ✅ Example
     * Let A = 18
     *
     * Binary: 10010
     *
     * Steps:
     *
     * 18 is even → divide by 2 → 9
     *
     * 9 is odd → subtract 1 (help) → 8
     *
     * 8 is even → divide by 2 → 4
     *
     * 4 is even → divide by 2 → 2
     *
     * 2 is even → divide by 2 → 1
     *
     * 1 is odd → subtract 1 (help) → 0
     *
     * Total times asked for help: 2 (when A was 9 and 1 → corresponds to 2 ones in binary 10010)
     */
    public int minHelpFromSam(int A) {
        int helpCount = 0;
        while (A > 0) {
            if (A % 2 == 1) {
                helpCount++; // Alex must have taken help
            }
            A = A / 2; // reverse of doubling
        }
        return helpCount;
    }
}
