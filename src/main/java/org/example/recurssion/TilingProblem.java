package org.example.recurssion;

public class TilingProblem {
    /**
     * We have given 4 * N size area and tile of size 4 * 1 ,
     * write code to number of way to fit tile in that area,
     * we can place tile either horizontally or vertically
     */

    public static void main(String[] args) {
        System.out.println(new TilingProblem().solve(10));
    }

    private int solve(int n) {
        if (n == 0 || n == 1 || n == 2 || n == 3) {
            return 1;
        }
        if (n == 4) {
            return 2;
        }

        return solve(n-1) + solve(n-4);
    }
}
