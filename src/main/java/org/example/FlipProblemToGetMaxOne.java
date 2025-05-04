package org.example;

public class FlipProblemToGetMaxOne {
    /**
     * You are given a binary string A(i.e., with characters 0 and 1)
     * consisting of characters A1, A2, ..., AN. In a single operation,
     * you can choose two indices, L and R, such that 1 ≤ L ≤ R ≤ N and
     * flip the characters AL, AL+1, ..., AR. By flipping, we mean changing character 0 to 1 and vice-versa.

     * Your aim is to perform ATMOST one operation such that in the final string number of 1s is maximized.
     *
     * If you don't want to perform the operation, return an empty array. Else,
     * return an array consisting of two elements denoting L and R. If there are multiple solutions,
     * return the lexicographically smallest pair of L and R.
     *
     * NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
     * @param args
     *
     * A = "010"
     *
     * Pair of [L, R] | Final string
     * _______________|_____________
     * [1 1]          | "110"
     * [1 2]          | "100"
     * [1 3]          | "101"
     * [2 2]          | "000"
     * [2 3]          | "001"
     *
     * We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].
     */
    public static void main(String[] args) {
        String A = "11110000000";//
        int[] arr = new FlipProblemToGetMaxOne().flip(A);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public int[] flip(String A) {
        if (!A.contains("0")) {
            return new int[0];
        }
        int max_so_far = 0;
        int curr_sum = 0;
        int l = 0;
        int r = 0;
        int[] res = new int[2];
        for (int i =0; i<A.length(); i++) {
            if(A.charAt(i) == '1') {
                curr_sum -= 1;
            } else {
                curr_sum += 1;
            }
            if (curr_sum < 0) {
                curr_sum = 0;
                l = i + 1;
                r = i + 1;
            } else {
                r += 1;
            }
            if (curr_sum > max_so_far) {
                max_so_far = curr_sum;
                res[0] = l+1;
                res[1] = r;
            }
        }
        if (max_so_far == 0) {
            return new int[0];
        } else {
            return res;
        }
    }
}
